package com;

public class ImageNotificationMessage implements Message {
    String name;
    int fileSize;
    public ImageNotificationMessage(String name, int fileSize) {
        this.name = name;
        this.fileSize = fileSize;
    }
    public String getName() {
        return name;
    }
    public int getFileSize() {
        return fileSize;
    }
}