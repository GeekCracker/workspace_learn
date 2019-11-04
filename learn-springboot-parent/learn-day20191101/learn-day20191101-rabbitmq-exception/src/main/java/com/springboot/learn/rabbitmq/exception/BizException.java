package com.springboot.learn.rabbitmq.exception;

import com.springboot.learn.rabbitmq.response.MessageCode;

public class BizException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private MessageCode messageCode;

    public BizException(String message) {
        super(message);
    }

    public BizException(MessageCode messageCode){
        this.messageCode = messageCode;
    }

    public MessageCode getMessageCode() {
        return messageCode;
    }
}
