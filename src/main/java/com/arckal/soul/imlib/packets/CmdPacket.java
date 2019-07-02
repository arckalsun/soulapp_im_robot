package com.arckal.soul.imlib.packets;

import com.arckal.soul.imlib.packets.chat.CommandPacket;
import com.arckal.soul.utils.DataUtils;

/**
 * @Author: arckal
 * @Date: 2019/5/29 14:02
 * @Version 1.0
 */
public class CmdPacket extends CommandPacket {

    static byte[] byteHeader = new byte[]{(byte)0x12}; // 包头
    private String fromId = null;   // 源用户
    private String toId = null;     // 目标用户
    private Boolean typing = false;  // true 开始打字、 false 结束打字
    private String nonce = null;

    public CmdPacket(String fromId, String toId, Boolean typing){
        this.fromId = fromId;
        this.toId = toId;
        this.typing = typing;
        this.nonce = String.valueOf(System.currentTimeMillis()) + "00000";

    }



    @Override
    public byte[] b() {
        byte[] data = null;
        byte byteTyping = this.typing==true ? (byte)0x12 : (byte)0x13;
        try {
            data = (byte[]) DataUtils.concatArrays(byteHeader,
                    new byte[]{(byte)this.nonce.length()},
                    this.nonce.getBytes(),
                    new byte[]{(byte)0x2a},
                    new byte[]{(byte)0x14},
                    new byte[]{(byte)0x08},
                    new byte[]{byteTyping},
                    new byte[]{(byte)0x12},
                    new byte[]{(byte)this.fromId.length()},
                    this.fromId.getBytes(),
                    new byte[]{(byte)0x1a},
                    new byte[]{(byte)(this.toId.length())},
                    this.toId.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


}
