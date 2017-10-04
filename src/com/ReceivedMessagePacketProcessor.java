package com;

import java.util.Vector;

public class ReceivedMessagePacketProcessor {
    Vector<MessagePacket> messagePackets;
    public void addMessagePacket(MessagePacket messagePacket){
        messagePackets.addElement(messagePacket);
    }
    void processMessage(){
        Message message = messagePackets.firstElement().performAction();
        messagePackets.remove(0);
    }
    boolean isUnprocessedMessages(){
        return !messagePackets.isEmpty();
    }
    void processAll(){
        while(isUnprocessedMessages()){
            processMessage();
        }
    }
}