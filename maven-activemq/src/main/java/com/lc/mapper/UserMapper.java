package com.lc.mapper;

import com.lc.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 *
 * @Date:2019/9/1
 * @Author:lc
 */
@Mapper
public interface UserMapper {

    void addUser(User user);

}
