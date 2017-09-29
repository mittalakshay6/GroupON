package com;

public class TextMessage extends Message {
    String msg;
    TextMessage(String msg){
        this.msg=msg;
        this.setfDT();
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
