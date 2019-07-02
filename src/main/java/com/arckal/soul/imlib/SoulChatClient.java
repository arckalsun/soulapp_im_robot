package com.arckal.soul.imlib;

import com.arckal.soul.SoulConfig;
import com.arckal.soul.dao.UserRedisDAO;
import com.arckal.soul.imlib.packets.AuthPacket;
import com.arckal.soul.imlib.packets.MyTextPacket;
import com.arckal.soul.imlib.packets.Packet;
import com.arckal.soul.thread.HeartBeatThread;
import com.arckal.soul.thread.PacketReaderThread;
import com.arckal.soul.thread.PacketWriterThread;
import com.arckal.soul.thread.RedisListenThread;
import com.arckal.soul.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @Author: arckal
 * @Date: 2019/5/27 15:29
 * @Version 1.0
 */
@Component
public class SoulChatClient implements Observer {
    private static Logger logger = Logger.getLogger(SoulChatClient.class.getName());
    private Thread readThread;
    private Thread writeThread;
    private Thread pingThread;
    private Thread redisListenThread;

    private Socket socket;
    private BlockingQueue<Packet> packetQueue;

    public String getSoulId() {
        return soulId;
    }

//    @Autowired
//    public ChatDAO chatDAO;

    @Autowired
    public ChatService chatService;

    @Autowired
    private UserRedisDAO userRedisDAO;

    public static SoulConfig soulConfig;

    public void setSoulId(String soulId) {
        this.soulId = soulId;
    }

    // IM客户端配置
    protected   String soulId;
    protected  String deviceId;
    protected  String token;

    // IM服务器地址端口
    private static final String host = "203.107.40.239";
    private static final int port = 8393;

    @Autowired
    public SoulChatClient(SoulConfig config){
        this.soulConfig = config;
        try{
            //文件控制器
            FileHandler fileHandler = new FileHandler("client.log");
            fileHandler.setLevel(Level.INFO);
            logger.addHandler(fileHandler);
            // 初始化队列
            this.packetQueue = new LinkedBlockingDeque<Packet>();
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public void restartThreads(){
        try {
            System.out.println("关闭其他线程");
            if(this.socket!=null){
                if(this.socket.isConnected()){
                    this.socket.shutdownInput();
                    this.socket.shutdownOutput();
                    this.socket.close();
                    this.socket=null;
                }

            }
            try{
                if(this.readThread!=null)
                    this.readThread.interrupt();
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(this.writeThread!=null)
                    this.writeThread.interrupt();
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(this.pingThread!=null)
                    this.pingThread.interrupt();
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(this.redisListenThread!=null)
                    this.redisListenThread.interrupt();
            }catch (Exception e){
                e.printStackTrace();
            }


            // 重连socket
            do{
                try{
                    System.out.println("连接socket");
                    this.socket = new Socket(host,port);
                }catch (Exception e){
                    System.out.println("socket连接失败");
                    e.printStackTrace();
                    Thread.sleep(5000);
                }
            } while(this.socket==null);

            if(this.socket.isConnected()==true){
                System.out.println("connect success: " + this.socket.getRemoteSocketAddress());

                // 开启一个接收数据的线程
                PacketReaderThread packetReaderThread = new PacketReaderThread(this.socket.getInputStream());
                packetReaderThread.addObserver(this);
                this.readThread = new Thread(packetReaderThread);
                this.readThread.setDaemon(true);
                this.readThread.start();

                // 发送认证包
                this.soulId = soulConfig.getUserId();
                this.deviceId = soulConfig.getDeviceId();
                this.token = soulConfig.getToken();
                System.out.println("发送认证包");
                Packet authPacket = new AuthPacket(this.soulId,this.deviceId,this.token);
                send(authPacket);

                // 开启一个发送数据的线程
                PacketWriterThread packetWriterThread = new PacketWriterThread(this.socket.getOutputStream(),this.packetQueue);
                packetWriterThread.addObserver(this);
                this.writeThread = new Thread(packetWriterThread);
                this.writeThread.setDaemon(true);
                this.writeThread.start();

                // 开启心跳包线程
                HeartBeatThread heartBeatThread = new HeartBeatThread(this.packetQueue);
                heartBeatThread.addObserver(this);
                this.pingThread = new Thread(heartBeatThread);
                this.pingThread.setDaemon(true);
                this.pingThread.start();
                System.out.println("所有线程启动完毕！");

                // 开启监听redis任务的线程
                Thread.sleep(5*1000);
                System.out.println("开始监听redis队列");
                RedisListenThread redisListenThread1 = new RedisListenThread(userRedisDAO,this);
                redisListenThread1.addObserver(this);
                this.redisListenThread = new Thread(redisListenThread1);
                this.redisListenThread.setDaemon(false);
                this.redisListenThread.start();



            }else{
                System.out.println("socket连接失败" + host + ":" + port);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        restartThreads();
    }

//    private static class SingletonClass{
//        private static final SoulChatClient instance = new SoulChatClient();
//    }
//
//
//    public static SoulChatClient getInstance(){
//        return  SoulChatClient.SingletonClass.instance;
//    }


    public void start(){
        try{
//            //文件控制器
//            FileHandler fileHandler = new FileHandler("client.log");
//            fileHandler.setLevel(Level.INFO);
//            logger.addHandler(fileHandler);
//            // 初始化队列
//            this.packetQueue = new LinkedBlockingDeque<Packet>();

            restartThreads();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 发送数据包
     * @param packet
     * @throws InterruptedException
     */
    public void send(Packet packet) throws InterruptedException {
        if (packetQueue==null || packet==null)
            return;

        packetQueue.put(packet);
        // 保存数据
        if(packet instanceof MyTextPacket){
            TextMsgCommand msg = new TextMsgCommand(((MyTextPacket) packet).getFromId(),
                    ((MyTextPacket) packet).getToId(),
                    ((MyTextPacket) packet).getText(),
                    ((MyTextPacket) packet).getMsgTime());
            chatService.saveTextMsgCommand(msg);
        }

    }

//    public static void main(String[] args) throws IOException, InterruptedException {
//        // 创建客户端
//        SoulChatClient client =  SoulChatClient.getInstance();
//
//        // 构造数据包
//        String toUserId = "29885200";
//        packets textPacket = new MyTextPacket(client.soulId,toUserId,"hello,arckal");
//        packets typeStartPacket = new CmdPacket(client.soulId,toUserId,true);
//        packets typeEndPacket = new CmdPacket(client.soulId,toUserId,false);
//
//        // 发送指令包
////        System.out.println("发送指令包：输入中");
//        client.send(typeStartPacket);
//        Thread.sleep(1000);
////        System.out.println("发送指令包：输入结束");
//        client.send(typeEndPacket);
//        // 发送消息包
//        System.out.printf("-->> 发送:");
//        System.out.println(textPacket.toString());
//        client.send(textPacket);
//
//    }
}
