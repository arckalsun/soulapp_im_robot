package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.imlib.msg.chat.AudioMsg;
import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.VoiceMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/26 10:35
 * @Version 1.0
 */
public class AudioPacket extends MsgPacket {

    public AudioPacket(String from, AudioMsg audioMsg, String cmdId){
        super(from,0, MsgCommandOuterClass.MsgCommand.Type.VOICE,cmdId);
        this.o = this.p.mergeVoiceMessage(VoiceMessageOuterClass.VoiceMessage.newBuilder()
        .setRemoteUrl(audioMsg.url)
        .setDuration(audioMsg.duration)
        .setWord(audioMsg.word).build()).build();
        c();
    }
}
