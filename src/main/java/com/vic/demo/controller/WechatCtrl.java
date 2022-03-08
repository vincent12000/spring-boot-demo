package com.vic.demo.controller;

import com.vic.demo.dto.WechatCodeToSessionDTO;
import com.vic.demo.dto.WechatUserLoginDTO;
import com.vic.demo.dto.WechatUserLoginResponseDTO;
import com.vic.demo.model.RestResponse;
import com.vic.demo.model.Test;
import com.vic.demo.property.WechatProperties;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.AlgorithmParameterSpec;

@RestController
@RequestMapping("/wechat")
public class WechatCtrl {

    @Autowired
    private WechatProperties wechatProperties;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/user/login")
    public String userLogin(@RequestBody WechatUserLoginDTO wechatUserLoginDTO) {

        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" + wechatProperties.getAppid() +
                "&secret=" + wechatProperties.getSecret() +
                "&js_code=" + wechatUserLoginDTO.getCode() +
                "&grant_type=authorization_code";

        ResponseEntity<WechatCodeToSessionDTO> res = restTemplate.getForEntity(url, WechatCodeToSessionDTO.class);
        String openId =  res.getBody().getOpenid();
        String sessionKey = res.getBody().getSessionKey();
        byte[] encryptedDataByte = Base64.decodeBase64(wechatUserLoginDTO.getEncryptedData());
        byte[] ivByte = Base64.decodeBase64(wechatUserLoginDTO.getIv());
        byte[] sessionKeyByte = Base64.decodeBase64(sessionKey);

        AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivByte);
        try {
            SecretKeySpec keySpec = new SecretKeySpec(sessionKeyByte, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            String decryptData = new String(cipher.doFinal(encryptedDataByte), StandardCharsets.UTF_8);
            System.out.println(decryptData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return openId;
    }
}
