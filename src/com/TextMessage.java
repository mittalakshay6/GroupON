package com;

public class TextMessage implements Message {
    String msg;
    TextMessage(String msg){
        this.msg=msg;
    }
    @Override
    public Message performAction() {
        System.out.println(msg);
        return this;
    }
}
