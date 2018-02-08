package com.cms.web.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.core.model.IndexPic;
import com.cms.dto.AjaxObj;
import com.cms.service.IIndexPicService;

@Controller
@RequestMapping("/admin/pic")
public class IndexPicController {
	private IIndexPicService indexPicService;
	
	
	@RequestMapping("/indexPics")
	public String listIndexPic(Model model){
		model.addAttribute("datas", indexPicService.findIndexPic());
		return "pic/listIndexPic";
	}
	
	
	@RequestMapping(value="/addIndexPic",method=RequestMethod.GET)
	public String addIndexPic(Model model){
		IndexPic ip = new IndexPic();
		ip.setStatus(1);
		model.addAttribute("indexPic", ip);
		return 	"pic/addIndexPic";
	}


	public IIndexPicService getIndexPicService() {
		return indexPicService;
	}

	@Resource(name="indexPicService")
	public void setIndexPicService(IIndexPicService indexPicService) {
		this.indexPicService = indexPicService;
	}
}