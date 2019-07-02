package com.arckal.soul.imlib.msg.chat;

/**
 * @Author: arckal
 * @Date: 2019/6/26 11:55
 * @Version 1.0
 */
public class StringMsg extends TopChatMsg {
    public String content;

    public StringMsg(String str){
        this.content = str;
    }
}
