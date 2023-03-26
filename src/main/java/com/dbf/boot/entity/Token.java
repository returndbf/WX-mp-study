package com.dbf.boot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


public class Token {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private long expireIn;

    public String getAccessToken() {
        return accessToken;
    }

    public Token setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public long getExpireIn() {
        return expireIn;
    }

    public Token setExpireIn(long expireIn) {
        this.expireIn = System.currentTimeMillis() + expireIn * 1000;
        return this;
    }

    public boolean isExpired(){
        return System.currentTimeMillis() > this.getExpireIn();
    }
}
