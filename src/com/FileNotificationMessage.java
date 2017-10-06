package com;

public abstract class FileNotificationMessage implements Message {
    int fileSize;

    public FileNotificationMessage(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getFileSize() {
        return fileSize;
    }
}
