package com.nkdark;

import com.nkdark.mapper.UserMapper;
import com.nkdark.pojo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EntertainmentAlphaApplicationTests {

    @Autowired
    UserMapper um;

    @Test
    void contextLoads() {
        List<UserInfo> allUsers = um.getAllUsers();
        for (UserInfo user : allUsers) {
            System.out.println(user);
        }
    }

}
