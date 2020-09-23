package com.nkdark.controller;

import net.lz1998.cq.CQGlobal;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/22 1:39
 * @Description:
 */

@RestController
public class TestController2 {

    @GetMapping("/bot_info")
    public String info(){
        System.out.println("尝试获取botinfo");
        int size = CQGlobal.robots.size();
        String count = null;
        if (size>0) {
            count = "当前有"+size+"个机器人连接";
        }else {
            count = "当前没有机器人连接";
        }
        Set<Long> longs = CQGlobal.robots.keySet();
        for (Long qq : longs) {
            CoolQ cq = CQGlobal.robots.get(qq);
            System.out.println(cq.getSelfId());
            System.out.println(cq.getVersionInfo().getStatus());
            System.out.println(cq.getVersionInfo().getData().getCoolqDirectory());
            for (Class<? extends CQPlugin> c : cq.getPluginList()) {
                System.out.println(c.getName());
            }
        }
        return "Hello Bot<br/>"+count;
    }
}
