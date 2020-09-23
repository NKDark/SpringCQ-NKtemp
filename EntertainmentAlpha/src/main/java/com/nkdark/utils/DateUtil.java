package com.nkdark.utils;

import net.lz1998.cq.boot.CQProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/8/18 1:00
 * @Description: 从苏宁源获取当前北京时间
 */

public class DateUtil {

    public static int randomPersonality(long uid) {
        String src = getDate() + uid;
        return new Random(Long.parseLong(src)).nextInt(100) + 1;
    }

    public static String getDate() {
        final String url = "http://quan.suning.com/getSysTime.do";
        RestTemplate restTemplate = new RestTemplate();
        String Date = restTemplate.getForObject(url, String.class);
        if (Date != null) {
            // 简单粗暴 按引号切开 获取日期
            String[] split = Date.split("\"");
            return split[7].substring(0,8);
        } else {
            return "19700101";
        }
    }

}
