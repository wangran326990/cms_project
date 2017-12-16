package com.cms.web.controllers;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.auth.AuthClass;
import com.cms.basic.model.Pager;
import com.cms.core.dao.GroupDao;
import com.cms.core.model.ChannelTree;
import com.cms.core.model.Group;
import com.cms.service.IGroupService;
import com.cms.service.IUserService;

@Controller
@RequestMapping("/admin/group")
@AuthClass(value="admin")
public class GroupController {
	
	
	private IUserService userService;
	

	private IGroupService groupService;
	
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
	@RequestMapping("/groups")
	public String list(Model model){
		
		Pager<Group> groups =groupService.findGroup();
		model.addAttribute("datas", groups);
		return "group/list";
	}
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("group", new Group());
		return "group/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@Validated Group group, BindingResult br){
		if(br.hasErrors()){
			return "group/add";
		}	
		groupService.add(group);
		return "redirect:/admin/group/groups";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model){
		Group group = groupService.load(id);
		model.addAttribute("group", group);
		return "group/update";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(@PathVariable int id, @Validated Group group, BindingResult br){
		if(br.hasErrors()){
			return "group/update";
		}
		//user update can update transit object
		groupService.update(group);
		return "redirect:/admin/group/groups";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		groupService.delete(id);
		return "redirect:/admin/group/groups";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable int id, Model model){
		Group group = groupService.load(id);
		model.addAttribute("group", group);
		model.addAttribute("us", groupService.listGroupUsers(id));
		return "group/show";
	}
	
	@RequestMapping(value="/clearUsers/{id}")
	public String clearUsers(@PathVariable int id){
		groupService.deleteGroupUsers(id);
		return "redirect:/admin/group/groups";
	}
	
	@RequestMapping(value="/listChannels/{gid}", method=RequestMethod.GET)
	public String listChannels(@PathVariable int gid, Model model){
		Group group = groupService.load(gid);
		model.addAttribute("group", group);
		return "group/listChannel";
	}
	
	@RequestMapping(value="/groupTree/{gid}", method=RequestMethod.POST)
	public @ResponseBody List<ChannelTree> AsyncGetTree(@PathVariable int gid){
		return groupService.generateGroupChannelTree(gid);
	}	
	
	@RequestMapping(value="/setChannels/{gid}", method=RequestMethod.GET)
	public String setChannel(@PathVariable int gid, Model model){
		List<Integer> cids =groupService.listGroupChannelIds(gid);
		Group group = groupService.load(gid);
		model.addAttribute("cids", cids);
		model.addAttribute("group", group);
		return "group/setChannel";
		
	}
	@RequestMapping(value="/setChannels/addGroupChannel", method=RequestMethod.POST)
	public @ResponseBody String addGroupChannel(@RequestParam int gid,@RequestParam int cid){
		groupService.addGroupChannel(gid, cid);
		return "success";
	}
	
	@RequestMapping(value="/setChannels/deleteGroupChannel", method=RequestMethod.POST)
	public @ResponseBody String deleteGroupChannel(@RequestParam int gid,@RequestParam int cid){
		groupService.deleteGroupChannel(gid, cid);
		return "success";
	}
	
}
