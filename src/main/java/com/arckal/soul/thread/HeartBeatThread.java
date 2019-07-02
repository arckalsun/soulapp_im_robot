package com.arckal.soul.thread;

import com.arckal.soul.imlib.packets.Packet;
import com.arckal.soul.imlib.packets.PingPacket;

import java.util.Observable;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: arckal
 * @Date: 2019/5/30 20:13
 * @Version 1.0
 */
public class HeartBeatThread extends Observable implements Runnable {

    private BlockingQueue<Packet> packetQueue;

    public HeartBeatThread(BlockingQueue<Packet> queue){
        this.packetQueue = queue;
    }

    @Override
    public void run() {
        while (this.packetQueue!=null){
            try {
                this.packetQueue.put(new PingPacket());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
