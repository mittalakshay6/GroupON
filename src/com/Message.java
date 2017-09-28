package com;

import java.io.Serializable;

public abstract class Message implements Serializable {
    private boolean fIP=false;
    private boolean fReq=false;
    private boolean fDT=false;
    private final long serialVersionUID=1L;

    abstract Message performAction();

    public boolean isfIP() {
        return fIP;
    }

    public boolean isfReq() {
        return fReq;
    }

    public boolean isfDT() {
        return fDT;
    }

    public void setfIP() {
        this.fIP = true;
    }

    public void setfReq() {
        this.fReq = true;
    }

    public void setfDT() {
        this.fDT = true;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }
}
