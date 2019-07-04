package com.arckal.soul.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arckal.soul.imlib.msg.ImMessage;
import com.arckal.soul.imlib.msg.chat.ChatMessage;
import com.arckal.soul.imlib.msg.chat.ExpressionMsg;
import com.arckal.soul.imlib.msg.chat.TextMsg;
import com.arckal.soul.imlib.packets.MyTextPacket;
import com.arckal.soul.imlib.packets.Packet;
import com.arckal.soul.imlib.packets.PacketConverter;
import com.arckal.soul.imlib.packets.chat.SyncPacket;
import com.arckal.soul.imlib.packets.chat.a.TextPacket;
import com.arckal.soul.protos.CommandMessageOuterClass;
import com.arckal.soul.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Author: arckal
 * @Date: 2019/6/1 18:57
 * @Version 1.0
 */
@Component
public class UserRedisDAO {
    @Autowired
    private  RedisUtil redisUtil;

    @Autowired
    private ChatDAO chatDAO;

    private  Jedis jedis;

    @PostConstruct
    public void init(){
        this.jedis = redisUtil.getJedis();
    }

    public  String nextSoulUserId(){
        return jedis.lpop("soul:users");
    }

    /***
     * msg = {
     *         "toUID":toUid,
     *         "content":text,
     *         "type":type,
     *         "delay":delay,
     *     }
     * @param fromUID
     * @return
     */
    public Packet nextPacket(String fromUID){
        try {
            List<String> args = jedis.blpop(2, "soul:WaitSendQueue");
            if(args==null){
                return null;
            }
//            System.out.println(args.get(1));
            ChatMessage chatMessage = ChatMessage.create(fromUID);
            JSONObject js = JSON.parseObject(args.get(1));
            String toUID = js.getString("toUID");
            String content = js.getString("content");
            String type = js.getString("type");
            int delay = js.getIntValue("delay");

            if(type.equalsIgnoreCase("text")){
                chatMessage.setMsgType(1);
                chatMessage.setMsgContent(new TextMsg(content));

            }else if(type.equalsIgnoreCase("img")){
                ExpressionMsg expressionMsg = new ExpressionMsg();
                expressionMsg.imageUrl = content;
                expressionMsg.imageH = 600;
                expressionMsg.imageW = 600;
                chatMessage.setMsgType(8);
                chatMessage.setMsgContent(expressionMsg);
            }else{
                System.out.println("未知类型：" + type);
            }
            System.out.printf("-->> 发送:");
            if(delay<=0 || delay>=1000){
                delay = 1000;
            }
            Thread.sleep(delay);
            System.out.println("[From: " + fromUID+", To: " + toUID + "] " + content  );

            ImMessage imMessage = ImMessage.createChatSendMsg(chatMessage,toUID);
            chatDAO.saveImMessage(imMessage);
            return PacketConverter.convert(imMessage);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public SyncPacket nextSyncPacket_SYNC(){
        try{
            List<String> args = jedis.blpop( 2,"soul:queue:SyncPacket_sync");
            if(args==null){
                return null;
            }
//            System.out.println(args.get(1));
            JSONObject js = JSON.parseObject(args.get(1));
            String startMsgId = js.getString("startMsgId");
            String startTimestamp = js.getString("startTimestamp");
            String endMsgId = js.getString("endMsgId");
            String endTimestamp = js.getString("endTimestamp");
            return new SyncPacket(startMsgId,startTimestamp, endMsgId,endTimestamp);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public SyncPacket nextSyncPacket(){
        try{
            List<String> args = jedis.blpop( 2,"soul:queue:SyncPacket");
            if(args==null){
                return null;
            }
//            System.out.println(args.get(1));
            JSONObject js = JSON.parseObject(args.get(1));
            String startMsgId = js.getString("startMsgId");
            String startTimestamp = js.getString("startTimestamp");
            return new SyncPacket(startMsgId,startTimestamp, CommandMessageOuterClass.CommandMessage.Type.MSG);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args){
////        System.out.println(UserRedisDAO.nextSoulUserId());
//        packets packets = UserRedisDAO.nextTextPacket("390970");
//        System.out.println(packets);
//    }
}
