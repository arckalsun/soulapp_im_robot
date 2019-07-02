package com.arckal.soul.imlib.msg.chat;

/**
 * @Author: arckal
 * @Date: 2019/6/27 19:44
 * @Version 1.0
 */

public class VideoMsg extends TopChatMsg {
    public int height;
    public String localUrl;
    public String url;
    public int width;

    public VideoMsg(String str, String str2) {
        this.url = str;
        this.localUrl = str2;
    }

    public VideoMsg(String str, String str2, int i, int i2) {
        this.url = str;
        this.localUrl = str2;
        this.width = i;
        this.height = i2;
    }
}