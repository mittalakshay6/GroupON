package com;

import java.net.InetAddress;

public interface MessagePacket extends Message {
    InetAddress getTo();
    InetAddress getFrom();
}
