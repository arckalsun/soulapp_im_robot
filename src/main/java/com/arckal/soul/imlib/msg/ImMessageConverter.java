package com.arckal.soul.imlib.msg;

import com.arckal.soul.imlib.database.ChatMsgDb;
import com.arckal.soul.imlib.msg.chat.*;
import com.arckal.soul.protos.*;
import com.arckal.soul.protos.CommandMessageOuterClass.CommandMessage;
import com.arckal.soul.protos.MsgCommandOuterClass.MsgCommand.Type;
import com.arckal.soul.utils.GsonUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: arckal
 * @Date: 2019/6/27 19:01
 * @Version 1.0
 */
public class ImMessageConverter {

    static class AnonymousClass1{
        static final int[] a = new int[Type.values().length];

        static {
            a[Type.TEXT.ordinal()] = 1;
            a[Type.PIC.ordinal()] = 2;
            a[Type.MULTI_PIC.ordinal()] = 3;
            a[Type.VIDEO.ordinal()] = 4;
            a[Type.VOICE.ordinal()] = 5;
            a[Type.REPOST.ordinal()] = 6;
            a[Type.EXPRESSION.ordinal()] = 7;
            a[Type.USER_EXPRESSION.ordinal()] = 8;
            a[Type.RECALL.ordinal()] = 9;
            a[Type.PROMPT.ordinal()] = 10;
            a[Type.USER_CARD.ordinal()] = 11;
            a[Type.FINGER_GUESS.ordinal()] = 12;
            a[Type.ROLL_DICE.ordinal()] = 13;
            a[Type.CUSTOM.ordinal()] = 14;
            a[Type.SOULMATE_CARD.ordinal()] = 15;
            a[Type.FOLLOW_TOAST.ordinal()] = 16;
            a[Type.SHAREBG_INVITATION.ordinal()] = 17;
            a[Type.SENSITIVE_WORD.ordinal()] = 18;
            a[Type.UNRECOGNIZED.ordinal()] = 19;
            a[Type.VOICE_CHAT.ordinal()] = 20;
            a[Type.TAG.ordinal()] = 21;
            a[Type.POST.ordinal()] = 22;
            a[Type.POSITION.ordinal()] = 23;
            a[Type.MUSIC.ordinal()] = 24;
        }
    }

    private static void o(ChatMessage chatMessage, CommandMessage commandMessage) {
    }

    private static void t(ChatMessage chatMessage, CommandMessage commandMessage) {
    }

    private static void v(ChatMessage chatMessage, CommandMessage commandMessage) {
    }

    private static void x(ChatMessage chatMessage, CommandMessage commandMessage) {
    }

    private static void y(ChatMessage chatMessage, CommandMessage commandMessage) {
    }

    public static ImMessage a(ChatMsgDb chatMsgDb) {
        if (chatMsgDb == null) {
            return null;
        }
        ImMessage imMessage = new ImMessage();
        imMessage.setMsgId(chatMsgDb.msgId);
        imMessage.setMsgStatus(chatMsgDb.msgStatus);
        imMessage.setLocalTime(chatMsgDb.localTime);
        imMessage.setFrom(chatMsgDb.senderId);
        imMessage.setTo(chatMsgDb.receiverId);
        imMessage.setMsgType(1);
        imMessage.setIsAck(chatMsgDb.isAck);
        imMessage.setServerTime(chatMsgDb.serverTime);
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSessionId(chatMsgDb.sessionId);
        chatMessage.setMsgType(chatMsgDb.msgType);
        chatMessage.setSnapChat(chatMsgDb.snapChat);
        chatMessage.setExtString(chatMsgDb.extString);
        switch (chatMsgDb.msgType) {
            case 1:
            case 18:
            case 21:
            case 27:
            case 28:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, TextMsg.class));
                break;
            case 2:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, ImgMsg.class));
                break;
            case 3:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, ImgMsgs.class));
                break;
            case 4:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, VideoMsg.class));
                break;
            case 5:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, AudioMsg.class));
                break;
            case 6:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, RePostMsg.class));
                break;
            case 8:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, ExpressionMsg.class));
                break;
            case 9:
                chatMessage.setMsgContent(null);
                break;
            case 10:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, UserCardMsg.class));
                break;
            case 12:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, DiceFingerMsg.class));
                break;
            case 13:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, DiceFingerMsg.class));
                break;
            case 15:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, SoulmateInviteMsg.class));
                break;
            case 19:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, PromptMsg.class));
                break;
            case 29:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, ExtChatMsg.class));
                break;
            case 30:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, VoiceChatMsg.class));
                break;
            case 31:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, ShareTagMsg.class));
                break;
            case 32:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, StringMsg.class));
                break;
            case 33:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, PositionMsg.class));
                break;
            case 34:
                chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(chatMsgDb.msgContent, MusicMsg.class));
                break;
        }
        imMessage.setChatMessage(chatMessage);
        return imMessage;
    }

    public static ImMessage a(CommandMessage commandMessage) {
        ChatMessage create = ChatMessage.create(commandMessage.getMsgCommand().getFrom());
        switch (AnonymousClass1.a[commandMessage.getMsgCommand().getType().ordinal()]) {
            case 1:
                g(create, commandMessage);
                break;
            case 2:
                h(create, commandMessage);
                break;
            case 3:
                i(create, commandMessage);
                break;
            case 4:
                j(create, commandMessage);
                break;
            case 5:
                k(create, commandMessage);
                break;
            case 6:
                l(create, commandMessage);
                break;
            case 7:
                m(create, commandMessage);
                break;
            case 8:
                n(create, commandMessage);
                break;
            case 9:
                o(create, commandMessage);
                break;
            case 10:
                p(create, commandMessage);
                break;
            case 11:
                q(create, commandMessage);
                break;
            case 12:
                r(create, commandMessage);
                break;
            case 13:
                s(create, commandMessage);
                break;
            case 14:
                t(create, commandMessage);
                break;
            case 15:
                u(create, commandMessage);
                break;
            case 16:
                v(create, commandMessage);
                break;
            case 17:
                w(create, commandMessage);
                break;
            case 18:
                x(create, commandMessage);
                break;
            case 19:
                y(create, commandMessage);
                break;
            case 20:
                f(create, commandMessage);
                break;
            case 21:
                e(create, commandMessage);
                break;
            case 22:
                d(create, commandMessage);
                break;
            case 23:
                b(create, commandMessage);
                break;
            case 24:
                a(create, commandMessage);
                break;
            default:
                c(create, commandMessage);
                break;
        }
        return ImMessage.createChatReceiveMsg(create, commandMessage);
    }

    private static void a(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(34);
        MusicMessageOuterClass.MusicMessage musicMessage = commandMessage.getMsgCommand().getMusicMessage();
        chatMessage.setMsgContent(new MusicMsg(musicMessage.getCoverUrl(), musicMessage.getAuthor(), musicMessage.getName(), musicMessage.getUrl(), musicMessage.getPlatform()));
    }

    private static void b(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(33);
        PositionMessageOuterClass.PositionMessage positionMessage = commandMessage.getMsgCommand().getPositionMessage();
        chatMessage.setMsgContent(new PositionMsg(positionMessage.getTitle(), positionMessage.getAddress(), positionMessage.getLng(), positionMessage.getLat()));
    }

    private static void c(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(1);
        chatMessage.setMsgContent(new TextMsg(commandMessage.getMsgCommand().getNotice()));
    }

    private static void d(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(32);
        chatMessage.setMsgContent(new StringMsg(commandMessage.getMsgCommand().getRepostMessge().getInfo()));
    }

    private static void e(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(31);
        ShareTagMessageOuterClass.ShareTagMessage shareTagMessage = commandMessage.getMsgCommand().getShareTagMessage();
        chatMessage.setMsgContent(new ShareTagMsg(shareTagMessage.getTagId(), shareTagMessage.getTagName()));
    }

    private static void f(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(30);
        chatMessage.setMsgContent(VoiceChatMsg.convert(commandMessage.getMsgCommand().getVoiceChatMessage()));
    }

    private static void g(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(1);
        chatMessage.setMsgContent(new TextMsg(commandMessage.getMsgCommand().getTextMsg().getText(), commandMessage.getMsgCommand().getTextMsg().getType()));
    }

    private static void h(ChatMessage chatMessage, CommandMessage commandMessage) {
        PicMessageOuterClass.PicMessage picMessage = commandMessage.getMsgCommand().getPicMessage();
        chatMessage.setMsgType(2);
        chatMessage.setSnapChat(commandMessage.getMsgCommand().getSnapChat());
        chatMessage.setMsgContent(ImgMsg.convert(picMessage));
    }

    private static void i(ChatMessage chatMessage, CommandMessage commandMessage) {
        List<PicMessageOuterClass.PicMessage> picMessagesList = commandMessage.getMsgCommand().getPicMessages().getPicMessagesList();
        List arrayList = new ArrayList();
        for (PicMessageOuterClass.PicMessage convert : picMessagesList) {
            arrayList.add(ImgMsg.convert(convert));
        }
        chatMessage.setSnapChat(commandMessage.getMsgCommand().getSnapChat());
        chatMessage.setMsgContent(new ImgMsgs(arrayList));
        chatMessage.setMsgType(3);
    }

    private static void j(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(4);
        chatMessage.setSnapChat(commandMessage.getMsgCommand().getSnapChat());
        VideoMessageOuterClass.VideoMessage videoMessage = commandMessage.getMsgCommand().getVideoMessage();
        chatMessage.setMsgContent(new VideoMsg(videoMessage.getRemoteUrl(), "", videoMessage.getWidth(), videoMessage.getHeight()));
    }

    private static void k(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(5);
        VoiceMessageOuterClass.VoiceMessage voiceMessage = commandMessage.getMsgCommand().getVoiceMessage();
        chatMessage.setMsgContent(new AudioMsg(voiceMessage.getRemoteUrl(), "", voiceMessage.getDuration(), voiceMessage.getWord()));
    }

    private static void l(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(6);
        chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(commandMessage.getMsgCommand().getRepostMessge().getInfo(), RePostMsg.class));
    }

    private static void m(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(7);
        chatMessage.setMsgContent(null);
    }

    private static void n(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(8);
        chatMessage.setMsgContent(ExpressionMsg.convert(commandMessage.getMsgCommand().getUserExpressionMessage()));
    }

    private static void p(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(19);
        chatMessage.setMsgContent(new PromptMsg(commandMessage.getMsgCommand().getTextMsg().getText()));
    }

    private static void q(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(10);
        chatMessage.setMsgContent((Serializable) GsonUtils.fromJson(commandMessage.getMsgCommand().getUserCardMessage().getUserInfo(), UserCardMsg.class));
    }

    private static void r(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(12);
        chatMessage.setMsgContent(new DiceFingerMsg(commandMessage.getMsgCommand().getFingerGuessMessage().getFinger()));
    }

    private static void s(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(13);
        chatMessage.setMsgContent(new DiceFingerMsg(commandMessage.getMsgCommand().getRollDiceMessage().getDicePoints()));
    }

    private static void u(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(15);
        chatMessage.setMsgContent(new SoulmateInviteMsg(commandMessage.getMsgCommand().getSoulmateCardMessage().getStatus()));
    }

    private static void w(ChatMessage chatMessage, CommandMessage commandMessage) {
        chatMessage.setMsgType(18);
        chatMessage.setMsgContent(new TextMsg(commandMessage.getMsgCommand().getTextMsg().getText()));
    }

}
