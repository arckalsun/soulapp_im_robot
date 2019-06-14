package com.arckal.soul.imlib;

public class ChatReply {
    private String reply;
    private String type;

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ChatReply{" +
                "reply='" + reply + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
