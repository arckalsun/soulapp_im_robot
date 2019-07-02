package com.arckal.soul.imlib.business;

import com.arckal.soul.SoulConfig;
import com.arckal.soul.imlib.msg.ImMessage;
import com.arckal.soul.imlib.msg.chat.PromptMsg;
import com.arckal.soul.imlib.msg.chat.TextMsg;
import com.arckal.soul.imlib.msg.chat.VoiceChatMsg;
import com.arckal.soul.utils.SpringContextUtil;
import org.springframework.util.StringUtils;

/**
 * @Author: arckal
 * @Date: 2019/7/1 20:43
 * @Version 1.0
 */
public class LastMsgUtils {
    public static String a(ImMessage imMessage) {
        String str = "";
        String userId = SpringContextUtil.getBean(SoulConfig.class).getUserId();
        if (imMessage == null) {
            return "";
        }
        switch (imMessage.getChatMessage().getMsgType()) {
            case 1:
            case 21:
            case 28:
                str = ((TextMsg) imMessage.getChatMessage().getMsgContent()).text;
                break;
            case 2:
            case 3:
                str = "pic_im_only";
                break;
            case 4:
                str = "video_im_only";
                break;
            case 5:
                str = "voice_im_only";
                break;
            case 6:
            case 31:
            case 32:
                str = "share_im_only";
                break;
            case 7:
            case 8:
                str = "expression_im_only";
                break;
            case 9:
                if (!StringUtils.isEmpty(imMessage.getFrom()) && imMessage.getFrom().equals(userId)) {
                    str = "you_resend_a_msg_im_only";
                    break;
                }
                str = "other_resend_a_msg_im_only";
                break;
//            break;
            case 10:
                str = "user_introduce_im_only";
                break;
            case 12:
                str = "caiquan_im_only";
                break;
            case 13:
                str = "shaizi_im_only";
                break;
            case 15:
                str = "can_you_accept_be_soulmate_im_only";
                break;
            case 16:
                str = "focus_tip_im_only";
                break;
            case 17:
                str = "long_click_tip_im_only";
                break;
            case 18:
                str = "share_chat_bg_im_only";
                break;
            case 19:
                str = ((PromptMsg) imMessage.getChatMessage().getMsgContent()).text;
                break;
            case 22:
                break;
            case 27:
                if (!StringUtils.isEmpty(((TextMsg) imMessage.getChatMessage().getMsgContent()).text)) {
                    str = "friendly_card_im_only";
                    break;
                }
                return "";
            case 30:
                str = ((VoiceChatMsg) imMessage.getChatMessage().getMsgContent()).content;
                break;
            case 33:
                str = "position_im_only";
                break;
            case 34:
                str = "music_im_only";
                break;
            default:
                return "";
        }
        return str;
    }
}