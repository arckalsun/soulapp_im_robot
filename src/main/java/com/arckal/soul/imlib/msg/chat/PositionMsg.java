package com.arckal.soul.imlib.msg.chat;

/**
 * @Author: arckal
 * @Date: 2019/6/27 19:36
 * @Version 1.0
 */

public class PositionMsg extends TopChatMsg {
    public String address;
    public double lat;
    public double lng;
    public String title;

    public PositionMsg(String title, String address, double lng, double lat) {
        this.title = title;
        this.address = address;
        this.lng = lng;
        this.lat = lat;
    }
}