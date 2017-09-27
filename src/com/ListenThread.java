package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ListenThread implements Runnable {
    Thread t;
    public ListenThread(){
        t=new Thread(this, "com.ListenThread");
        System.out.println("New listen thread spawned "+ t);
        t.start();
    }
    public void run(){
        System.out.println("ListenThread running");
        try (ServerSocket servSock = new ServerSocket(1111)) {
            while(true){
                System.out.println("Waiting for Connection");
                Socket accSock = servSock.accept();
                System.out.println("Waiting for Connection");
                ReceivedMessagePacketThread tMsg = new ReceivedMessagePacketThread(accSock);
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}