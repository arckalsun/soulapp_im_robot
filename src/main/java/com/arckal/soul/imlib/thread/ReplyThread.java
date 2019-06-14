package com.arckal.soul.imlib.thread;

import com.arckal.soul.imlib.SoulChatClient;
import com.arckal.soul.imlib.ChatRobot;
import com.arckal.soul.dao.ChatDAO;
import com.arckal.soul.imlib.Command;
import com.arckal.soul.imlib.MsgCommand;
import com.arckal.soul.imlib.Packet.CmdPacket;
import com.arckal.soul.imlib.Packet.Packet;
import com.arckal.soul.imlib.Packet.TextPacket;
import com.arckal.soul.service.ChatService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: arckal
 * @Date: 2019/6/1 19:41
 * @Version 1.0
 */
public class ReplyThread implements Runnable {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Command cmd;

    private SoulChatClient client;

    private ChatService chatService;

    public ReplyThread(Command cmd, SoulChatClient client,ChatService chatService){
        this.cmd = cmd;
        this.client = client;
        this.chatService = chatService;
    }

    @Override
    public void run() {
        try {
            if (cmd==null)
                return;

            if (cmd instanceof MsgCommand){
                System.out.println("\033[31;4m<<-- 接收: (" + sdf.format(new Date()) +")"+ cmd.toString()+"\033[0m");
                String fromId = ((MsgCommand) cmd).getFromUserId(); // 消息来源
                String toId = ((MsgCommand) cmd).getToUserId();
                String sourceMsg = ((MsgCommand) cmd).getMessage();

                //  存入数据库
                chatService.saveMsgCommand((MsgCommand)cmd);

                // 调用机器人
                String reply = null;
                reply = chatService.askRobot(sourceMsg);
//
//                ChatRobot robot = ChatRobot.getInstance();
////                SoulChatClient client = SoulChatClient.getInstance();
//
//
//                // 预设关键字回复
//                reply = robot.presetReply(sourceMsg);
//                if (reply==null||reply.equals("")){
//                    // 机器人回复
//                    reply = robot.ask(sourceMsg).getReply();
//                }
//                // 去敏
//                if(chatService.isSensitive(reply)){
//                    reply = robot.randomReply().getReply();
//                }
//
//
////                String reply = robot.randomReply().getReply();

                Packet textMsg = new TextPacket(toId, fromId, reply);
                // 发送指令包
                Thread.sleep(1000);
//                System.out.println(" ==>> 发送指令包：输入中");
                client.send(new CmdPacket(toId,fromId,true));
                long inputDelay = ((TextPacket) textMsg).length() * 100;
                if(inputDelay>5000){
                    inputDelay=5000;
                }
                Thread.sleep(inputDelay);
//                System.out.println("发送指令包：输入结束");
                client.send(new CmdPacket(toId,fromId,false));
                // 发送消息
                client.send(textMsg);
                System.out.println("-->> 发送: (" + sdf.format(new Date()) +")" + textMsg.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
