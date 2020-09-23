package com.nkdark.utils;

import net.lz1998.cq.robot.CQPlugin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/22 3:27
 * @Description:
 */

public class Test2 {
    @Resource
    private ApplicationContext ctx;

    private void test(){

    }
    public static void main(String[] args) {
        Map<Boolean, List<Class<? extends CQPlugin>>> map = JarLoadUtil.loadJar();
        if (map != null) {
            List<Class<? extends CQPlugin>> list = map.get(true);
            for (Class<? extends CQPlugin> c : list) {
                System.out.println(c.getName());
            }
        }

    }
}
