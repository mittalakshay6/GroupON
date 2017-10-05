package com;

public interface NotificationMessagePacket {
    void processMessage();
    Identity getTo();
    Identity getFrom();
}
