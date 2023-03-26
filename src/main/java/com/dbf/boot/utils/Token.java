package com.dbf.boot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Token {
    private final static String APP_ID = "wxd28e8e9c470280bb";
    private final static String APP_SECRET = "85285df04525c6efc48810053f3e7e0b";
    private final static String url ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APP_ID+"&secret="+APP_SECRET;
    private static com.dbf.boot.entity.Token TOKEN ;
//远程获取token
    private static void getToken() throws JsonProcessingException {
        final String tokenStr = HttpRequest.getReq(url);
        ObjectMapper mapper = new ObjectMapper();

        com.dbf.boot.entity.Token tokenObj = mapper.readValue(tokenStr, com.dbf.boot.entity.Token.class);

        TOKEN = tokenObj;

    }
//    判断是否需要获取token
    public static  String getAccessToken() throws JsonProcessingException {
        if(TOKEN== null || TOKEN.isExpired()){
            getToken();
        }
        return TOKEN.getAccessToken();
    }

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println(getAccessToken());
        System.out.println(getAccessToken());
    }
}
