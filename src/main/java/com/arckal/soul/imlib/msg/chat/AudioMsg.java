package com.arckal.soul.imlib.msg.chat;

/**
 * @Author: arckal
 * @Date: 2019/6/26 10:54
 * @Version 1.0
 */
public class AudioMsg extends TopChatMsg {
    public int duration;
    public String localUrl;
    public String url;
    public String word;

    public AudioMsg(String url, String localUrl,int duration, String word){
        this.url = url;
        this.localUrl = localUrl;
        this.duration = duration;
        this.word = word;
    }
}
