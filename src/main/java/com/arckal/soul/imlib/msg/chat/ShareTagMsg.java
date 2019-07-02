package com.arckal.soul.imlib.msg.chat;

/**
 * @Author: arckal
 * @Date: 2019/6/27 19:37
 * @Version 1.0
 */
public class ShareTagMsg extends TopChatMsg {
    public String tagId = "";
    public String tagName = "";

    public ShareTagMsg(String str, String str2) {
        this.tagId = str;
        this.tagName = str2;
    }
}