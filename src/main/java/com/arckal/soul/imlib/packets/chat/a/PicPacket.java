package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.imlib.msg.chat.ImgMsg;
import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.PicMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/26 11:17
 * @Version 1.0
 */
public class PicPacket extends MsgPacket {
    public PicPacket(String from, int snapshot, String cmdId, ImgMsg imgMsg){
        super(from, i, MsgCommandOuterClass.MsgCommand.Type.PIC, cmdId);
        this.o = this.p.mergePicMessage(PicMessageOuterClass.PicMessage.newBuilder()
        .setImageUrl(imgMsg.imageUrl==null?"":imgMsg.imageUrl)
        .setImageH((float)imgMsg.imageH)
        .setImageW((float)imgMsg.imageW)
        .build()
        ).build();
        c();
    }
}
