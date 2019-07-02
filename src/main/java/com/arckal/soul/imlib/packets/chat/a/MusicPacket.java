package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.imlib.msg.chat.MusicMsg;
import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.MusicMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 22:16
 * @Version 1.0
 */
public class MusicPacket extends MsgPacket {
    public MusicPacket(String str, MusicMsg musicMsg, String str2) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.MUSIC, str2);
        this.o = this.p.mergeMusicMessage(MusicMessageOuterClass.MusicMessage.newBuilder()
                .setCoverUrl(musicMsg.coverUrl == null ? "" : musicMsg.coverUrl)
                .setAuthor(musicMsg.author == null ? "" : musicMsg.author)
                .setName(musicMsg.name == null ? "" : musicMsg.name)
                .setUrl(musicMsg.url == null ? "" : musicMsg.url)
                .setPlatform(musicMsg.platform == null ? "" : musicMsg.platform)
                .build()).build();
        c();
    }
}
