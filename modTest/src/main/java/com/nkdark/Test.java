package com.nkdark;

import net.lz1998.cq.event.message.CQGroupMessageEvent;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.stereotype.Component;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/20 3:45
 * @Description:
 */
// Class<? extends CQPlugin>
@Component
public class Test extends CQPlugin {
    @Override
    public int onGroupMessage(CoolQ cq, CQGroupMessageEvent event) {
        cq.sendGroupMsg(event.getGroupId(),"Test",false);
        return MESSAGE_BLOCK;
    }
}
