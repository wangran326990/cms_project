package com.cms.core.test.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cms.basic.util.BaseInfoUtil;
import com.cms.core.model.BaseInfo;

public class BaseInfoUtilTest {

	BaseInfoUtil biu = BaseInfoUtil.getInstance();
	
	@Test
	public void testRead() {
		System.out.println(biu.read().toString());
		
	}

	@Test
	public void testWrite() {
		BaseInfo bi = new BaseInfo();
		bi.setAddress("test address");
		bi.setEmail("email");
		bi.setIndexPicHeight(200);
		bi.setIndexPicWidth(100);
		bi.setName("test name");
		bi.setPhone("123456789");
		bi.setZipCode("123 321");
		biu.write(bi);
		System.out.println(biu.read().toString());
	}

}
