package com.hyc.wh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hyc.wh.dao.UserDao;

@Component
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return userDao.loadUserByUsername(username);
	}

	public int modifyUserByUsername(String username, String password) throws UsernameNotFoundException {

		return userDao.modifyUserByUsername(username, password);
	}

}
