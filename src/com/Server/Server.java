package com.Server;

import com.AcceptedSocketThread;

import java.util.Hashtable;

public class Server {
    private static int topID=0;
    public static Hashtable<Integer, AcceptedSocketThread> clientAcceptedSocketThreadTable = new Hashtable<>();
    public static int getNextID(){
        return topID++;
    }
    public static AcceptedSocketThread getAcceptedSocketThreadFromID(Integer id){
        return clientAcceptedSocketThreadTable.get(id);
    }
    public static void registerAcceptedSocketThread(Integer id, AcceptedSocketThread acceptedSocketThread){
        clientAcceptedSocketThreadTable.put(id, acceptedSocketThread);
    }

}
