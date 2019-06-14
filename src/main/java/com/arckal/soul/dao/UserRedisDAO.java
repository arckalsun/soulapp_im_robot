package com.arckal.soul.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arckal.soul.imlib.Packet.Packet;
import com.arckal.soul.imlib.Packet.TextPacket;
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

    public  TextPacket nextTextPacket(String fromUID){
        try{
            List<String> args = jedis.blpop( 1000*60,"soul:WaitSendQueue");
//            System.out.println(args.get(1));
            JSONObject js = JSON.parseObject(args.get(1));
            String toUID = js.getString("toUID");
            String content = js.getString("content");
            return new TextPacket(fromUID,toUID,content);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
//    public static void main(String[] args){
////        System.out.println(UserRedisDAO.nextSoulUserId());
//        Packet packet = UserRedisDAO.nextTextPacket("390970");
//        System.out.println(packet);
//    }
}
