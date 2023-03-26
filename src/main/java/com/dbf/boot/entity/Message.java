package com.dbf.boot.entity;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.springframework.stereotype.Component;

@XStreamAlias("xml")
public class Message {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private  String fromUserName;
    @XStreamAlias("CreateTime")
    private long createTime;
    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("Content")
    private String content;
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }



    public String getToUserName() {
        return toUserName;
    }

    public Message setToUserName(String toUserName) {
        this.toUserName = toUserName;
        return this;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public Message setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public Message setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }



    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime=" + createTime +
                ", msgType='" + msgType + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
