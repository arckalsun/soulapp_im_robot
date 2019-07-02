package com.arckal.soul.imlib.msg.chat;

import java.util.List;

/**
 * @Author: arckal
 * @Date: 2019/6/26 11:49
 * @Version 1.0
 */
public class ImgMsgs extends TopChatMsg {
    public List<ImgMsg> imgMsgList;

    public ImgMsgs(List<ImgMsg> list){
        this.imgMsgList = list;
    }
}
