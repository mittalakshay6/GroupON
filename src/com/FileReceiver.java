package com;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class FileReceiver {
    public final int fileReceivingPort=7896;
    String fileName;
    InetAddress fromInetAddress;
    int fileSize;
    File file;

    public FileReceiver(String fileName, InetAddress fromInetAddress, int fileSize, String path) {
        this.fileName = fileName;
        this.fromInetAddress = fromInetAddress;
        this.fileSize = fileSize;
        file = new File(path);
    }

    public int getFileReceivingPort() {
        return fileReceivingPort;
    }
    public void receiveFile(){
        try(ServerSocket serverSocket = new ServerSocket(fileReceivingPort)){
            try(Socket socket = serverSocket.accept()){
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] buffer = new byte[4096];
                int read=0;
                int remaining = fileSize;
                while((read=dataInputStream.read(buffer, 0, Math.min(buffer.length,remaining)))>0){
                    remaining-=read;
                    fileOutputStream.write(buffer, 0, read);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
