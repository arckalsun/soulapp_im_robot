package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.imlib.msg.chat.ShareTagMsg;
import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.ShareTagMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 22:12
 * @Version 1.0
 */
public class ShareTagPacket extends MsgPacket {
    public ShareTagPacket(String str, ShareTagMsg shareTagMsg, String str2) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.TAG, str2);
        this.o = this.p.mergeShareTagMessage(ShareTagMessageOuterClass.ShareTagMessage.newBuilder()
                .setTagId(shareTagMsg.tagId)
                .setTagName(shareTagMsg.tagName)
                .build())
                .build();
        c();
    }

}
