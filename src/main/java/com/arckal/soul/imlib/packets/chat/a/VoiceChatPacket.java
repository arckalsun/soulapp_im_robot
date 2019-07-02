package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.imlib.msg.chat.VoiceChatMsg;
import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.VoiceChatMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 22:09
 * @Version 1.0
 */
public class VoiceChatPacket extends MsgPacket {
    public VoiceChatPacket(String str, VoiceChatMsg voiceChatMsg, String str2) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.VOICE_CHAT, str2);
        this.o = this.p.mergeVoiceChatMessage(VoiceChatMessageOuterClass.VoiceChatMessage.newBuilder()
                .setAvatarColor(voiceChatMsg.avatarColor)
                .setAvatarName(voiceChatMsg.avatarName)
                .setChannelId(voiceChatMsg.channelId)
                .setFirstRequestTimeStamp(voiceChatMsg.firstRequestTimeStamp)
                .setSignature(voiceChatMsg.signature)
                .setType(voiceChatMsg.type)
                .setContent(voiceChatMsg.content)
                .build())
                .build();
        c();
    }

}
