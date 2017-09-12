package com.hyc.wh;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.hyc.wh.entity.Role;
import com.hyc.wh.entity.User;
import com.hyc.wh.service.RoleService;
import com.hyc.wh.service.UserDetailService;

@Component
public class MyAuthentication implements AuthenticationProvider {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private UserDetailService userService;

	@Autowired
	private RoleService roleService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		logger.info("[MyAuthentication] start");
		String name = authentication.getName();
		User userDetails = (User) userService.loadUserByUsername(name);
		if (userDetails == null) {
			return null;
		}
		if (!userDetails.getPassword().equals(authentication.getCredentials())) {
			return null;
		}
		List<Role> roles = userDetails.getRoles();
		Set<String> authorities = Sets.newHashSet();
		for (Role role : roles) {
			Role dbRole = roleService.findRoleByRoleId(role.getId());
			if (dbRole != null) {
				authorities.addAll(dbRole.getAuthorities());
			}
		}
		userDetails.setPriviliges(Lists.newArrayList(authorities));
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userDetails,
				authentication.getCredentials(), userDetails.getAuthorities());
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
