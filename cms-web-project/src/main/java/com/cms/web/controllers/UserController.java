package com.cms.web.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.core.model.User;
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
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("user", new User());
		return "user/add";
	}
}