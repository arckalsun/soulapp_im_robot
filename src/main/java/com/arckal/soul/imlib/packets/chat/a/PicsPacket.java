package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.imlib.msg.chat.ImgMsg;
import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.PicMessageOuterClass;
import com.arckal.soul.protos.PicMessagesOuterClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: arckal
 * @Date: 2019/6/27 21:34
 * @Version 1.0
 */
public class PicsPacket extends MsgPacket {
    public PicsPacket(String str, List<ImgMsg> list, String str2) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.MULTI_PIC, str2);
        Iterable arrayList = new ArrayList();
        for (ImgMsg imgMsg : list) {
            ((ArrayList) arrayList).add(PicMessageOuterClass.PicMessage.newBuilder()
                    .setImageUrl(imgMsg.imageUrl)
                    .setImageW((float) imgMsg.imageW)
                    .setImageH((float) imgMsg.imageH)
                    .build());
        }
        this.o = this.p.mergePicMessages(PicMessagesOuterClass.PicMessages.newBuilder()
                .addAllPicMessages(arrayList).build()).build();
        c();
    }

}
