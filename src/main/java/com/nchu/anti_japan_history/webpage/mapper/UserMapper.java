package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    //注册
    int save(User user);
    //用户名校验
    List<User> selectUserName(String userName);
    //用户信息查询
    User selectById(Long userId);
    //登录
    @Select("SELECT * FROM user WHERE userName = #{userName} AND userPassword = #{userPassword}")
    User login(@Param("userName") String userName,@Param("userPassword") String userPassword);

    //用户信息修改
    int update(User user);
}
