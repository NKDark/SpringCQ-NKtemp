package com.nkdark.plugins;

import com.nkdark.pojo.SettingInfo;
import lombok.SneakyThrows;
import net.lz1998.cq.event.message.CQPrivateMessageEvent;
import net.lz1998.cq.robot.CQPlugin;
import net.lz1998.cq.robot.CoolQ;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/12 4:54
 * @Description:
 */
@Component
public class AdminController extends CQPlugin {
    @SneakyThrows
    @Override
    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        String msg = event.getMessage();
        if (msg.startsWith("修改概率")) {
            String Threshold = msg.replace("修改概率", "");
            File file = new File("config.properties");
            InputStream is = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(is);
            prop.setProperty("Threshold", Threshold);
            OutputStream os = new FileOutputStream(file);
            prop.store(os, "");
            os.close();
            is.close();
            SettingInfo.setThreshold(Double.parseDouble(Threshold));
            cq.sendPrivateMsg(SettingInfo.getAdminId(), "成功修改概率为：" + Double.parseDouble(Threshold), false);
            return MESSAGE_BLOCK;
        }

        return MESSAGE_IGNORE;
    }
}
