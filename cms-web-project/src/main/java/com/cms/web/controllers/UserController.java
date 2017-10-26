package com.cms.web.controllers;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.core.model.User;
import com.cms.dto.UserDto;
import com.cms.service.IGroupService;
import com.cms.service.IRoleService;
import com.cms.service.IUserService;



@Controller
@RequestMapping("/admin/user")
public class UserController {
	
	private IUserService userService;
	private IGroupService groupService;
	private IRoleService roleService;
	public IUserService getUserService() {
		return userService;
	}
	@Resource(name="userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public IGroupService getGroupService() {
		return groupService;
	}
	
	@Resource(name="groupService")
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}
	
	public IRoleService getRoleService() {
		return roleService;
	}
	
	@Resource(name="roleService")
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	

	@RequestMapping("/users")
	public String list(Model model){
		model.addAttribute("datas",userService.findUser());
		return "user/list";
	}
	
	private void initAddUser(Model model){
		model.addAttribute("roles", roleService.listRole());
		model.addAttribute("groups", groupService.listGroup());
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("userDto", new UserDto());
		this.initAddUser(model);
		return "user/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@Valid UserDto userDto, BindingResult br, Model model){
		if(br.hasErrors()){
			this.initAddUser(model);
			return "user/add";
		}
		userService.add(userDto.getUser(), userDto.getRoleIds(), userDto.getGroupIds());
		return "redirect:/admin/user/users";
	}
	
	
}