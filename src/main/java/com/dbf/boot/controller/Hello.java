package com.dbf.boot.controller;


import com.dbf.boot.utils.Message;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.*;



import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
public class Hello {


    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/")
    public String validate(@RequestParam(name = "signature", required = false) String signature,
                           @RequestParam(name = "timestamp", required = false) String timestamp,
                           @RequestParam(name = "nonce", required = false) String nonce,
                           @RequestParam(name = "echostr", required = false) String echostr) {
        String token = "dabenfeng";

        final List<String> list = Arrays.asList(token, timestamp, nonce);

        Collections.sort(list);

        StringBuilder stringBuilder = new StringBuilder();

        for (String s : list) {
            stringBuilder.append(s);
        }
        try {
            final MessageDigest sha1 = MessageDigest.getInstance("sha1");
            final byte[] digest = sha1.digest(stringBuilder.toString().getBytes());
            StringBuilder sum = new StringBuilder();
            for (byte b : digest) {
                //                获取b的高四位，15的二进制为00001111
                sum.append(Integer.toHexString((b >> 4) & 15));
                //                获取b的低四位
                sum.append(Integer.toHexString(b & 15));
            }
            if (!signature.isEmpty() && signature.equals(sum.toString())) {
                return echostr;
            }
            return echostr;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/")
    public String receiveMessage(HttpServletRequest request) throws Exception {

        InputStream inputStream = request.getInputStream();
        Map<String, String> msgMap = new HashMap<>();
//        reader对象用于获取xml
        SAXReader reader = new SAXReader();
//        获取消息流
        final Document read = reader.read(inputStream);
//        获取xml根节点
        Element rootElement = read.getRootElement();
//        获取所有节点
        List<Element> elements = rootElement.elements();
//        获取节点信息
        for (Element element : elements) {
            msgMap.put(element.getName(), element.getStringValue());
        }

        final String replayMessage = Message.getReplayMessage(msgMap);

        return replayMessage;
    }
}
