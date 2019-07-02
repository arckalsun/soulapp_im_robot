package com.arckal.soul.imlib.msg.chat;

import com.arckal.soul.protos.PicMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/26 11:21
 * @Version 1.0
 */
public class ImgMsg extends TopChatMsg {
    public int imageH;
    public String imageLocalPath;
    public String imageUrl;
    public int imageW;

    public static ImgMsg convert(PicMessageOuterClass.PicMessage picMessage){
        ImgMsg imgMsg = new ImgMsg();
        imgMsg.imageUrl = picMessage.getImageUrl();
        imgMsg.imageW = (int) picMessage.getImageW();
        imgMsg.imageH = (int) picMessage.getImageH();
        return imgMsg;
    }
}
