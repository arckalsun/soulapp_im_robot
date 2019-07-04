package com.arckal.soul.thread;

import com.arckal.soul.enums.ReplyType;
import com.arckal.soul.imlib.ChatReply;
import com.arckal.soul.imlib.msg.ImMessage;
import com.arckal.soul.imlib.msg.chat.*;
import com.arckal.soul.imlib.packets.Packet;
import com.arckal.soul.imlib.packets.PacketConverter;
import com.arckal.soul.protos.MsgCommandOuterClass.MsgCommand;
import com.arckal.soul.service.ChatService;
import com.arckal.soul.utils.SpringContextUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: arckal
 * @Date: 2019/6/1 19:41
 * @Version 1.0
 */
public class ReplyThread implements Runnable {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private MsgCommand cmd;
    private ChatService chatService;
    private ReplyType replyType;

    public ReplyThread(MsgCommand cmd){
        this.cmd = cmd;
        chatService = SpringContextUtil.getBean(ChatService.class);
    }



    @Override
    public void run() {
        try {
            if (cmd==null)
                return;

            if (cmd instanceof MsgCommand){

                String fromId = cmd.getFrom(); // 消息来源
                String toId = cmd.getTo();
                ChatReply reply;
                String text;
                ChatMessage chatMessage = ChatMessage.create(toId);
                boolean hasNextMsg = false;
                ChatMessage chatMessageNext = ChatMessage.create(toId);

                // 发送指令包
                Thread.sleep(1000);
//                System.out.println(" ==>> 发送指令包：输入中");
                // 指令包 输入中
                ChatMessage chatMessage1 = ChatMessage.create(toId);
                chatMessage1.setMsgType(22);
                ImMessage imMessage1 = ImMessage.createChatSendMsg(chatMessage1,fromId);
                Packet packetInputStart = PacketConverter.convert(imMessage1);    //引
                chatService.send(packetInputStart);
                long inputDelay = 1000;

                switch (this.cmd.getType()){
                    case TEXT :

                        String sourceMsg = cmd.getTextMsg().getText();
                        System.out.println("\033[31;4m<<-- 接收: (" + sdf.format(new Date()) +")[From:"+ fromId
                                + ", To:" + toId + "]" + sourceMsg.trim() +"\033[0m");
                        chatService.saveMsgCommand(cmd);
                        // 调用机器人
                        reply = chatService.askRobot(fromId,sourceMsg);
                        if(reply.getType().equalsIgnoreCase("img")){
                            ExpressionMsg expressionMsg = new ExpressionMsg();
                            expressionMsg.imageUrl = reply.getText();
                            expressionMsg.imageH = 500;
                            expressionMsg.imageW = 500;
                            chatMessage.setMsgType(8);
                            chatMessage.setMsgContent(expressionMsg);
                        }else if(reply.getType().equalsIgnoreCase("text")){
                            text = reply.getText();
                            chatMessage.setMsgType(1);
                            chatMessage.setMsgContent(new TextMsg(text));
                            inputDelay = text.length() * 100;
                            if(inputDelay>5000){
                                inputDelay=5000;
                            }
                        }else{
                            // 异步回答
                            System.out.println("wait answer: " + reply.getText());
                        }

                        Thread.sleep(inputDelay);
                        break;
                    case VOICE:
//                        chatMessage.setMsgType(5);
//                        chatMessage.setMsgContent(new AudioMsg("","D:\\test\\tmp\\public\\16k.wav",3,"哈哈"));
                        String sourceMsg1 = cmd.getVoiceMessage().getWord();
                        System.out.println("\033[31;4m<<-- 接收: (" + sdf.format(new Date()) +")[From:"+ fromId
                                + ", To:" + toId + "]" + sourceMsg1.trim() +"\033[0m");
                        chatService.saveMsgCommand(cmd);
                        // 调用机器人
                        reply = chatService.askRobot(fromId,sourceMsg1);
                        hasNextMsg = true;
                        chatMessageNext.setMsgType(1);
                        chatMessageNext.setMsgContent(new TextMsg("你的声音很好听嘛！"));

                        if(reply.getType().equalsIgnoreCase("img")){
                            ExpressionMsg imgMsg = new ExpressionMsg();
                            imgMsg.imageUrl = reply.getText();
                            imgMsg.imageH = 600;
                            imgMsg.imageW = 600;
                            chatMessage.setMsgType(8);
                            chatMessage.setMsgContent(imgMsg);
                        }else if(reply.getType().equalsIgnoreCase("text")){
                            text = reply.getText();
                            chatMessage.setMsgType(1);
                            chatMessage.setMsgContent(new TextMsg(text));
                            inputDelay = text.length() * 100;
                            if(inputDelay>5000){
                                inputDelay=5000;
                            }
                        }else{
                            System.out.println("wait answer: " + reply.getText());
                        }

                        Thread.sleep(inputDelay);
                        break;
                    case USER_EXPRESSION:
                        chatMessage.setMsgType(8);
                        ExpressionMsg expressionMsg = ExpressionMsg.convert(this.cmd.getUserExpressionMessage());
                        chatMessage.setMsgContent(expressionMsg);
                        Thread.sleep(1000);
                        chatService.saveMsgCommand(cmd);
                        break;
                    case PIC:
                        chatMessage.setMsgType(2);
                        chatMessage.setMsgContent(ImgMsg.convert(this.cmd.getPicMessage()));
                        Thread.sleep(1000);
                        chatService.saveMsgCommand(cmd);
                        break;
                    case EXT_CMD:
                        chatMessage.setMsgType(30);
                        if(cmd.getExtChatMessage().getType()==2){
                            VoiceChatMsg voiceChatMsg = new VoiceChatMsg();
                            voiceChatMsg.type = VoiceChatMsg.OVER_AUDIO_CHAT;
                            voiceChatMsg.content = "我不能语音通话哦，你找我主人吧，哈哈哈\n15957156851";
                            voiceChatMsg.channelId = cmd.getVoiceChatMessage().getChannelId();
                            chatMessage.setMsgContent(voiceChatMsg);
                        }
                        break;
                    case POSITION:
                        chatMessage.setMsgType(33);
                        PositionMsg positionMsg = new PositionMsg("这是我主人的家哦",
                                "杭州市西湖区凌波路5号",
                                120.06153399999991,30.28594403874948);
                        chatMessage.setMsgContent(positionMsg);
                        chatService.saveMsgCommand(cmd);
                        break;
                    case ROLL_DICE:
                        // 读取对方点数
                        int point = cmd.getRollDiceMessage().getDicePoints();
                        System.out.println("点数：" + point);
                        int myPoint = (int)(1+Math.random()*6);
                        chatMessage.setMsgType(13);
                        chatMessage.setMsgContent(new DiceFingerMsg(myPoint));
                        chatMessageNext.setMsgType(1);
                        hasNextMsg = true;
                        if(myPoint<point){
                            chatMessageNext.setMsgContent(new TextMsg("我输了！"));
                        }else if(myPoint>point){
                            chatMessageNext.setMsgContent(new TextMsg("我赢了，哈哈哈~"));
                        }else{
                            hasNextMsg = false;
                        }
                        Thread.sleep(2000);
                        break;
                    case FINGER_GUESS:
                        // 3, 石头
                        // 2, 剪刀
                        // 1, 布
                        int point2 = cmd.getFingerGuessMessage().getFinger();
                        System.out.println("点数：" + point2);
                        int myPoint2 = (int)(1+Math.random()*3);
                        chatMessage.setMsgType(12);
                        chatMessage.setMsgContent(new DiceFingerMsg(myPoint2));

                        chatMessageNext.setMsgType(1);
                        hasNextMsg = true;
                        if(myPoint2==1 && point2 == 2){
                            chatMessageNext.setMsgContent(new TextMsg("我输了！"));
                        }else if(myPoint2==1 && point2 == 3){
                            chatMessageNext.setMsgContent(new TextMsg("我赢了，哈哈哈~"));
                        }else if(myPoint2==2 && point2 == 1){
                            chatMessageNext.setMsgContent(new TextMsg("我赢了，哈哈哈~"));
                        }else if(myPoint2==2 && point2 == 3){
                            chatMessageNext.setMsgContent(new TextMsg("我输了，啊————"));
                        }else if(myPoint2==3 && point2 == 1){
                            chatMessageNext.setMsgContent(new TextMsg("我输了，啊————"));
                        }else if(myPoint2==3 && point2 == 2){
                            chatMessageNext.setMsgContent(new TextMsg("我赢了，哈哈哈~"));
                        }else{
                            hasNextMsg = false;
                        }
                        Thread.sleep(2000);
                        break;
                    default:
                        break;
                }
//                System.out.println("发送指令包：输入结束");
                // 指令包 输入结束
                ChatMessage chatMessage2 = ChatMessage.create(toId);
                chatMessage2.setMsgType(23);
                ImMessage imMessage2 = ImMessage.createChatSendMsg(chatMessage2,fromId);
                Packet packetInputEnd = PacketConverter.convert(imMessage2);    //引
                chatService.send(packetInputEnd);

                if(chatMessage.getMsgType()==0){
                    return;
                }

                ImMessage imMessage = ImMessage.createChatSendMsg(chatMessage,fromId);
                Packet packet = PacketConverter.convert(imMessage);


                // 发送消息

                chatService.send(packet);
                chatService.saveImMessage(imMessage);
                if(chatMessage.getMsgType()==1){
                    System.out.println("-->> 发送: (" + sdf.format(new Date()) +", To:" + imMessage.getTo()
                            + ") " + ((TextMsg)chatMessage.getMsgContent()).text.trim());
                }else{
                    System.out.println("-->> 发送: (" + sdf.format(new Date()) +", To:" + imMessage.getTo()
                            + ") " + chatMessage.getMsgType());
                }
                if(hasNextMsg){
                    Thread.sleep(2000);
                    chatService.send(PacketConverter.convert(ImMessage.createChatSendMsg(chatMessageNext,fromId)));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
