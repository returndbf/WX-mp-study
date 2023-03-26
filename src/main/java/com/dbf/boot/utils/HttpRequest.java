package com.dbf.boot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


public class HttpRequest {
    final static RestTemplate restTemplate = new RestTemplate();

    public static String getReq(String url) {

        return restTemplate.getForObject(url, String.class);
    }

    public static String PostReq(String url,String requestJSONBody){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestJSONBody, headers);
        return restTemplate.postForObject(url,requestEntity,String.class);
    }


}
