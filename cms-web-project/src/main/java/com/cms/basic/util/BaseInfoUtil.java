package com.cms.basic.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.cms.core.model.BaseInfo;

public class BaseInfoUtil {
	private static BaseInfoUtil biu;
	private Properties props;
	private BaseInfoUtil() throws IOException{
		if(props==null){
			props = new Properties();
			props.load(BaseInfoUtil.class.getClassLoader().getResourceAsStream("baseInfo.properties"));
		}
	}
	
	public static BaseInfoUtil getInstance() {
		try {
			if(biu==null){
				biu = new BaseInfoUtil();
			} 
			return biu;
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public BaseInfo read(){
		BaseInfo bi = new BaseInfo();
		bi.setAddress(props.getProperty("address"));
		bi.setEmail(props.getProperty("email"));
		bi.setIndexPicHeight(Integer.parseInt(props.getProperty("indexPicHeight")));
		bi.setIndexPicWidth(Integer.parseInt(props.getProperty("indexPicWidth")));
		bi.setName(props.getProperty("name"));
		bi.setPhone(props.getProperty("phone"));
		bi.setZipCode(props.getProperty("zipCode"));
		bi.setDomainName(props.getProperty("domainName"));
		bi.setRecordCode(props.getProperty("recordCode"));
		bi.setIndexPicNumber(Integer.parseInt(props.getProperty("indexPicNumber")));
		return bi;
	}
	
	public BaseInfo write(BaseInfo baseInfo){
		FileOutputStream fos =null;
		try{
			props.setProperty("address", baseInfo.getAddress());
			props.setProperty("email", baseInfo.getEmail());
			props.setProperty("indexPicHeight", String.valueOf(baseInfo.getIndexPicHeight()));
			props.setProperty("indexPicWidth", String.valueOf(baseInfo.getIndexPicWidth()));
			props.setProperty("name", baseInfo.getName());
			props.setProperty("phone", baseInfo.getPhone());
			props.setProperty("zipCode", baseInfo.getZipCode());
			props.setProperty("domainName", baseInfo.getDomainName());
			props.setProperty("recordCode", baseInfo.getRecordCode());
			props.setProperty("indexPicNumber", String.valueOf(baseInfo.getIndexPicNumber()));
			String path = BaseInfoUtil.class.getClassLoader().getResource("baseInfo.properties").getPath();
			fos = new FileOutputStream(path);
			props.store(fos,null);
			return baseInfo;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return null;
	}
	
}
