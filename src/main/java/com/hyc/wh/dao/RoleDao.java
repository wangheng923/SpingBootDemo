package com.hyc.wh.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.hyc.wh.entity.Role;

@Mapper
public interface RoleDao {

	@ResultMap(value="common.role")
	@Select(value="select a.*,c.code from role a left join role_authority b on a.id=b.roleId left join authority c on b.authorityId=c.id where a.id=#{id}")
	public Role findRoleByid(String id);
}
