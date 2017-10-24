package com.cms.web.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.service.IUserService;



@Controller
@RequestMapping("/admin/user")
public class UserController {
	
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}
	@Resource(name="userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/users")
	public String list(Model model){
		model.addAttribute("datas",userService.findUser());
		return "user/list";
	}
}