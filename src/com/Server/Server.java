package com.Server;

import com.AcceptedSocketThread;
import com.NotificationMessagePacket;
import com.Identity;

import java.util.Hashtable;
import java.util.Vector;

public class Server {

    static boolean isFileTransfer=false;

    public static Hashtable<Identity, AcceptedSocketThread> clientAcceptedSocketThreadTable = new Hashtable<>();
    public static Vector<NotificationMessagePacket> notificationMessagePackets;
    public static AcceptedSocketThread getAcceptedSocketThreadFromID(Identity id){
        return clientAcceptedSocketThreadTable.get(id);
    }
    public static void registerAcceptedSocketThread(Identity id, AcceptedSocketThread acceptedSocketThread){
        clientAcceptedSocketThreadTable.put(id, acceptedSocketThread);
    }
    static void notifyFileTransfer(NotificationMessagePacket notificationMessagePacket){
        notificationMessagePackets.addElement(notificationMessagePacket);
        isFileTransfer=true;
    }
    static NotificationMessagePacket getNotificationMessagePacket(){
        return notificationMessagePackets.firstElement();
    }
    static Vector<NotificationMessagePacket> getAllNotificationMessagePackets(){
        return notificationMessagePackets;
    }
}
