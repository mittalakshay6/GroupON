package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReceivedMessagePacketThread implements Runnable, MessageThread {
    private Socket socket;
    ReceivedMessagePacketThread(Socket socket){
        this.socket=socket;
        Thread t = new Thread(this, "com.ReceivedMessagePacketThread");
        t.start();
    }
    public void run(){
        try {
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
