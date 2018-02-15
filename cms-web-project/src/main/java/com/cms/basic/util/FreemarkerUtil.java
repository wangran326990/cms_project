package com.cms.basic.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil {
	private static final FreemarkerUtil FREE_MARKER= new FreemarkerUtil();
	private static final Configuration cfg = new Configuration();	
	
	private FreemarkerUtil(){
		
	}
	
	public static FreemarkerUtil getInstance(String pname){
		cfg.setClassForTemplateLoading(FreemarkerUtil.class, pname);
		return FREE_MARKER;
	}
	
	private Template getTemplate(String fname){
		try {
			return cfg.getTemplate(fname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void sprint(Map<String, Object> root, String fname){
		try {
			getTemplate(fname).process(root, new PrintWriter(System.out));
		} catch (TemplateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fpring(Map<String, Object> root, String fname, String outpath){
		try {
			getTemplate(fname).process(root, new FileWriter(outpath));
		} catch (TemplateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
