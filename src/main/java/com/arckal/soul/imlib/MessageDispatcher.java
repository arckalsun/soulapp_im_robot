package com.arckal.soul.imlib;

import com.arckal.soul.dao.ChatDAO;
import com.arckal.soul.dao.UserRedisDAO;
import com.arckal.soul.imlib.thread.ReplyThread;
import com.arckal.soul.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: arckal
 * @Date: 2019/5/30 21:08
 * @Version 1.0
 */

public class MessageDispatcher {

    private ChatService chatService;

    private SoulChatClient client;

    // 回复消息的线程池
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(500);

    public MessageDispatcher(SoulChatClient client, ChatService chatService){
        this.client = client;
        this.chatService = chatService;
    }
    public void handle(Command cmd) {
        try {
            if (cmd==null)
                return;
            // 新开一个线程回复
            ReplyThread batchSendThread = new ReplyThread(cmd,client,chatService);
            fixedThreadPool.execute(batchSendThread);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
