package com.nkdark.plugin;

import net.lz1998.cq.CQGlobal;
import net.lz1998.cq.event.message.CQPrivateMessageEvent;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/22 1:46
 * @Description:
 */
@Component
public class TestPlugin extends CQPlugin {
    @Override
    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        return super.onPrivateMessage(cq, event);
    }

    public static void main(String[] args) {

    }
}
