package com.arckal.soul.imlib.msg;

import com.arckal.soul.SoulConfig;
import com.arckal.soul.imlib.GlobalParams;
import com.arckal.soul.imlib.msg.chat.ChatMessage;
import com.arckal.soul.imlib.msg.notify.NotifyMsg;
import com.arckal.soul.imlib.msg.push.PushMsg;
import com.arckal.soul.protos.CommandMessageOuterClass.CommandMessage;
import com.arckal.soul.utils.DataUtils;
import com.arckal.soul.utils.SpringContextUtil;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/**
 * @Author: arckal
 * @Date: 2019/6/27 18:45
 * @Version 1.0
 */
public class ImMessage implements Serializable {
    private MsgStatusCallBack callBack;
    public String from;
    public int isAck;
    public long localTime;
    private HashMap<String, Serializable> maps = new HashMap();
    public String msgId;
    public int msgStatus;
    public int msgType;
    public long serverTime;
    public String to;

    public interface MsgStatusCallBack extends Serializable {
        void onStatusChange(int i, String str);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
        public static final int a = 1;
        public static final int b = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
    }

    public ImMessage shallowCopy() {
        ImMessage imMessage = new ImMessage();
        imMessage.setMsgId(this.msgId);
        imMessage.setFrom(this.from);
        imMessage.setTo(this.to);
        imMessage.setMsgType(this.msgType);
        imMessage.setMsgStatusCallBack(this.callBack);
        imMessage.maps = this.maps;
        imMessage.setLocalTime(this.localTime);
        imMessage.setIsAck(this.isAck);
        imMessage.setMsgStatus(this.msgStatus);
        return imMessage;
    }

    public static ImMessage createChatSendMsg(ChatMessage chatMessage, String to) {
        return createChatSendMsg(chatMessage, to, DataUtils.c());
    }

    /**
     * 创建发送的消息
     * @param chatMessage
     * @param to 接收方id
     * @param msgId
     * @return
     */
    public static ImMessage createChatSendMsg(ChatMessage chatMessage, String to, String msgId) {
        ImMessage imMessage = new ImMessage();
        imMessage.setMsgStatus(1);
        imMessage.setLocalTime(System.currentTimeMillis());
        imMessage.setServerTime(GlobalParams.a());
        //TODO: 待定
//        imMessage.setFrom(cn.soulapp.imlib.a.a.a().d);
        imMessage.setFrom(SpringContextUtil.getBean(SoulConfig.class).getUserId());
        imMessage.setTo(to);
        imMessage.setChatMessage(chatMessage);
        imMessage.setMsgType(1);
        imMessage.setMsgId(msgId);
        return imMessage;
    }

    public static ImMessage createChatReceiveMsg(ChatMessage chatMessage, CommandMessage commandMessage) {
        ImMessage imMessage = new ImMessage();
        imMessage.setChatMessage(chatMessage);
        imMessage.setMsgType(1);
        imMessage.setMsgStatus(2);
        imMessage.setMsgId(commandMessage.getCmdId());
        imMessage.setLocalTime(System.currentTimeMillis());
        imMessage.setTo(commandMessage.getMsgCommand().getTo());
        imMessage.setFrom(commandMessage.getMsgCommand().getFrom());
        imMessage.setServerTime(commandMessage.getMsgCommand().getTimestamp());
        return imMessage;
    }

    public static ImMessage createChatReceiveMsg(ChatMessage chatMessage, String from) {
        ImMessage imMessage = new ImMessage();
        imMessage.setChatMessage(chatMessage);
        imMessage.setMsgType(1);
        imMessage.setMsgStatus(2);
        imMessage.setMsgId(DataUtils.c());
        imMessage.setLocalTime(System.currentTimeMillis());
        imMessage.setServerTime(GlobalParams.a());
        imMessage.setTo(SpringContextUtil.getBean(SoulConfig.class).getUserId());
        imMessage.setFrom(from);
        return imMessage;
    }

    public static ImMessage createPushReceiveMsg(PushMsg pushMsg, CommandMessage commandMessage) {
        ImMessage imMessage = new ImMessage();
        imMessage.setPushMessage(pushMsg);
        imMessage.setMsgType(4);
        imMessage.setMsgStatus(2);
        imMessage.setMsgId(commandMessage.getCmdId());
        imMessage.setTo(commandMessage.getPushMessage().getReceiver());
        imMessage.setFrom(commandMessage.getPushMessage().getSender());
        return imMessage;
    }

    public static ImMessage createNotifyReceiveMsg(NotifyMsg notifyMsg, CommandMessage commandMessage) {
        ImMessage imMessage = new ImMessage();
        imMessage.setNotifyMessage(notifyMsg);
        imMessage.setMsgType(3);
        imMessage.setMsgStatus(2);
        imMessage.setMsgId(commandMessage.getCmdId());
        imMessage.setTo(commandMessage.getNotifyCommand().getTo());
        imMessage.setFrom(commandMessage.getNotifyCommand().getFrom());
        return imMessage;
    }

    public static ImMessage createChatMsg() {
        ImMessage imMessage = new ImMessage();
        imMessage.setMsgId(DataUtils.c());
        imMessage.setMsgType(1);
        return imMessage;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public int getMsgStatus() {
        return this.msgStatus;
    }

    public long getLocalTime() {
        return this.localTime;
    }

    public int getIsAck() {
        return this.isAck;
    }

    public void setLocalTime(long j) {
        this.localTime = j;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setTo(String str) {
        this.to = str;
    }

    public void setMsgStatus(int i) {
        this.msgStatus = i;
    }

    public void setIsAck(int i) {
        this.isAck = i;
    }

    private <T extends Serializable> void a(String str, T t) {
        this.maps.put(str, t);
    }

    public void setChatMessage(ChatMessage chatMessage) {
        a("MSGOBJECT", chatMessage);
    }

    public void setPushMessage(PushMsg pushMsg) {
        a("MSGOBJECT", pushMsg);
    }

    public PushMsg getPushMessage() {
        try {
            return (PushMsg) this.maps.get("MSGOBJECT");
        } catch (Exception unused) {
            return null;
        }
    }

    public void setNotifyMessage(NotifyMsg notifyMsg) {
        a("MSGOBJECT", notifyMsg);
    }

    public NotifyMsg getNotifyMessage() {
        try {
            return (NotifyMsg) this.maps.get("MSGOBJECT");
        } catch (Exception unused) {
            return null;
        }
    }

    public ChatMessage getChatMessage() {
        try {
            return (ChatMessage) this.maps.get("MSGOBJECT");
        } catch (Exception unused) {
            return null;
        }
    }

    public void putExt(String str, Serializable serializable) {
        a(str, serializable);
    }

    public <T> T getExt(String str) {
        return (T)this.maps.get(str);
    }

    public void setMsgStatusCallBack(MsgStatusCallBack msgStatusCallBack) {
        this.callBack = msgStatusCallBack;
    }

    public MsgStatusCallBack getMsgStatusCallBack() {
        return this.callBack;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(long j) {
        this.serverTime = j;
    }

}
