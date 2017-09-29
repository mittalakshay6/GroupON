package com;

public class IPRequestMessage extends Message {
    private String msg;
    private int requestID;
    IPRequestMessage(String msg, int requestID){
        this.msg=msg;
        this.requestID=requestID;
        this.setfReq();
    }
    String getMessage(){
        return msg;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }
}
