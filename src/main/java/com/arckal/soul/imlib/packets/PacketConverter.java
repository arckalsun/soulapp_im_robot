package com.arckal.soul.imlib.packets;

import com.arckal.soul.imlib.msg.ImMessage;
import com.arckal.soul.imlib.msg.chat.*;
import com.arckal.soul.imlib.packets.chat.a.*;
import com.arckal.soul.protos.MsgCommandOuterClass.MsgCommand.Type;

/**
 * @Author: arckal
 * @Date: 2019/6/27 21:27
 * @Version 1.0
 */
public class PacketConverter {
    public static Packet convert(ImMessage imMessage) {
        if (1 == imMessage.getMsgType()) {
            ChatMessage chatMessage = imMessage.getChatMessage();
            switch (chatMessage.getMsgType()) {
                case 1:
                    return new TextPacket(imMessage.getTo(), Type.TEXT, (TextMsg) chatMessage.getMsgContent(), imMessage.getMsgId());
                case 2:
                    return new PicPacket(imMessage.getTo(), imMessage.getChatMessage().getSnapChat(), imMessage.getMsgId(), (ImgMsg) imMessage.getChatMessage().getMsgContent());
                case 3:
                    return new PicsPacket(imMessage.getTo(), ((ImgMsgs) imMessage.getChatMessage().getMsgContent()).imgMsgList, imMessage.getMsgId());
                case 4:
                    return new VideoPacket(imMessage.getTo(), imMessage.getChatMessage().getSnapChat(), (VideoMsg) imMessage.getChatMessage().getMsgContent(), imMessage.getMsgId());
                case 5:
                    return new AudioPacket(imMessage.getTo(), (AudioMsg) imMessage.getChatMessage().getMsgContent(), imMessage.getMsgId());
                case 6:
                    return new RePostPacket(imMessage.getTo(), ((RePostMsg) imMessage.getChatMessage().getMsgContent()).toJson(), imMessage.getMsgId(), Type.REPOST);
                case 8:
                    return new UserExpressionPacket(imMessage.getTo(), (ExpressionMsg) imMessage.getChatMessage().getMsgContent(), imMessage.getMsgId());
                case 9:
                    return new MsgCmdPacket(imMessage.getTo(), Type.RECALL, imMessage.getMsgId());
                case 10:
                    return new UserCardPacket(imMessage.getTo(), ((UserCardMsg) imMessage.getChatMessage().getMsgContent()).toJson(), imMessage.getMsgId());
                case 12:
                    return new FingerGuessPacket(imMessage.getTo(), ((DiceFingerMsg) imMessage.getChatMessage().getMsgContent()).number, imMessage.getMsgId());
                case 13:
                    return new RollDicePacket(imMessage.getTo(), ((DiceFingerMsg) imMessage.getChatMessage().getMsgContent()).number, imMessage.getMsgId());
                case 15:
                    return new SoulmateCardPacket(imMessage.getTo(), ((SoulmateInviteMsg) imMessage.getChatMessage().getMsgContent()).status, imMessage.getMsgId());
                case 18:
                    return new TextPacket(imMessage.getTo(), Type.SHAREBG_INVITATION, (TextMsg) imMessage.getChatMessage().getMsgContent(), imMessage.getMsgId());
                case 19:
                    return new TextPacket(imMessage.getTo(), Type.PROMPT, ((PromptMsg) imMessage.getChatMessage().getMsgContent()).text, imMessage.getMsgId());
                case 20:
                    return new MsgCmdPacket(imMessage.getTo(), Type.REPORT, imMessage.getMsgId());
                case 21:
                    return new MsgCmdPacket(imMessage.getTo(), Type.READ,imMessage.getMsgId());
                case 22:
                    return new MsgCmdPacket(imMessage.getTo(), Type.INPUTSTART, imMessage.getMsgId());
                case 23:
                    return new MsgCmdPacket(imMessage.getTo(), Type.INPUTEND, imMessage.getMsgId());
                case 24:
                    return new MsgCmdPacket(imMessage.getTo(), Type.READALL, imMessage.getMsgId());
                case 25:
                    return new MsgCmdPacket(imMessage.getTo(), Type.READ, imMessage.getMsgId());
                case 26:
                    return new SnapChatPacket(imMessage.getTo(), ((TopChatMsg) imMessage.getChatMessage().getMsgContent()).mark, imMessage.getMsgId());
                case 29:
                    return new ExtPacket(imMessage.getTo(), (ExtChatMsg) imMessage.getChatMessage().getMsgContent(), imMessage.getMsgId());
                case 30:
                    return new VoiceChatPacket(imMessage.getTo(), (VoiceChatMsg) imMessage.getChatMessage().getMsgContent(), imMessage.getMsgId());
                case 31:
                    return new ShareTagPacket(imMessage.getTo(), (ShareTagMsg) imMessage.getChatMessage().getMsgContent(), imMessage.getMsgId());
                case 32:
                    return new RePostPacket(imMessage.getTo(), ((StringMsg) imMessage.getChatMessage().getMsgContent()).content, imMessage.getMsgId(), Type.POST);
                case 33:
                    return new PositionPacket(imMessage.getTo(), (PositionMsg) imMessage.getChatMessage().getMsgContent(), imMessage.getMsgId());
                case 34:
                    return new MusicPacket(imMessage.getTo(), (MusicMsg) imMessage.getChatMessage().getMsgContent(), imMessage.getMsgId());
            }
        }
        return null;
    }

}
