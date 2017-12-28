package com.cms.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cms.auth.AuthClass;
import com.cms.auth.AuthMethod;
import com.cms.core.model.ChannelTree;

@Controller
@AuthClass("login")
@RequestMapping("/admin/topic")
public class TopicController {
	private void initList(String con,Integer cid,Model model,HttpSession session,Integer status) {

	}

	@RequestMapping("/audits")
	@AuthMethod(role="ROLE_PUBLISHER,ROLE_AUDIT")
	public String auditList(@RequestParam(required=false) String con,@RequestParam(required=false) Integer cid,Model model,HttpSession session) {
		
		return "topic/list";
	}
	
	@RequestMapping("/unaudits")
	@AuthMethod(role="ROLE_PUBLISHER,ROLE_AUDIT")
	public String unauditList(@RequestParam(required=false) String con,@RequestParam(required=false) Integer cid,Model model,HttpSession session) {
		initList(con, cid, model, session,0);
		return "topic/list";
	}
	
	@RequestMapping("/changeStatus/{id}")
	@AuthMethod(role="ROLE_AUDIT")
	public String changeStatus(@PathVariable int id,Integer status) {
		return null;
	}
	
	@RequestMapping("/delete/{id}")
	@AuthMethod(role="ROLE_PUBLISHER")
	public String delete(@PathVariable int id,Integer status) {
		return null;
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	@AuthMethod(role="ROLE_PUBLISHER")
	public String add(Model model) {
		return null;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(BindingResult br,String[]aks,Integer[] aids,HttpSession session) {
		return null;
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	@AuthMethod(role="ROLE_PUBLISHER")
	public String update(@PathVariable int id,Model model) {
		return null;
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id,BindingResult br,String[]aks,Integer[] aids,HttpSession session) {
		return null;
		
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable int id,Model model) {
		return null;
	}
	
	@RequestMapping(value="/searchKeyword")
	@AuthMethod(role="ROLE_PUBLISHER")
	public @ResponseBody List<String> searchKeyword(String term) {
		return null;
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)//返回的是json类型的值，而uploadify只能接受字符串
	@AuthMethod(role="ROLE_PUBLISHER")
	public void upload(MultipartFile attach,HttpServletResponse resp) throws IOException {
		
	}
	
	@RequestMapping("/treeAll")
	@AuthMethod(role="ROLE_PUBLISHER")
	public @ResponseBody List<ChannelTree> tree(HttpSession session) {
		return null;
	}
}