package com.hyc.wh.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


import com.hyc.wh.service.RoleService;

@Component
public class ResponseUtil {
	private static ResponseUtil instance;

	public static ResponseUtil getInstance() {
		if (null == instance) {
			instance = new ResponseUtil();
		}
		return instance;
	}

	@Autowired
	private RoleService roleService;

	public void printRole(String id) {

		System.out.println(roleService.findRoleByRoleId(id));

	}

}
