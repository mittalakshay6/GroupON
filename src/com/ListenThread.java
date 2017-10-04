package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ListenThread {
    private Vector<AcceptedSocketThread> unregisteredAcceptedSocketThreadVector;
    public void acceptConnection(){
        try (ServerSocket servSock = new ServerSocket(1111)) {
            while(true){
                Socket accSock = servSock.accept();
                AcceptedSocketThread acceptedSocketThread = new AcceptedSocketThread(accSock);
                unregisteredAcceptedSocketThreadVector.addElement(acceptedSocketThread);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    boolean isUnregisteredAcceptedSocket(){
        return !unregisteredAcceptedSocketThreadVector.isEmpty();
    }
    public Vector<AcceptedSocketThread> getAllUnregisteredAcceptedSocketThreads() {
        return unregisteredAcceptedSocketThreadVector;
    }
    public void removeAcceptedSocket(AcceptedSocketThread e){
        unregisteredAcceptedSocketThreadVector.remove(e);
    }
    public AcceptedSocketThread getUnregisteredAcceptedSocketThread(){
        return unregisteredAcceptedSocketThreadVector.firstElement();
    }
}
