package com.cms.web.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.cms.auth.AuthMethod;
import com.cms.basic.util.Captcha;
import com.cms.basic.util.CmsSessionContext;
import com.cms.core.model.Role;
import com.cms.core.model.RoleType;
import com.cms.core.model.User;
import com.cms.dto.AjaxObj;
import com.cms.service.IUserService;
import com.google.gson.Gson;

@Controller("loginController")
public class LoginController {
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}
	
	@Resource(name="userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,String checkcode,Model model,HttpSession session) {
		String cc = (String)session.getAttribute("cc");
		if(!cc.equals(checkcode)) {
			model.addAttribute("error","验证码出错，请重新输入");
			return "admin/login";
		}
		User loginUser = userService.login(username, password);
		session.setAttribute("loginUser", loginUser);
		boolean isAdmin = userService.isAdmin(loginUser.getId());
		List<Role> rs = userService.listUserRoles(loginUser.getId());
		//boolean isAdmin = isRole(rs,RoleType.ROLE_ADMIN);
		session.setAttribute("isAdmin", isAdmin);
		if(!isAdmin) {
			session.setAttribute("allActions", getAllActions(rs, session));
			session.setAttribute("isAudit",  isRole(rs,RoleType.ROLE_AUDIT));
			session.setAttribute("isPublish",isRole(rs,RoleType.ROLE_PUBLISHER));
		}
		session.removeAttribute("cc");
		CmsSessionContext.addSessoin(session);
		return "redirect:/admin";
	}
	
	@SuppressWarnings("unchecked")
	private Set<String> getAllActions(List<Role> rs,HttpSession session) {
		Set<String> actions = new HashSet<String>();
		Map<String,Set<String>> allAuths = (Map<String,Set<String>>)session.getServletContext().getAttribute("allAuths");
//		for(Map.Entry<String,Set<String>> entry:allAuths.entrySet()){
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//		}
		actions.addAll(allAuths.get("base"));
		for(Role r:rs) {
			if(r.getRoleSn()==RoleType.ROLE_ADMIN) continue;
//			System.out.println(r.getRoleSn().name());
//			System.out.println(allAuths.get(r.getRoleSn().name()));
			actions.addAll(allAuths.get(r.getRoleSn().name()));
		}
		return actions;
	}
	
	
	private boolean isRole(List<Role> rs,RoleType rt) {
		for(Role r:rs) {
			if(r.getRoleSn()==rt) return true;
		}
		return false;
	}
	
	
	@RequestMapping("/drawCheckCode")
	public void drawCheckCode(HttpServletResponse resp,HttpSession session) throws IOException {
		resp.setContentType("image/jpg");
		int width = 200;
		int height = 30;
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		session.setAttribute("cc", checkcode);
		OutputStream os = resp.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)//返回的是json类型的值，而uploadify只能接受字符串
	
	public void upload(MultipartFile attach,HttpServletResponse resp) throws IOException {
		System.out.println(attach.getOriginalFilename());
		Gson gson = new Gson();
		resp.setContentType("text/plain");
		AjaxObj ao =  new AjaxObj();
		String resultJson = gson.toJson(ao);
		resp.getWriter().write(resultJson);
	}
}