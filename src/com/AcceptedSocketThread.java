package com;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class AcceptedSocketThread implements Runnable, MessageThread {
    private Socket socket;
    private Integer clientID;
    private final int clientListenPort = 1234;
    private Thread t;
    AcceptedSocketThread(Socket socket, Integer clientID){
        this.socket=socket;
        this.clientID=clientID;
        t = new Thread(this, "com.AcceptedSocketThread");
    }
    public int getClientID() {
        return clientID;
    }
    public void run(){
        try {
            System.out.println("msgThread");
            this.notifyIDtoClient();
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                objectInputStream.defaultReadObject();
                MessagePacket messagePacket = (MessagePacket) objectInputStream.readObject();
                ReceivedMessagePacketProcessor receivedMessagePacketProcessor = new ReceivedMessagePacketProcessor(messagePacket);
                receivedMessagePacketProcessor.processMessage();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void start(){
        t.start();
    }
    public void notifyIDtoClient(){
        InetAddress inetAddress = socket.getInetAddress();
        try(Socket socket = new Socket(inetAddress, clientListenPort)){
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeInt(clientID);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public InetAddress getSocketInetAddress(){
        return socket.getInetAddress();
    }

    public int getClientListenPort() {
        return clientListenPort;
    }
}
