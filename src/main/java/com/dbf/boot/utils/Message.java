package com.dbf.boot.utils;

import com.thoughtworks.xstream.XStream;

import java.util.Map;


public class Message  {

//    private static <T> T  getMapValue(Map<String, T> map, String mapKeyName){
//        return map.get(mapKeyName);
//    }


    public static String getReplayMessage(Map<String, String> map) {
        com.dbf.boot.entity.Message message = new com.dbf.boot.entity.Message();
        message.setContent("欢迎来看大笨峰")
                .setCreateTime(System.currentTimeMillis()/1000)
                .setFromUserName(map.get("ToUserName"))
                .setToUserName(map.get("FromUserName"))
                .setMsgType("text");

        final XStream xStream = new XStream();
        xStream.processAnnotations(message.getClass());
        return xStream.toXML(message);
    }
}
