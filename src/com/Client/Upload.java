package com.Client;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Upload implements Runnable {

    public String hostName;
    public int port;
    public FileInputStream fileContainer;
    public OutputStream fileSender;
    public Socket socket;
    public Upload(String hostName, int port, File filepath){
        try{
            socket = new Socket(InetAddress.getByName(hostName),port);
            fileContainer=new FileInputStream(filepath);
            fileSender= socket.getOutputStream();
        }
        catch(Exception e){
        }
    }
    @Override
    public void run(){
        try {
            byte[] buffer = new byte[2048];
            int count;
            while ((count = fileContainer.read(buffer)) > 0) {
                fileSender.write(buffer, 0, count);
            }
            //force file data to destination socket
            fileSender.flush();
            fileSender.close();
            fileContainer.close();
            socket.close();
        }
        catch(Exception e){
        }
    }
}
