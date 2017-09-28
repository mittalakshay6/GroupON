package com;

public abstract class ResponseMessage extends Message {
    private boolean fRes=true;
    public abstract Object getResponseMessage();
    public boolean isfRes() {
        return fRes;
    }

    @Override
    Message performAction() {
        return getResponseMessage();
    }

    public ResponseMessage getResponseMessage(){
        return this;
    }
}
