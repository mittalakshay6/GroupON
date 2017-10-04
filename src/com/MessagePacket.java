package com;

import com.Server.Server;

import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MessagePacket {
    private boolean forwardingRequired;
    private Identity to;
    private Identity from;
    private Message message;
    MessagePacket(Identity to, Identity from, Message msg){
        this.to=to;
        this.from=from;
        this.message=msg;
    }

    public Identity getTo() {
        return to;
    }

    public void setTo(Identity to) {
        this.to = to;
    }

    public Identity getFrom() {
        return from;
    }

    public void setFrom(Identity from) {
        this.from = from;
    }

    public Message getMessage() {
        return message;
    }

    public Message performAction(){
        if(isForwardingRequired()){
            return performActionAndForward();
        }
        else {
            return performActionNoForward();
        }
    }
    public Message performActionAndForward() {
        Message message = this.message.performAction();
        MessagePacket messagePacket = new MessagePacket(to, from, message);
        messagePacket.unsetForwardingRequired();
        messagePacket.sendMessagePacket();
        return message;
    }

    public Message performActionNoForward() {
        return message.performAction();
    }

    public boolean isForwardingRequired() {
        return forwardingRequired;
    }

    public void setForwardingRequired() {
        forwardingRequired=true;
    }

    public void unsetForwardingRequired() {
        forwardingRequired=false;
    }
    public void sendMessagePacket(){
        try{
            AcceptedSocketThread acceptedSocketThread = Server.getAcceptedSocketThreadFromID(to);
            OutputStream outputStream = acceptedSocketThread.getSocket().getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(this);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
