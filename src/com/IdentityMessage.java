package com;

public class IdentityMessage implements Message{
    Identity id;
    IdentityMessage(Identity id){
        this.id=id;
    }

    public Identity getId() {
        return id;
    }

    @Override
    public Message performAction() {
        return this;
    }
}
