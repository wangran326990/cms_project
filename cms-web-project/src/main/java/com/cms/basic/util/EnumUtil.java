package com.cms.basic.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
@SuppressWarnings("rawtypes")
public class EnumUtil {
	
	public static List<Integer> enumToOrdinal(Class<? extends Enum> clz){
		if(!clz.isEnum()) return null;
		
		Enum[] enums = clz.getEnumConstants();
		List<Integer> rels = new ArrayList<>();
		for(Enum en: enums){
			rels.add(en.ordinal());
		}
		return  rels;
	}
	
	public static List<String> enumToName(Class<? extends Enum> clz){
		if(!clz.isEnum()) return null;
		Enum[] enums = clz.getEnumConstants();
		List<String> rels = new ArrayList<>();
		for(Enum en : enums){
			rels.add(en.name());
		}
		return rels;
	}
	
	public static Map<Integer, String> enumToMap(Class<? extends Enum> clz){
		if(!clz.isEnum()) return null;
		Enum[] enums = clz.getEnumConstants();
		Map<Integer, String> relsMap = new HashMap<>();
		for(Enum en :enums){
			relsMap.put(en.ordinal(), en.name());
		}
		return relsMap;
	}
	
	public static List<String> enumPropToList(Class<? extends Enum> clz, String propName){
			if(!clz.isEnum()) return null;
			String methodName = "get"+propName.substring(0, 1).toUpperCase()+propName.substring(1,propName.length()); 
			Enum[] enums = clz.getEnumConstants();
			List<String> results = new ArrayList<String>();
		try {
			Method method = clz.getMethod(methodName, null);
			for(Enum en: enums){
				results.add((String) method.invoke(en,null));
			}
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return results;
		
	}
	
	public static Map<Integer, String> enumPropToOrdinalMap(Class<? extends Enum> clz, String propName){
		if(!clz.isEnum()) return null;
		Enum[] enums = clz.getEnumConstants();
		Map<Integer, String> rels = new HashMap<>();
		try {
		for(Enum en: enums){
			
				rels.put(en.ordinal(),(String) PropertyUtils.getProperty(en,propName));	
		}
		return rels;
		
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<String, String> enumPropToMap(Class<? extends Enum> clz, String keyProp, String valProp){
		if(!clz.isEnum()) return null;
		Enum[] enums = clz.getEnumConstants();
		Map<String, String> rels = new HashMap<>();
		try {
		for(Enum en: enums){
				rels.put((String) PropertyUtils.getProperty(en,keyProp),(String) PropertyUtils.getProperty(en,valProp));	
		}
		return rels;
		
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<String, String> enumPropToNameMap(Class<? extends Enum> clz, String propName){
		if(!clz.isEnum()) return null;
		Enum[] enums = clz.getEnumConstants();
		Map<String, String> rels = new HashMap<>();
		try {
		for(Enum en: enums){
				rels.put(en.name(),(String) PropertyUtils.getProperty(en,propName));	
		}
		return rels;
		
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
