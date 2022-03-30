package com.zyp.springboot05mybatis.mapper;

import com.zyp.springboot05mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解是一个mybatis的mapper类Dao
@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();
    User queryUserById();
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);

}

