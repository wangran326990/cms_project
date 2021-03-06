package com.cms.web.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.auth.AuthClass;
import com.cms.core.model.Role;
import com.cms.service.IGroupService;
import com.cms.service.IRoleService;
import com.cms.service.IUserService;

@RequestMapping("/admin/role")
@Controller
@AuthClass(value="admin")
public class RoleController {
	
	
		IRoleService roleService;
		IUserService userService;
		
		public IRoleService getRoleService() {
			return roleService;
		}
		
		@Resource(name="roleService")
		public void setRoleService(IRoleService roleService) {
			this.roleService = roleService;
		}
		
		public IUserService getUserService() {
			return userService;
		}
		
		@Resource(name="userService")
		public void setUserService(IUserService userService) {
			this.userService = userService;
		}
		
		
		@RequestMapping("/roles")
		public String list(Model model){
			model.addAttribute("roles", roleService.listRole());
			return "role/list";
		}
		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable int id){
			roleService.delete(id);
			return "redirect:/admin/role/roles";
		}
		
		@RequestMapping(value="/add", method=RequestMethod.GET)
		public String add(Model model){
			model.addAttribute("role", new Role());
			return "role/add";
		}
		
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String add(@Validated Role role, BindingResult br, Model model){
			if(br.hasErrors()){
				
				return "role/add";
			}
			roleService.add(role);
			return "redirect:/admin/role/roles";
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public String show(@PathVariable int id, Model model){
			model.addAttribute("role",roleService.load(id));
			model.addAttribute("us", roleService.listRoleUsers(id));
			return "role/show";
		}
		

		@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
		public String update(@PathVariable int id, Model model){
			model.addAttribute("role",roleService.load(id));			
			return "role/update";
		}
		
		@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
		public String update(@Validated Role role, BindingResult br, Model model){
			if(br.hasErrors()){
				return "role/update";
			}
			roleService.update(role);
			return "redirect:/admin/role/roles";
		}
}
