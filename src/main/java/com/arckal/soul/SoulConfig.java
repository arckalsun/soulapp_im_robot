package com.arckal.soul;

import com.arckal.soul.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;

/**
 * @Author: arckal
 * @Date: 2019/5/31 22:29
 * @Version 1.0
 */
@Component
public class SoulConfig {
    @Autowired
    private RedisUtil redisUtil;

    private Jedis jedis;

    @PostConstruct
    public void init(){
        jedis = redisUtil.getJedis();
    }

    public String getUserId(){
        return jedis.get("soul:user");
    }

    public String getToken(){
        return jedis.get("soul:"+getUserId()+":token");
    }

    public String getDeviceId(){
        return jedis.get("soul:"+getUserId()+":deviceid");
    }

    public String setUserId(String userid){
        return jedis.set("soul:user",userid);
    }

    public String setDeviceId(String userid,String deviceId){
        return jedis.set("soul:" + userid + ":deviceid",deviceId);
    }
    public String setToken(String userid,String token){
        return jedis.set("soul:" + userid + ":token",token);
    }

//    public static void main(String[] args){
//        String userid="390970";
//        String deviceid="W/y1xyPrPHQDAP1NlA873wmL";
//        String token="A7OEwt3jwtQ8iumMVJM6/NVVf94e7gDX";
//        System.out.println("set userid: "+SoulConfig.setUserId(userid));
//        System.out.println("set deviceid: "+SoulConfig.setDeviceId(userid,deviceid));
//        System.out.println("set token: "+SoulConfig.setToken(userid,token));
//
//
//    }
}
