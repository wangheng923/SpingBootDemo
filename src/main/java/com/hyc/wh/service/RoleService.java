package com.hyc.wh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hyc.wh.dao.RoleDao;
import com.hyc.wh.entity.Role;

@Component
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	public Role findRoleByRoleId(String id) {
		return roleDao.findRoleByid(id);
	}

}
