package com.arckal.soul.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arckal.soul.imlib.packets.MyTextPacket;
import com.arckal.soul.imlib.packets.chat.SyncPacket;
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

    private  Jedis jedis;

    @PostConstruct
    public void init(){
        this.jedis = redisUtil.getJedis();
    }
    public  String nextSoulUserId(){
        return jedis.lpop("soul:users");
    }

    public MyTextPacket nextTextPacket(String fromUID){
        try {
            List<String> args = jedis.blpop(2, "soul:WaitSendQueue");
            if(args==null){
                return null;
            }
//            System.out.println(args.get(1));
            JSONObject js = JSON.parseObject(args.get(1));
            String toUID = js.getString("toUID");
            String content = js.getString("content");
            return new MyTextPacket(fromUID, toUID, content);
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
