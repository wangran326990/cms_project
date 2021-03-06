package com.cms.core.dao;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.cms.basic.util.EnumUtil;
import com.cms.core.model.Channel;
import com.cms.core.model.ChannelType;
import com.cms.core.model.RoleType;
import com.cms.core.test.util.EntitiesHelper;

public class TestEnum {

	@Test
	public void testEnumToName() {
		List<String> actuals = Arrays.asList("ROLE_ADMIN", "ROLE_PUBLISHER", "ROLE_AUDIT");
		List<String> expected = EnumUtil.enumToName(RoleType.class);
		EntitiesHelper.assertObjects(expected, actuals);
	}
	@Test
	public void testEnumProp(){
		List<String> list =(List<String>) EnumUtil.enumPropToList(ChannelType.class, "name");
		for(String name : list){
			System.out.println(name);
		}
	}

}
