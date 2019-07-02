package com.arckal.soul.imlib.msg.chat;

/**
 * @Author: arckal
 * @Date: 2019/6/26 11:54
 * @Version 1.0
 */
public class TextMsg extends TopChatMsg {
    public String text;
    public int type;

    public TextMsg(String text){
        this.text = text;
    }

    public TextMsg(String text, int type){
        this.text = text;
        this.type = type;
    }
}
