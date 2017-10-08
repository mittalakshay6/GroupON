package com;

import java.util.Vector;

public class GroupMessagePacket extends MessagePacket{
    String groupName;

    public GroupMessagePacket(Identity to, Identity from, Message msg, String groupName) {
        super(to, from, msg);
        this.groupName = groupName;
    }
    public Vector<Identity> getGroupMembers(){

    }

    @Override
    public Message performActionAndForward() {
        Message message = this.getMessage().performAction();
        Identity identity = new Identity(groupName);
        GroupMessagePacket groupMessagePacket = new GroupMessagePacket(identity, this.getFrom(), message, groupName);                                                        // group name is unique for client
        groupMessagePacket.sendMessagePacket();
        return message;
    }

    @Override
    public Message performActionNoForward() {

    }
}
