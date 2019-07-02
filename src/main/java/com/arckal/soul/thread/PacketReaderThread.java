package com.arckal.soul.thread;

import com.arckal.soul.imlib.MessageDispatcher;
import com.arckal.soul.protos.CommandGroupOuterClass;
import com.arckal.soul.utils.DataUtils;
import com.arckal.soul.utils.EncryptUtils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Observable;
import java.util.logging.Logger;

/**
 * @Author: arckal
 * @Date: 2019/5/30 14:29
 * @Version 1.0
 */
public class PacketReaderThread extends Observable implements Runnable {
    private InputStream inputStream;
    private static Logger logger = Logger.getLogger(PacketReaderThread.class.getName());
    private static final int MESSAGE_SIZE = 1024;
    private boolean h;
    private byte[] g;
    private MessageDispatcher messageDispatcher;


    public PacketReaderThread(InputStream in ){
        this.inputStream = in;
        this.messageDispatcher = MessageDispatcher.getInstance();
    }


    //此方法一旦调用，立马可以通知观察者。这是监听线程
    public void doBusiness(){
        if(true){
            super.setChanged();
        }
        notifyObservers();
    }

    @Override
    public void run() {
        try{
            byte[] b;
            while (this.inputStream != null){
                b = new byte[MESSAGE_SIZE];
                int returnLen = this.inputStream.read(b);
//                System.out.println("======return length: " + returnLen);
                if(returnLen>0){
                    byte[] data = Arrays.copyOf(b,returnLen);
                    // 处理数据包
                    try{
                        handleBytes(data,data.length);
                    }catch (Exception e){
                    }

                }else{
                    logger.info("the inputstream closed "+ returnLen);
                    Thread.sleep(5000);
                    this.inputStream.close();
                    doBusiness();
                    break;
//                    System.exit(-1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            // 断线重连
            doBusiness();
        }
    }

    private boolean d(){
        return this.h && this.g!=null && this.g.length>0;
    }
    private boolean a(byte[] bArr){
        return bArr[0] == (byte) 1 && bArr[1] == (byte) 2;
    }

    /**
     * 处理数据包，拼包
     * @param bArr
     * @param i
     */
    private void handleBytes(byte[] bArr, int i){
        if (i != 2) {
            if(!a(bArr) || d()){
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                this.g = (byte[]) DataUtils.concatArrays(this.g, bArr2);	//	this.g += bArr2 此处应该是拼包
                bArr = new byte[this.g.length];
                System.arraycopy(this.g, 0, bArr, 0, this.g.length);
                i = bArr.length;
            }
            if (a(bArr)){// 数据包是0102开头
                byte[] bArr3 = new byte[5];
                bArr3[0] = (byte) 0;
                bArr3[1] = (byte) 0;
                bArr3[2] = bArr[2];
                bArr3[3] = bArr[3];
                int a = DataUtils.gaa(bArr3,0);
                int i2 = i - 5;
                if (a > i2) {
                    this.g = new byte[i];
                    System.arraycopy(bArr, 0, this.g, 0, i);
                    this.h = true;
                    return;
                }
                this.h = false;
                this.g = new byte[0];
                byte[] obj = new byte[a];
                System.arraycopy(bArr, 5, obj, 0, a);
                try {
                    if (bArr[4] != (byte) 0) {
                        // 解密
                        byte[] data = EncryptUtils.decrypt(obj);
                        // 解析
                        messageDispatcher.dispatch(CommandGroupOuterClass.CommandGroup.parseFrom(data));
                    } else {
                        // 解析
                        messageDispatcher.dispatch(CommandGroupOuterClass.CommandGroup.parseFrom(obj));
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }
                if (a < i2) {
                    i2 -= a;
                    obj = new byte[i2];
                    System.arraycopy(bArr, a + 5, obj, 0, i2);
                    handleBytes(obj, obj.length);
                }
                return;
            }
            this.h = false;
            this.g = new byte[0];
        }
    }
}
