package com;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class FileSender {
    public final int fileSendingPort =7895;
    File file;
    InetAddress inetAddress;
    FileSender(File file, InetAddress inetAddress){
        this.file=file;
        this.inetAddress=inetAddress;
    }
    public int getFileSendingPort() {
        return fileSendingPort;
    }
    public void sendFile() {
        try(Socket socket = new Socket(this.inetAddress, this.fileSendingPort)) {
            try(FileInputStream fileInputStream = new FileInputStream(file)) {
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                byte[] fileBytes = new byte[4096];
                while (fileInputStream.read(fileBytes) > 0) {
                    dataOutputStream.write(fileBytes);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();;
        }
    }
}
/*   */