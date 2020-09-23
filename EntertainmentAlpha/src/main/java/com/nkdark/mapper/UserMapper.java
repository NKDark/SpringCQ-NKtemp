package com.nkdark.mapper;

import com.nkdark.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/11 3:32
 * @Description:
 */

@Repository
@Mapper
public interface UserMapper {
    /**
     * 全查询
     * @return all
     */
    List<UserInfo> getAllUsers();

    /**
     * 按QQ号查询用户
     * @param userid QQ号
     * @return 人
     */
    UserInfo getUserById(Long userid);
}
