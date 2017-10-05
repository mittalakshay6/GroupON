package com;

import java.net.InetAddress;

public class ImageNotificationMessage implements Message {
    int fileSize;
    public ImageNotificationMessage(int fileSize) {
        this.fileSize = fileSize;
    }
    public int getFileSize() {
        return fileSize;
    }
}