package com.vic.demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestResponse<T> {
    private static final Logger log = LoggerFactory.getLogger(RestResponse.class);
    private boolean success;
    private String errorCode;
    private String errorMsg;
    private T data;

    public RestResponse(T data) {
        this.data = data;
    }

    public RestResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public RestResponse(boolean success, String errorCode, String errorMsg) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static <T> RestResponse<T> success(T data) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(true);
        restResponse.setData(data);
        return restResponse;
    }

    public static <T> RestResponse<T> failed(String errorCode, String errorMsg) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(false);
        restResponse.setErrorCode(errorCode);
        restResponse.setErrorMsg(errorMsg);
        return restResponse;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public T getData() {
        return this.data;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public String toString() {
        return "RestResponse(success=" + this.isSuccess() + ", errorCode=" + this.getErrorCode() + ", errorMsg=" + this.getErrorMsg() + ", data=" + this.getData() + ")";
    }

    public RestResponse() {
    }
}
