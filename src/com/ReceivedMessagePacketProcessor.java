package com;

import com.Server.Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ReceivedMessagePacketProcessor {
    MessagePacket messagePacket;
    ReceivedMessagePacketProcessor(MessagePacket messagePacket){
        this.messagePacket=messagePacket;
    }
    boolean isRequestMessage(){
        return messagePacket.isfReq();
    }
    void processMessage(){
        Message message = this.messagePacket.performAction();
        if(isRequestMessage()){
            MessagePacket clientMessagePacket = new MessagePacket(messagePacket.getFrom(), 0000, message);
            AcceptedSocketThread acceptedSocketThread = Server.getAcceptedSocketThreadFromID(messagePacket.getFrom());
            InetAddress inetAddress = acceptedSocketThread.getSocketInetAddress();
            try (Socket socket = new Socket(inetAddress, acceptedSocketThread.getClientListenPort())) {
                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.defaultWriteObject();
                objectOutputStream.writeObject(clientMessagePacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}