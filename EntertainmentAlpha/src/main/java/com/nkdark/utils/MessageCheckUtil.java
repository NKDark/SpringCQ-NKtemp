package com.nkdark.utils;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/12 1:27
 * @Description:
 */

public class MessageCheckUtil {

    private static final String IMAGE_REGEX = ".*[CQ:image,file=([^\"]*)].*";

    public static boolean isImage(String msg){
        return msg != "" && msg.matches(IMAGE_REGEX);
    }
}
