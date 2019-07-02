package com.arckal.soul.service;

import com.arckal.soul.dao.ChatDAO;
import com.arckal.soul.imlib.ChatRobot;
import com.arckal.soul.imlib.msg.ImMessage;
import com.arckal.soul.imlib.packets.Packet;
import com.arckal.soul.imlib.TextMsgCommand;
import com.arckal.soul.imlib.connection.PacketWriter;
import com.arckal.soul.protos.MsgCommandOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;

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
    public String askRobot(String question) {
        String reply = robot.askSoulRobot(question).getReply();
        //  去敏
        if(isSensitive(reply)){
            reply = robot.randomReply().getReply();
        }
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
