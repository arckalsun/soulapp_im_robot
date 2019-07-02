package com.arckal.soul.imlib.msg.chat;

import com.arckal.soul.protos.VoiceChatMessageOuterClass.VoiceChatMessage;

/**
 * @Author: arckal
 * @Date: 2019/6/27 18:01
 * @Version 1.0
 */
public class VoiceChatMsg extends TopChatMsg {
    public static final int BUSY_AUDIO_CHAT = 3;
    public static final int CANCEL_AUDIO_CHAT = 1;
    public static final int OVER_AUDIO_CHAT = 4;
    public static final int REQUEST_AUDIO_CHAT = 2;
    public String avatarColor = "";
    public String avatarName = "";
    public String channelId = "";
    public String content = "";
    public long firstRequestTimeStamp;
    public String signature = "";
    public int type;

    public static VoiceChatMsg convert(VoiceChatMessage voiceChatMessage) {
        VoiceChatMsg voiceChatMsg = new VoiceChatMsg();
        voiceChatMsg.signature = voiceChatMessage.getSignature();
        voiceChatMsg.avatarColor = voiceChatMessage.getAvatarColor();
        voiceChatMsg.avatarName = voiceChatMessage.getAvatarName();
        voiceChatMsg.firstRequestTimeStamp = voiceChatMessage.getFirstRequestTimeStamp();
        voiceChatMsg.channelId = voiceChatMessage.getChannelId();
        voiceChatMsg.content = voiceChatMessage.getContent();
        voiceChatMsg.type = voiceChatMessage.getType();
        return voiceChatMsg;
    }

}
