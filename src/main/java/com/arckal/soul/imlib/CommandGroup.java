package com.arckal.soul.imlib;

import com.arckal.soul.utils.DataUtils;

/**
 * @Author: arckal
 * @Date: 2019/5/30 21:09
 * @Version 1.0
 */
public class CommandGroup  {

    /**
     * 0a3e0a0633393039373012123135353932323339313038383737313038322a2012063339303937301a08323938383532303020ab91f3c7b0
     * 2d32050a033132330a221803421e120d313535393232333931323633301a0d31353539323233393132363139
     * 解析数据包为表单
     * @param bytes
     */
    public static Command parseFrom(byte[] bytes){

        try{
            if (bytes.length < 64)
                return null;
            if(bytes.length==97){
                // 输入中指令包
                return null;
            }
            if(bytes[0]==(byte)0x0a){   //包头
                byte[] msgBytes = new byte[bytes.length-2];
                System.arraycopy(bytes,2,msgBytes,0,bytes.length-2);
                return MsgCommand.parseFrom(msgBytes);

            }
        }catch (Exception  e){
//            System.out.println("解析消息异常" + e.getMessage());
//            DataUtils.printBytes(bytes);
        }

        return null;
    }


//    public static void main(String[] args){
//        byte[] bytes = DataUtils.hexStrToBytes("0a3f0a0633393039373012123135353932323339313731353731343538372a2112063339303937301a08323938383532303020a9c2f3c7b02d32060a04313233350a221803421e120d313535393232333931383932301a0d31353539323233393138383839");
//        Command cmd = parseFrom(bytes);
//        System.out.println(cmd);
//    }
}
