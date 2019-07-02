package com.arckal.soul.imlib.handler;

import com.arckal.soul.imlib.connection.PacketWriter;
import com.arckal.soul.imlib.msg.ImMessage;
import com.arckal.soul.imlib.msg.chat.ChatMessage;
import com.arckal.soul.imlib.packets.PacketConverter;
import com.arckal.soul.thread.ReplyThread;
import com.arckal.soul.protos.*;
import com.arckal.soul.protos.MsgCommandOuterClass.MsgCommand;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: arckal
 * @Date: 2019/6/25 17:01
 * @Version 1.0
 */
public class ChatHandler extends HandlerAdapter {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 回复消息的线程池
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(500);

    @Override
    public void handle(CommandMessageOuterClass.CommandMessage commandMessage) {
//        System.out.println("[Handler " + this.getClass().getName()+ " ] " + commandMessage);
        try{
            MsgCommand msgCommand = commandMessage.getMsgCommand();
//            System.out.println(msgCommand);
            switch (msgCommand.getType()){
                case READ:
                    handleRead(msgCommand);
                    break;
                case TEXT:
                    handleText(msgCommand);
                    sendReadCallback(commandMessage);
                    break;
                case PIC:
                    handlePic(msgCommand);
                    sendReadCallback(commandMessage);
                    break;
                case VOICE:
                    handleVoice(msgCommand);
                    sendReadCallback(commandMessage);
                    break;
                case VIDEO:
                    handleVideo(msgCommand);
                    sendReadCallback(commandMessage);
                    break;
                case EXPRESSION:
                    handleExpression(msgCommand);
                    break;
                case USER_EXPRESSION:
                    handleUserExpression(msgCommand);
                    break;
                case POSITION:
                    handlePosition(msgCommand);
                    break;
                case EXT_CMD:
                    handleExtChat(msgCommand);
                    break;
                case MUSIC:
                    handleMusic(msgCommand);
                    sendReadCallback(commandMessage);
                    break;
                default:
                    handleOther(msgCommand);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private void sendReadCallback(CommandMessageOuterClass.CommandMessage commandMessage){
        String from = commandMessage.getMsgCommand().getTo();
        String to = commandMessage.getMsgCommand().getFrom();
        String cmdId = commandMessage.getCmdId();
        ChatMessage create = ChatMessage.create(from);
        create.setMsgType(21);
        ImMessage createChatSendMsg = ImMessage.createChatSendMsg(create, to,cmdId);// 切入分析
        PacketWriter.sendPacket(PacketConverter.convert(createChatSendMsg));
//        System.out.println("发送已读回执：");
    }
    public void handleText(MsgCommand msg){
        // 新开一个线程回复
//        System.out.println("接收到文本");
//        TextMsgOuterClass.TextMsg textMsg = msg.getTextMsg();
//        String content = "from:" + msg.getFrom() + ", to:" + msg.getTo() + ", " + textMsg.getText();
//        System.out.println("\033[31;4m<<-- 接收: (" + sdf.format(new Date()) +") \n"+ content +"\033[0m");
        fixedThreadPool.execute(new ReplyThread(msg));
    }

    public void handlePic(MsgCommand msg){
        System.out.println("接收到图片");
//        PicMessageOuterClass.PicMessage picMessage = msg.getPicMessage();
//        System.out.println(picMessage);
        fixedThreadPool.execute(new ReplyThread(msg));
    }
    public void handleVoice(MsgCommand msg){
        VoiceMessageOuterClass.VoiceMessage voiceMessage = msg.getVoiceMessage();
        System.out.println("接收到声音: " + voiceMessage.getWord());
//        System.out.println(voiceMessage);
        // 语音识别
        // 语音合成
        ReplyThread batchSendThread = new ReplyThread(msg);
        fixedThreadPool.execute(batchSendThread);

    }
    public void handleVideo(MsgCommand msg){
        System.out.println("接收到视频");
        VideoMessageOuterClass.VideoMessage videoMessage = msg.getVideoMessage();
        System.out.println(videoMessage);
    }
    public void handleExpression(MsgCommand msg){
        System.out.println("接收到表达式");
        ExpressionMessageOuterClass.ExpressionMessage expressionMessage = msg.getExpressionMessage();
//        System.out.println(expressionMessage);
    }
    public void handleUserExpression(MsgCommand msg){
        System.out.println("接收到用户表情");
//        ExpressionMessageOuterClass.ExpressionMessage expressionMessage = msg.getExpressionMessage();
//        System.out.println(expressionMessage);
        fixedThreadPool.execute(new ReplyThread(msg));
    }
    public void handleMusic(MsgCommand msg){
        System.out.println("接收到音乐");
        MusicMessageOuterClass.MusicMessage musicMessage = msg.getMusicMessage();
        System.out.println(musicMessage);
    }
    public void handlePosition(MsgCommand msg){
        PositionMessageOuterClass.PositionMessage positionMessage = msg.getPositionMessage();
        System.out.println("接收到位置: " + positionMessage.getAddress());
        System.out.print(positionMessage.getLng() + ", ");
        System.out.println(positionMessage.getLat());
        fixedThreadPool.execute(new ReplyThread(msg));
    }
    public void handleExtChat(MsgCommand msg){
        ExtChatMessageOuterClass.ExtChatMessage extChatMessage = msg.getExtChatMessage();
        System.out.println("接收到ExtChat: " + extChatMessage.getContent());
//        System.out.println(extChatMessage);
        fixedThreadPool.execute(new ReplyThread(msg));
    }
    public void handleRead(MsgCommand msg){
//        System.out.println("接收到Read");
//        System.out.println(msg.getTextMsg());
    }
    public void handleOther(MsgCommand msg){
        fixedThreadPool.execute(new ReplyThread(msg));
//        System.out.println("接收到其他消息");
//        System.out.println("\033[31;4m<<-- 接收: (" + sdf.format(new Date()) +") \n"+ msg+"\033[0m");

    }
}
