package com.cms.basic.util;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cms.auth.AuthClass;
import com.cms.auth.AuthMethod;

public class AuthUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Set<String>> initAuth(String pname){
		Map<String, Set<String>> auths = new HashMap<>();
		try {
			
			String[] ps = getClassByPackage(pname);
			for (String p : ps) {
				String pc = pname + "." + p.substring(0, p.lastIndexOf(".class"));

				
				Class clz = Class.forName(pc);
				if(!clz.isAnnotationPresent(AuthClass.class)) continue;
				Method[] methods = clz.getDeclaredMethods();
				for(Method method: methods){
					if(!method.isAnnotationPresent(AuthMethod.class)) continue;
					AuthMethod am = method.getAnnotation(AuthMethod.class);
					String r = am.role();
					List<String> roles =AuthUtil.getRoleList(r);
					for(String role : roles){
						Set<String> actions = auths.get(role);
						if(actions ==null){
							actions = new HashSet<String>();
							auths.put(role, actions);
						}
						actions.add(pc+"."+method.getName());
					}
					
						
				}
				
			}
			return auths;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	private static String[] getClassByPackage(String pname) {
		String pr = pname.replace(".", "/");
		String pp = AuthUtil.class.getClassLoader().getResource(pr).getPath();
		File file = new File(pp);
		String[] fs = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".class")) return true;
				return false;
			}
		});
		return fs;
	}
	
	private static List<String> getRoleList(String role){
		 
		 List<String> roles = Arrays.asList(role.split(","));
		 return roles;

	}
//	private static void getAllMethodFromClass(Class clz){
//		
//	}
}
