package com.arckal.soul.imlib;

/**
 * @Author: arckal
 * @Date: 2019/6/27 18:56
 * @Version 1.0
 */
public class GlobalParams {
    public static long a;

    public static long a() {
//        return a <= 0 ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + a;
        return System.currentTimeMillis();
    }

}
