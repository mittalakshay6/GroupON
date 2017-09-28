package com;

public class MessagePacket extends Message {
    private int to;
    private int from;
    private Message message;
    MessagePacket(int to, int from, Message msg){
        this.to=to;
        this.from=from;
        this.message=msg;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public Message getMessage() {
        return message;
    }

    @Override
    Message performAction() {
        return message.performAction();
    }
}
