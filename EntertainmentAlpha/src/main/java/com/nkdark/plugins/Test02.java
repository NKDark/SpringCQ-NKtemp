package com.nkdark.plugins;

import com.nkdark.EntertainmentAlphaApplication;
import com.nkdark.utils.JarLoadUtil;
import net.lz1998.cq.event.message.CQPrivateMessageEvent;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/22 3:56
 * @Description:
 */
@Component
public class Test02 extends CQPlugin {
    @Override
    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        Map<Boolean, List<Class<? extends CQPlugin>>> map = JarLoadUtil.loadJar();
        List<Class<? extends CQPlugin>> list = map.get(true);
        for (Class<? extends CQPlugin> c : list) {

        }
        List<Class<? extends CQPlugin>> pluginList = cq.getPluginList();
        list.addAll(pluginList);
        cq.setPluginList(list);
        return MESSAGE_BLOCK;
    }
}
