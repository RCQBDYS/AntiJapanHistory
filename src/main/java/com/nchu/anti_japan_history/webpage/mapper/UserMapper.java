package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    int save(User user);

    @Select("SELECT * FROM user WHERE userName = #{userName} AND userPassword = #{userPassword}")
    User login(@Param("userName") String userName,@Param("userPassword") String userPassword);
}
