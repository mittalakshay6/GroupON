package com;

import com.Server.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Vector;

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
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectInputStream.defaultReadObject();
            MessagePacket messagePacket = (MessagePacket) objectInputStream.readObject();
            IdentityMessage identityMessage =(IdentityMessage) messagePacket.getMessage();
            clientID=identityMessage.getId();
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
            objectInputStream.defaultReadObject();
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
    public void runProcessorOnce(){
        receivedMessagePacketProcessor.processMessage();
    }
    public void runProcessorForAll(){
        receivedMessagePacketProcessor.processAll();
    }
}