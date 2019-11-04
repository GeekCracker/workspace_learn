package com.springboot.learn.rabbitmq.domain;

import java.util.Date;

public class Message extends BaseEntity{

    /**消息头*/
    private String header;

    /**消息体*/
    private String body;

    /**时间*/
    private Date date;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "header='" + header + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }
}
