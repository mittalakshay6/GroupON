package com.Server;

import com.AcceptedSocketThread;
import com.Identity;

import java.util.Hashtable;

public class Server {

    public static Hashtable<Identity, AcceptedSocketThread> clientAcceptedSocketThreadTable = new Hashtable<>();
    public static AcceptedSocketThread getAcceptedSocketThreadFromID(Identity id){
        return clientAcceptedSocketThreadTable.get(id);
    }
    public static void registerAcceptedSocketThread(Identity id, AcceptedSocketThread acceptedSocketThread){
        clientAcceptedSocketThreadTable.put(id, acceptedSocketThread);
    }

}
