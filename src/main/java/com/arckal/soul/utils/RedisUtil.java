package com.arckal.soul.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;

/**
 * @Author: arckal
 * @Date: 2019/5/31 22:18
 * @Version 1.0
 */
@Component
public class RedisUtil {
    //服务器IP地址
    @Value("${redis.host}")
    private  String HOST;
    //端口
    @Value("${redis.port}")
    private  int PORT;
    //密码
    @Value("${redis.password}")
    private  String AUTH;

    //连接实例的最大连接数
    private static int MAX_ACTIVE = 1024;
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200;
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出
    private static int MAX_WAIT = 10000;
    //连接超时的时间
    private static int TIMEOUT = 10000;
    // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;

    private  JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
    @PostConstruct
    public void init(){
        try {

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, HOST, PORT, TIMEOUT, AUTH);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    /**
     * 获取Jedis实例
     */

    public synchronized  Jedis getJedis() {

        try {

            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /***
     *
     * 释放资源
     */

    public  void returnResource(final Jedis jedis) {
        if(jedis != null) {
            jedisPool.returnResource(jedis);
        }

    }


}

