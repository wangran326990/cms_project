package com.cms.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.auth.AuthClass;
import com.cms.basic.util.EnumUtil;
import com.cms.basic.util.JsonUtil;
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelTree;
import com.cms.core.model.ChannelType;
import com.cms.dto.AjaxObj;
import com.cms.dto.TreeDto;
import com.cms.service.IChannelService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/admin/channel")
@AuthClass(value="admin")
public class ChannelController {
	
	private IChannelService channelService;
	
	@RequestMapping("/channels")
	public String list(Model model){
		List<ChannelTree> tree = channelService.generateTree();
		Gson gson = new Gson();
		String jsonDatas = gson.toJson(tree);
		model.addAttribute("treeDatas", jsonDatas);
		return "channel/list";
	}
	
	@RequestMapping("/treeAll")
	public @ResponseBody List<ChannelTree> tree(){
		return channelService.generateTree();
	}
	
	@RequestMapping(value="/treeAs",method=RequestMethod.POST)
	public @ResponseBody List<TreeDto> tree(@Param Integer pid){
		List<TreeDto> tds = new ArrayList<>();
		if(pid==null || pid<=0){
			tds.add(new TreeDto(0, "website system management channel", 1));
			return tds;
		}
		List<ChannelTree> cts = channelService.generateTreeByParent(pid);
		for(ChannelTree ct : cts){
			tds.add(new TreeDto(ct.getId(), ct.getName(), 1));
		}
		return tds;
	}
	
	private void setParentChannelModel(Model model, Integer pid){
		Channel pc= null;
		if(pid==null || pid<=0){
			pc=new Channel();
			pc.setName(Channel.ROOT_NAME);
			pc.setId(Channel.ROOT_ID);
		}else{
			pc = channelService.load(pid);
		}
		model.addAttribute("pc", pc);
		model.addAttribute("pid", pid);
	}
	@RequestMapping("/channels/{pid}")
	public String listChild(@PathVariable Integer pid, Model model, @Param Integer refresh){
		if(refresh==null) {
			model.addAttribute("refresh",0);
		} else {
			model.addAttribute("refresh",1);
		}
		this.setParentChannelModel(model, pid);
		model.addAttribute("channels",channelService.listByParentId(pid));
		return "channel/list_child";
	}
	
	@RequestMapping(value="/add/{pid}",method =RequestMethod.GET)
	public String addChild(@PathVariable Integer pid, Model model){
		initAdd(model, pid);
		model.addAttribute("channel", new Channel());
		return "channel/add";
	}
	
	@RequestMapping(value="/add/{pid}",method =RequestMethod.POST)
	public String addChild(@PathVariable Integer pid, Channel channel, BindingResult br, Model model){
			if(br.hasErrors()){
				initAdd(model, pid);
				return "channel/add";
			}
			channelService.add(channel, pid);
		return "redirect:/admin/channel/channels/"+pid+"?refresh=1";
	}
	
	
	@RequestMapping(value="/delete/{pid}/{id}")
	public String delete(@PathVariable Integer pid,  @PathVariable Integer id){
		channelService.delete(id);
		return "redirect:/admin/channel/channels/"+pid+"?refresh=1"; 
	}
	
	
	@RequestMapping(value="/update/{pid}/{id}",method =RequestMethod.GET)
	public String update(@PathVariable Integer pid, @PathVariable Integer id, Model model){
		this.setParentChannelModel(model, pid);
		model.addAttribute("types",EnumUtil.enumPropToNameMap(ChannelType.class, "name"));
		model.addAttribute("channel", channelService.load(id));
		
		return "channel/update";
	}
	
	@RequestMapping(value="/update/{pid}/{id}",method =RequestMethod.POST)
	public String update(@PathVariable Integer pid, @PathVariable Integer id, Channel channel, BindingResult br, Model model){
			if(br.hasErrors()){
				this.setParentChannelModel(model, pid);
				model.addAttribute("channel", channelService.load(id));
				model.addAttribute("types",EnumUtil.enumPropToNameMap(ChannelType.class, "name"));
				return "channel/update";
			}
			Channel tc = channelService.load(id);
			tc.setCustomLink(channel.getCustomLink());
			tc.setCustomLinkUrl(channel.getCustomLinkUrl());
			tc.setIsIndex(channel.getIsIndex());
			tc.setIsRecmd(channel.getIsRecmd());
			tc.setIsTopNav(channel.getIsTopNav());
			tc.setName(channel.getName());
			tc.setStatus(channel.getStatus());
			tc.setType(channel.getType());
			channelService.update(tc);
			return "redirect:/admin/channel/channels/"+pid+"?refresh=1";
	}
	
	@RequestMapping(value="/channels/updateSort", method=RequestMethod.POST)
	public @ResponseBody AjaxObj updateSort(@Param Integer[] ids){
		try {
			channelService.updateSort(ids);
		} catch (Exception e) {
			// TODO: handle exception
			return new AjaxObj(0,e.getMessage());
		}
		
		return new AjaxObj(1);
	}
	
	private void initAdd(Model model, Integer pid){
		Channel pc= null;
		if(pid==null || pid <=0){
			pc=new Channel();
			pc.setName(Channel.ROOT_NAME);
			pc.setId(Channel.ROOT_ID);
		}else{
			pc = channelService.load(pid);
		}
		model.addAttribute("pid", pid);
		model.addAttribute("pc", pc);
		model.addAttribute("types", EnumUtil.enumPropToNameMap(ChannelType.class, "name"));
	}
	
	
	public IChannelService getChannelService() {
		return channelService;
	}

	
	@Resource(name="channelService")
	public void setChannelService(IChannelService channelService) {
		this.channelService = channelService;
	}
	
	
}
