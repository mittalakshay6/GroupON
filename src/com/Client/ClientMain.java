package com.Client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLoopbackAddress(), 1111);
        Thread t=Thread.currentThread();
        try {
            t.sleep(40000);
        }
        catch (Exception e){

        }
    }
}
