package com.Server;

import java.net.InetAddress;
import java.util.Hashtable;

public class Server {
    private static int topID=0;
    public static Hashtable<Integer, InetAddress> ipLookupTable = new Hashtable<>();
    public static int getNextID(){
        return topID++;
    }
}
