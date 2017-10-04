package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ListenThread {
    private Vector<AcceptedSocketThread> acceptedSocketThreadVector;
    public void acceptConnection(){
        try (ServerSocket servSock = new ServerSocket(1111)) {
            while(true){
                Socket accSock = servSock.accept();
                AcceptedSocketThread acceptedSocketThread = new AcceptedSocketThread(accSock);
                acceptedSocketThreadVector.addElement(acceptedSocketThread);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    boolean isUnregisteredAcceptedSocket(){
        return !acceptedSocketThreadVector.isEmpty();
    }
    public Vector<AcceptedSocketThread> getAcceptedSocketThreadVector() {
        return acceptedSocketThreadVector;
    }
    public void removeAcceptedSocket(AcceptedSocketThread e){
        acceptedSocketThreadVector.remove(e);
    }
}
