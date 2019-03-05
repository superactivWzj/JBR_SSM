package com.arch.security.dao;

import com.arch.security.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import javax.persistence.EntityResult;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Component
@Mapper
public interface UserDao extends tk.mybatis.mapper.common.Mapper<User> {

    @Results(value = {
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column = "id",property = "roles",many = @Many(select = "com.arch.security.dao.RoleDao.selectAllRolesByUserId"))
    })

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);


}




