package com.cms.web.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.auth.AuthClass;
import com.cms.auth.AuthMethod;
import com.cms.dto.AjaxObj;
import com.cms.service.IAttachmentService;
import com.cms.service.IGroupService;

@RestController
@AuthClass("login")
@RequestMapping("/admin/attachment")
public class AttachmentController {
	public IGroupService getGroupService() {
		return groupService;
	}


	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}


	public IAttachmentService getAttachmentService() {
		return attachmentService;
	}

	@Resource(name="attachmentService")
	public void setAttachmentService(IAttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}


	private IGroupService groupService;
	private IAttachmentService attachmentService;
	
	
	@RequestMapping(value="/updateAttachInfo",method=RequestMethod.POST)//返回的是json类型的值，而uploadify只能接受字符串
	//@AuthMethod(role="ROLE_PUBLISHER")
	public AjaxObj updateAttachInfo(@RequestParam int id){
		//System.out.println("in update controller");
		attachmentService.updateAttachInfo(id);
		return new AjaxObj(1,"update attach successful!");
	}
	
	@RequestMapping(value="/updateIndexPic",method=RequestMethod.POST)
	public AjaxObj updateIndexPic(@RequestParam int id){
		attachmentService.updateIndexPic(id);
		return new AjaxObj(1,"update index pic successful!");
	}
	
	@RequestMapping(value="/deleteAttachment",method=RequestMethod.POST)
	public AjaxObj deleteAttachment(@RequestParam int id){
		attachmentService.delete(id);
		return new AjaxObj(1,"delete successful!");
	}
}
