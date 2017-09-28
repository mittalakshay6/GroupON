package com;

import java.net.InetAddress;

public class IPResponseMessage extends ResponseMessage{
    InetAddress inetAddress;
    IPResponseMessage(InetAddress responseMessage){
        this.inetAddress =responseMessage;
    }

    @Override
    public IPResponseMessage getResponseMessage() {
        return this;
    }
}
