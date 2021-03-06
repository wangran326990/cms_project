package com.cms.web.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.basic.util.BaseInfoUtil;
import com.cms.core.model.BaseInfo;

@Controller
@RequestMapping("/admin/system")
public class BaseInfoController {
	@RequestMapping("/baseinfo")
	public String showBaseInfo(HttpSession session, Model model){
		
		model.addAttribute("baseInfo", session.getServletContext().getAttribute("baseInfo"));
		return "system/showBaseInfo";
	}
	
	@RequestMapping(value="/baseinfo/update", method=RequestMethod.GET)
	public String updateBaseInfo(HttpSession session, Model model){
		
		model.addAttribute("baseInfo", session.getServletContext().getAttribute("baseInfo"));
		return "system/updateBaseInfo";
	}
	
	@RequestMapping(value="/baseinfo/update", method=RequestMethod.POST)
	public String updateBaseInfo(@Validated BaseInfo bi, BindingResult br,HttpSession session, Model model){
		if(br.hasErrors()){
			return "system/showBaseInfo";
		}
		BaseInfo baseInfo = BaseInfoUtil.getInstance().write(bi);
		session.getServletContext().setAttribute("baseInfo", baseInfo);
		return "redirect:/admin/system/baseinfo";
	}
}
