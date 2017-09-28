package com;

import java.net.InetAddress;

public class MessagePacket extends Message {
    InetAddress to;
    InetAddress from;
    Message message;
    MessagePacket(InetAddress to, InetAddress from, Message msg){
        this.to=to;
        this.from=from;
        this.message=msg;
    }

    public InetAddress getTo() {
        return to;
    }

    public void setTo(InetAddress to) {
        this.to = to;
    }

    public InetAddress getFrom() {
        return from;
    }

    public void setFrom(InetAddress from) {
        this.from = from;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
