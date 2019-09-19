package com.lc.mapper;

import com.lc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 *
 * @Date:2019/9/2
 * @Author:lc
 */
@Mapper
@Repository
public interface UserMapper {

    void addUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    List<User> findUserForList();

    User getUserByName(String name);
}
