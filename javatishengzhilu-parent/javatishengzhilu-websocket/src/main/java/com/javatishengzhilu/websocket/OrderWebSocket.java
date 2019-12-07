package com.javatishengzhilu.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/test")
@Component
public class OrderWebSocket  {

    @OnOpen
    public void onOpen(Session session) {
        try {
            while (true){
                session.getBasicRemote().sendText("连接成功");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message){

    }
}
