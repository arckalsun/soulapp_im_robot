package com.arckal.soul.utils;

import java.io.ByteArrayOutputStream;

/**
 * @Author: arckal
 * @Date: 2018/12/11 17:56
 * @Version 1.0
 */
public class Ecpt {
    private static char[] a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static byte[] b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String toEcpt(String var0) {
        byte[] var7 = var0.getBytes();
        StringBuffer var6 = new StringBuffer();
        int var2 = var7.length;
        int var1 = 0;

        while(var1 < var2) {
            int var4 = var1 + 1;
            int var3 = var7[var1] & 255;
            if (var4 == var2) {
                var6.append(a[var3 >>> 2]);
                var6.append(a[(var3 & 3) << 4]);
                var6.append("==");
                break;
            }

            int var5 = var4 + 1;
            var4 = var7[var4] & 255;
            if (var5 == var2) {
                var6.append(a[var3 >>> 2]);
                var6.append(a[(var3 & 3) << 4 | (var4 & 240) >>> 4]);
                var6.append(a[(var4 & 15) << 2]);
                var6.append("=");
                break;
            }

            var1 = var5 + 1;
            var5 = var7[var5] & 255;
            var6.append(a[var3 >>> 2]);
            var6.append(a[(var3 & 3) << 4 | (var4 & 240) >>> 4]);
            var6.append(a[(var4 & 15) << 2 | (var5 & 192) >>> 6]);
            var6.append(a[var5 & 63]);
        }

        return var6.toString();
    }

    public static String toBase64(String paramString) {
        byte[] paramByte = paramString.getBytes();
        int len = paramByte.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(len);
        int i = 0;

        label73:
        while(i < len) {    // 主循环
            label71:
            while(true) {   //二级循环
                byte[] buffer = b;
                int j = i + 1;
                byte byt = -1;
                if (i < len) {
                    byt = buffer[paramByte[i]];
                }
                if (j >= len || byt != -1) {
                    if (byt == -1) {
                        break label73;
                    }

                    while(true) {
                        buffer = b;
                        i = j + 1;
                        byte var4 = buffer[paramByte[j]];
                        if (i >= len || var4 != -1) {
                            if (var4 != -1) {
                                byteArrayOutputStream.write(byt << 2 | (var4 & 48) >>> 4);
                                j = i;

                                while(true) {
                                    i = j + 1;
                                    byte var9 = paramByte[j];
                                    if (var9 == 61) {
                                        paramString = new String(byteArrayOutputStream.toByteArray());
                                        return paramString;
                                    }

                                    byt = b[var9];
                                    if (i >= len || byt != -1) {
                                        if (byt != -1) {
                                            byteArrayOutputStream.write((var4 & 15) << 4 | (byt & 60) >>> 2);
                                            j = i;

                                            while(true) {
                                                i = j + 1;
                                                var9 = paramByte[j];
                                                if (var9 == 61) {
                                                    paramString = new String(byteArrayOutputStream.toByteArray());
                                                    return paramString;
                                                }

                                                var9 = b[var9];
                                                if (i >= len || var9 != -1) {
                                                    if (var9 != -1) {
                                                        byteArrayOutputStream.write(var9 | (byt & 3) << 6);
                                                        continue label71;
                                                    }
                                                    break label73;
                                                }

                                                j = i;
                                            }
                                        }
                                        break label73;
                                    }

                                    j = i;
                                }
                            }
                            break label73;
                        }

                        j = i;
                    }
                } else {
                    i = j;
                }
            }
        }

        paramString = new String(byteArrayOutputStream.toByteArray());
        return paramString;
    }
}
