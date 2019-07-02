package com.arckal.soul.protos;

import com.arckal.soul.utils.DataUtils;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @Author: arckal
 * @Date: 2019/6/25 9:51
 * @Version 1.0
 */
public class CommandGroupTest {

    private static byte[] encode(CommandGroupOuterClass.CommandGroup req){
        return req.toByteArray();
    }

    private static CommandGroupOuterClass.CommandGroup decode(byte[] body) throws InvalidProtocolBufferException{
        return CommandGroupOuterClass.CommandGroup.parseFrom(body);
    }


    public static void main(String[] args) throws InvalidProtocolBufferException {
        byte[] bytes = DataUtils.hexStrToBytes("0a3f0a0633393039373012123135353932323339313731353731343538372a2112063339303937301a08323938383532303020a9c2f3c7b02d32060a04313233350a221803421e120d313535393232333931383932301a0d31353539323233393138383839");
        CommandGroupOuterClass.CommandGroup cmd = decode(bytes);
        System.out.println(cmd.getCommands(0));
        System.out.println(cmd.getCommands(1));
        System.out.println(cmd.getCommandsCount());
    }
}
