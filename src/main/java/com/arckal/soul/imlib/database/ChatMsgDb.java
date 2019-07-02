package com.arckal.soul.imlib.database;

import com.arckal.soul.imlib.msg.ImMessage;
import com.arckal.soul.imlib.msg.chat.ChatMessage;
import com.arckal.soul.imlib.msg.chat.TopChatMsg;


/**
 * @Author: arckal
 * @Date: 2019/6/27 19:05
 * @Version 1.0
 */
//@Entity
public class ChatMsgDb {
    public String extString;
//    @d
    public long id;
    public int isAck;
    public long localTime;
    public String msgContent;
//    @e
    public String msgId;
    public int msgSource;
//    @e
    public int msgStatus;
    public int msgType;
    public String receiverId;
    public String senderId;
//    @e
    public long serverTime;
//    @e
    public String sessionId;
    public int snapChat;

    public static ChatMsgDb a(ImMessage imMessage) {
        ChatMsgDb chatMsgDb = new ChatMsgDb();
        chatMsgDb.msgId = imMessage.getMsgId();
        chatMsgDb.msgStatus = imMessage.getMsgStatus();
        chatMsgDb.localTime = imMessage.getLocalTime();
        chatMsgDb.senderId = imMessage.getFrom();
        chatMsgDb.receiverId = imMessage.getTo();
        chatMsgDb.isAck = imMessage.getIsAck();
        chatMsgDb.serverTime = imMessage.getServerTime();
        ChatMessage chatMessage = imMessage.getChatMessage();
        chatMsgDb.sessionId = chatMessage.getSessionId();
        chatMsgDb.msgType = chatMessage.getMsgType();
        chatMsgDb.snapChat = chatMessage.getSnapChat();
        chatMsgDb.extString = chatMessage.getExtString();
        TopChatMsg topChatMsg = (TopChatMsg) chatMessage.getMsgContent();
        if (topChatMsg == null) {
            chatMsgDb.msgContent = "";
        } else {
            chatMsgDb.msgContent = topChatMsg.toJson();
        }
        return chatMsgDb;
    }

}
