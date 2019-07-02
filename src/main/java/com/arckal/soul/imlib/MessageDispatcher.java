package com.arckal.soul.imlib;

import com.arckal.soul.imlib.handler.MsgHandlerProvider;
import com.arckal.soul.protos.CommandGroupOuterClass;
import com.arckal.soul.protos.CommandMessageOuterClass;
import com.arckal.soul.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: arckal
 * @Date: 2019/5/30 21:08
 * @Version 1.0
 */

public class MessageDispatcher {
    private MsgHandlerProvider provider;
    private BlockingQueue<CommandGroupOuterClass.CommandGroup> queue;
    private boolean c;
    private MessageDispatcherThread thread;

    private final class MessageDispatcherThread extends Thread {
        public boolean a;
        private MessageDispatcherThread(){
            this.a = true;
        }
        /**
         * 线程执行代码
         */
        public void run(){
            while (true){
                try {
                    MessageDispatcher messageDispatcher = MessageDispatcher.getInstance();
                    CommandGroupOuterClass.CommandGroup commandGroup = messageDispatcher.queue.take();
                    messageDispatcher.handle(commandGroup);
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("解析接收消息异常！");
                }

            }
        }
    }
    // 单例类
    private static class Singleton{
        static MessageDispatcher instance = new MessageDispatcher();
        private Singleton(){

        }
    }
    // 获取单例实例
    public static MessageDispatcher getInstance(){
        return Singleton.instance;
    }
    // 私有化构造方法
    private MessageDispatcher(){
        this.provider = MsgHandlerProvider.getInstance();
        this.queue = new LinkedBlockingDeque();
        start();
    }

    private synchronized void start(){
        if (!this.c){
            this.c = true;
            this.thread = new MessageDispatcherThread();
            this.thread.start();
        }
    }

    public void clear(){
        this.queue.clear();
    }

    /**
     * 分配任务
     * @param group
     */
    public void dispatch(CommandGroupOuterClass.CommandGroup group){
        try{
            this.queue.put(group);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 中断线程
     */
    public void interrupt(){
        this.c = false;
        if(this.thread!=null){
            this.thread.a = false;
            try{
                this.thread.interrupt();
            }catch (Exception e){

            }
        }
    }
    public void handle(CommandGroupOuterClass.CommandGroup commandGroup) {
        try {
            if (commandGroup==null)
                return;
            int commandsCount = commandGroup.getCommandsCount();
            if (commandsCount != 0){
                List list = null;
                List list2 = list;
                List list3 = list2;
                CommandMessageOuterClass.CommandMessage commandMessage = null;
                for (int i=0; i<commandsCount; i++){
                    CommandMessageOuterClass.CommandMessage commands = commandGroup.getCommands(i);
                    switch (commands.getTypeValue()){
                        case 0:
                            if(list==null){
                                list = new ArrayList();
                            }
                            list.add(commands);
                            break;
                        case 2:
                        case 5:
                            this.provider.getHandler(commands.getTypeValue()).handle(commands);
                            break;
                        case 6:
                            if (list2 == null){
                                list2 = new ArrayList();
                            }
                            list2.add(commands);
                            break;
                        case 7:
                            if(list3==null){
                                list3 = new ArrayList();
                            }
                            list3.add(commands);
                            break;
                        default:
                            break;
                    }
                }
                try{
                    if(!ListUtils.isEmpty(list)){
                        this.provider.getHandler(0).handle(list);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

                if (commandMessage != null) {
                    try {
                        this.provider.getHandler(3).handle(commandMessage);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                    if (!ListUtils.isEmpty(list3)) {
                        this.provider.getHandler(7).handle(list3);
                    }
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
                try {
                    if (!ListUtils.isEmpty(list2)) {
                        this.provider.getHandler(6).handle(list2);
                    }
                } catch (Exception e222) {
                    e222.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
