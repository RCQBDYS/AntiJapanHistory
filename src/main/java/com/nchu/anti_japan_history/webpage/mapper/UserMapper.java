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
    //查询所有用户名信息
    List<User> userMessageListAll();
    //用户信息模糊查询
    List<User> searchByKeyWord(@Param(value = "keyWord") String keyWord);
    //用户信息删除
    int deleteById(Long userId);

    //更新积分
    void coreUpdate(User user);

    //根据用户名查询用户信息
    User userMessage(String userName);

    //更新权限
    void powerUpdate(User user);

    //更新用户贡献次数
    void numberUpdate(User user);
}
