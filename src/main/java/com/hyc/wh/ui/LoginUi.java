package com.hyc.wh.ui;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hyc.wh.dto.UserDto;
import com.hyc.wh.entity.ResponseDto;
import com.hyc.wh.entity.Role;
import com.hyc.wh.entity.User;
import com.hyc.wh.service.UserDetailService;
import com.hyc.wh.util.ResponseUtil;

@Controller
public class LoginUi {

	@Autowired
	private UserDetailService userService;
	
	@Autowired
	private ResponseUtil util;

	@RequestMapping(value = "/")
	public String home() {
		// return new ModelAndView("home");
		// }
		//
		// @RequestMapping(value = "/loginAction", method = RequestMethod.GET)
		// public ModelAndView login() {
		return "redirect:login";
	}

	// @RequestMapping(value = "/successAction", method = RequestMethod.GET)
	// public String dologin() {
	// System.out.println("success");
	// return "success";
	// }

	@RequestMapping(value = "/successAction", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto login(Principal principal, HttpServletRequest request) {
		Authentication authentication = (Authentication) principal;
		User user = (User) authentication.getPrincipal();
		util.printRole(user.getRoles().get(0).getId());
		System.out.println("Authentication success,name : " + user.getName());
		return new ResponseDto(0, "", "登录成功");
	}

	@RequestMapping(value = "/user/modify", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto userModify(@RequestBody UserDto user) {
		System.out.println("username" + user.getUsername());
		System.out.println("password" + user.getPassword());
		userService.modifyUserByUsername(user.getUsername(), user.getPassword());
		return new ResponseDto(0, "", "修改成功");
	}
}
