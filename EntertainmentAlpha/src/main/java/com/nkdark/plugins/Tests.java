package com.nkdark.plugins;

import com.nkdark.mapper.UserMapper;
import com.nkdark.pojo.UserInfo;
import net.lz1998.cq.event.message.CQPrivateMessageEvent;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/11 11:55
 * @Description:
 */
@Component
public class Tests extends CQPlugin {

    @Autowired
    UserMapper um;



    @Override
    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        String msg = event.getMessage();
        long userId = event.getSender().getUserId();
        if ("".equals(msg)){
            UserInfo user = um.getUserById(userId);
            cq.sendPrivateMsg(349195749,"您的余额为："+user.getBalance(),false);
            return MESSAGE_BLOCK;
        }
        return super.onPrivateMessage(cq, event);
    }
}
