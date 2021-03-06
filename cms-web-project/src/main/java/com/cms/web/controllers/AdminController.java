package com.cms.web.controllers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.auth.AuthClass;
import com.cms.auth.AuthMethod;
import com.cms.basic.util.CmsSessionContext;
import com.cms.core.errors.CmsException;
import com.cms.core.model.User;

@Controller
@AuthClass(value="login")
public class AdminController {
	
	@RequestMapping("/admin")
	@AuthMethod(role="base")
	public String index(){
		return "admin/index";
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public String login(){
//		return "admin/login";
//	}
	
//	@RequestMapping("/drawCheckCode")
//	public void drawCheckCode(HttpServletResponse resp, Integer width, Integer height) throws IOException{
//		resp.setContentType("image/jpg");
//		if(width==null) width =200;
//		if(height==null) height=100;
//		int num = 4;
//		Random random = new Random();
//		String code = "1234567890abcdefghijklmn";
//		StringBuffer cc = new StringBuffer();
//		for(int i=0; i<num; i++){
//			cc.append(code.charAt(random.nextInt(code.length())));
//		}
//		
//		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//		Graphics2D graphic  = img.createGraphics();
//		graphic.setColor(Color.WHITE);
//		graphic.fillRect(0, 0, width, height);
//		graphic.setColor(Color.BLACK);
//		graphic.drawRect(0, 0, width-1, height-1);
//		Font font = new Font("TimesRoman",Font.BOLD+Font.ITALIC,(int)(height*0.8));
//		graphic.setFont(font);
//		for(int i=0;i<num;i++){
//			graphic.drawString(String.valueOf(cc.charAt(i)), i*(width/num)+6,(int)(height*0.8));
//		}
//		OutputStream os = resp.getOutputStream(); 
//		ImageIO.write(img, "jpg", os);
//		
//	}
	@RequestMapping("/admin/logout")
	@AuthMethod(role="base")
	public String logout(HttpSession session){
			CmsSessionContext.removeSession(session);
			session.invalidate();
			return "redirect:/login";
	}
	
	
	
}
