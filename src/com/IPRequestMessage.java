package com;

import com.Server.Server;

public class IPRequestMessage extends Message {
    private int requestID;
    IPRequestMessage(String msg, int requestID){
        this.requestID=requestID;
        this.setfReq();
        this.setfIP();
    }

    @Override
    Message performAction() {
        return this.createResponseMessage();
    }
    IPResponseMessage createResponseMessage(){
        AcceptedSocketThread acceptedSocketThread = Server.getAcceptedSocketThreadFromID(requestID);
        IPResponseMessage ipResponseMessage = new IPResponseMessage(acceptedSocketThread.getSocketInetAddress());
        return ipResponseMessage;
    }
}
