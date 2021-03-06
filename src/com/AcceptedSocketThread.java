package com;

import com.Server.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class AcceptedSocketThread {
    private Socket socket;
    private Identity clientID=null;
    private final int clientListenPort = 1234;
    private ReceivedMessagePacketProcessor receivedMessagePacketProcessor;
    AcceptedSocketThread(Socket socket){
        this.socket=socket;
    }
    public Identity getClientID() {
        if(clientID==null)
            return retrieveIDfromClient();
        return clientID;
    }
    public Identity retrieveIDfromClient(){
        try {
            InputStream inputStream = null;
            inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = null;
            objectInputStream = new ObjectInputStream(inputStream);
            MessagePacket messagePacket = (MessagePacket) objectInputStream.readObject();
            IdentityMessage identityMessage = (IdentityMessage) messagePacket.getMessage();
            clientID = identityMessage.getId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return clientID;
        }
    }
    public InetAddress getSocketInetAddress(){
        return socket.getInetAddress();
    }
    public int getClientListenPort() {
        return clientListenPort;
    }
    public void ReceiveMessagePacket(){
        receivedMessagePacketProcessor = new ReceivedMessagePacketProcessor();
        try{
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            MessagePacket messagePacket = (MessagePacket) objectInputStream.readObject();
            receivedMessagePacketProcessor.addMessagePacket(messagePacket);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void startReceivingMessagePackets(){
        while(true){
            ReceiveMessagePacket();
        }
    }
    public void registerThread(){
        Identity id = getClientID();
        Server.registerAcceptedSocketThread(id, this);
    }

    public Socket getSocket() {
        return socket;
    }

    public void runProcessorOnce(){
        receivedMessagePacketProcessor.processMessage();
    }
    public void runProcessorForAll(){
        receivedMessagePacketProcessor.processAll();
    }
}