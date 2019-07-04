package com.arckal.soul.service;

import com.arckal.soul.baidu_aip.AipClient;
import com.arckal.soul.dao.ChatDAO;
import com.arckal.soul.imlib.ChatReply;
import com.arckal.soul.imlib.ChatRobot;
import com.arckal.soul.imlib.msg.ImMessage;
import com.arckal.soul.imlib.packets.Packet;
import com.arckal.soul.imlib.TextMsgCommand;
import com.arckal.soul.imlib.connection.PacketWriter;
import com.arckal.soul.protos.MsgCommandOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;

/**
 * @Author: arckal
 * @Date: 2019/6/10 0:19
 * @Version 1.0
 */
@Service
public class ChatServiceImpl implements ChatService {
    private static HashSet<String> sensitiveWords;
    private ChatDAO chatDAO;

    private ChatRobot robot;
    @Autowired
    private AipClient aipClient;

    @Autowired
    public ChatServiceImpl(ChatDAO chatDAO, ChatRobot robot){
        this.chatDAO = chatDAO;
        this.robot = robot;
        // 初始化集合
        sensitiveWords = this.chatDAO.getSensitiveWords();
        System.out.println("已加载敏感词：" + sensitiveWords.size());
    }

    /**
     * 判断一句话是否包含敏感词汇
     *
     * @param words
     * @return
     */
    @Override
    public boolean isSensitive(String words) {
        for(String str : sensitiveWords){
            if(words.indexOf(str)>=0){
                return true;
            }

        }
        return false;
    }

    @Override
    public void saveMsgCommand(MsgCommandOuterClass.MsgCommand msg) {
        this.chatDAO.saveMsgCommand(msg);
//        this.chatDAO.saveImMessage(msg.get);
    }

    @Override
    public void saveTextMsgCommand(TextMsgCommand msg) {
        this.chatDAO.saveTextMsgCommand(msg);
    }

    /**
     * 调用机器人接口
     *
     * @param question
     * @return
     */
    @Override
    public ChatReply askRobot(String uid, String question) {
        //TODO: 建立用户聊天模型，从用户聊天记录分析用户特征
        long chatCount = chatDAO.getUserChatCount(uid);
        if(chatCount % 20 ==0){
            // 分析最新几条的情感
            List<String> chats = chatDAO.getUserLastChat(uid,3);
            int sentiment = 0;
            for(String s : chats){
                sentiment += aipClient.sentimentClassify(s);
            }
            if(sentiment>=chats.size()){
                // 判定为积极情感
                return robot.getRewardReply(uid);
            }
        }

        ChatReply reply = robot.askSoulRobot(uid,question);
        String type = reply.getType();
        String text = reply.getText();
        if(type==null){ type = "text"; }
        if(text==null){ text = ""; }

        if (type.equalsIgnoreCase("text")){
            if(isSensitive(text) || StringUtils.isEmpty(text)){
                do{
                    text = robot.randomReply().getText();
                }while (isSensitive(text));
            }
        }
        //  去敏
        return reply;
    }


    @Override
    public void saveImMessage(ImMessage msg) {
        this.chatDAO.saveImMessage(msg);
    }

    @Override
    public void send(Packet packet) {
        PacketWriter.sendPacket(packet);
    }
}
