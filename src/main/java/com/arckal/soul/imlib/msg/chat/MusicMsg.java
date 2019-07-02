package com.arckal.soul.imlib.msg.chat;

/**
 * @Author: arckal
 * @Date: 2019/6/27 19:35
 * @Version 1.0
 */
public class MusicMsg extends TopChatMsg {
    public String author;
    public String coverUrl;
    public String name;
    public String platform;
    public String url;

    public MusicMsg(String str, String str2, String str3, String str4, String str5) {
        this.coverUrl = str;
        this.author = str2;
        this.name = str3;
        this.url = str4;
        this.platform = str5;
    }
}