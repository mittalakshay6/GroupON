package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class AcceptedSocketThread implements Runnable, MessageThread {
    private Socket socket;
    AcceptedSocketThread(Socket socket){
        this.socket=socket;
        Thread t = new Thread(this, "com.AcceptedSocketThread");
        t.start();
    }
    public void run(){
        try {
            System.out.println("msgThread");
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                MessagePacket messagePacket = (MessagePacket) objectInputStream.readObject();
                ReceivedMessagePacketProcessor receivedMessagePacketProcessor = new ReceivedMessagePacketProcessor(messagePacket);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
