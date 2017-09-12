package com.hyc.wh.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hyc.wh.entity.User;

@Mapper
public interface UserDao {

	@ResultMap(value = "common.user")
	@Select(value = "select a.*,b.id as roleid,b.name from user a,role b,user_role c where a.name = #{name} and a.id=c.userId and c.roleId=b.id")
	public User loadUserByUsername(@Param("name") String name);

	@Update(value = "update user set password = #{password} where name = #{username}")
	public int modifyUserByUsername(@Param("username") String username, @Param("password") String password);

}
