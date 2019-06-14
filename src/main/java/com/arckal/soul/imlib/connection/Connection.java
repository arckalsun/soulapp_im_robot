package com.arckal.soul.imlib.connection;

import java.net.Socket;

/**
 * @Author: arckal
 * @Date: 2019/5/28 11:00
 * @Version 1.0
 */
public class Connection {
    public static final int b = 10000;
//    protected final
    protected Socket c;

    protected class a implements Runnable{
        private int b=0;
        private boolean c;

        public a(int i){
            this.b = i;
        }

        public void a(){
            this.c = false;
        }

        public void b(){

            this.c = true;
            run();
        }
        public void run(){
            while(this.c){
                try{
//                    Connection.this.h();
                }catch(Exception e){
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(this.b * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class b{
        static Connection a = new Connection();
        private  b(){}
    }

//    new
}
