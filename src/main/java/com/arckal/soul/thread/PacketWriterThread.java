package com.arckal.soul.thread;

import com.arckal.soul.imlib.packets.Packet;
import com.arckal.soul.imlib.packets.PingPacket;
import com.arckal.soul.utils.EncryptUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: arckal
 * @Date: 2019/5/30 14:22
 * @Version 1.0
 */
public class PacketWriterThread extends Observable implements Runnable {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private OutputStream outputStream;  // 可能有线程安全的问题
    private BlockingQueue<Packet> packetQueue;

    //此方法一旦调用，立马可以通知观察者。这是监听线程
    public void doBusiness(){
        if(true){
            super.setChanged();
        }
        notifyObservers();
    }


    public PacketWriterThread(OutputStream outputStream, BlockingQueue<Packet> packetQueue){
        this.outputStream = outputStream;
        this.packetQueue = packetQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Packet packet = this.packetQueue.take();
                send(packet);

            }catch (Exception e){
                e.printStackTrace();
//                doBusiness();
                break;
            }

        }
    }

    public synchronized void send(Packet bVar) throws IOException {
        if(this.outputStream != null){
            byte[] b = bVar.b();
//            System.out.println("DAT: " + DataUtils.bytesToHexString(bVar.getData()));
            if (!(bVar instanceof PingPacket)){
                b = EncryptUtils.encrypt(bVar.b());
//                System.out.println("ENC: "+DataUtils.bytesToHexString(b));
            }

            // 计算签名
            byte[] a = bVar.a(b==null ? 0 : b.length);

            String timeStr = sdf.format(new Date());
            // 发送
            if (a != null && a.length > 0) {
                this.outputStream.write(a);	//  this.e = new BufferedOutputStream(outputStream);
//                System.out.println("["+timeStr+" send header] " + DataUtils.bytesToHexString(chat));
            }
            if (b != null && b.length >= 0) {
                this.outputStream.write(b);
//                System.out.println("["+timeStr+" send body] " + DataUtils.bytesToHexString(b));
            }
            this.outputStream.flush();

        }else{
            System.out.println("socket异常: "+Thread.currentThread());
        }
    }
}
