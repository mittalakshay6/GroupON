package com;

import java.net.InetAddress;

public class IPResponseMessage extends ResponseMessage{
    InetAddress responseMessage;
    IPResponseMessage(InetAddress responseMessage){
        this.responseMessage=responseMessage;
    }

    @Override
    public InetAddress getResponseMessage() {
        return responseMessage;
    }
}
