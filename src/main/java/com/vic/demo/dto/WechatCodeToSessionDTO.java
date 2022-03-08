package com.vic.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WechatCodeToSessionDTO {

    @JsonProperty("session_key")
    private String sessionKey;

    private String openid;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
