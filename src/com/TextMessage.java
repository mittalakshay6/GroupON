package com;

public class TextMessage implements Message {
    String msg;
    boolean fIP=false;
    boolean fDT=true;
    TextMessage(String msg){
        this.msg=msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public boolean isfIP() {
        return fIP;
    }

    public boolean isfDT() {
        return fDT;
    }
}
