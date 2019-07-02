package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.imlib.msg.chat.VideoMsg;
import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.VideoMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 21:40
 * @Version 1.0
 */
public class VideoPacket extends MsgPacket {
    public VideoPacket(String str, int i, VideoMsg videoMsg, String str2) {
        super(str, i, MsgCommandOuterClass.MsgCommand.Type.VIDEO, str2);
        this.o = this.p.mergeVideoMessage(VideoMessageOuterClass.VideoMessage.newBuilder()
                .setRemoteUrl(videoMsg.url == null ? "" : videoMsg.url)
                .setWidth(videoMsg.width)
                .setHeight(videoMsg.height)
                .build())
                .build();
        c();
    }

}
