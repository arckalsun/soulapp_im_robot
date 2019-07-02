package com.arckal.soul.imlib.msg.chat;

/**
 * @Author: arckal
 * @Date: 2019/6/27 19:36
 * @Version 1.0
 */
public class PromptMsg extends TopChatMsg {
    public String text;

    public PromptMsg(String str) {
        this.text = str;
    }
}