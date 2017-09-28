package com;

public abstract class ResponseMessage extends Message {
    private boolean fRes=true;
    public abstract Object getResponseMessage();
    public boolean isfRes() {
        return fRes;
    }

}
