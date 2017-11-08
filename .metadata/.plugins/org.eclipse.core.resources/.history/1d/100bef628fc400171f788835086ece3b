package com.cms.core.test.util;

import java.util.List;

import junit.framework.Assert;

import com.cms.core.model.Channel;
import com.cms.core.model.Group;
import com.cms.core.model.Role;
import com.cms.core.model.User;

public class EntitiesHelper {
	private static User baseUser = new User(1,"admin1","123","admin1","admin1@admin.com","110",1);
	
	public static void assertRole(Role expected,Role actual) {
		Assert.assertNotNull(expected);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getName(), actual.getName());
		Assert.assertEquals(expected.getRoleSn(), actual.getRoleSn());
		
	}
	
	public static void assertRoles(List<Role> expected,List<Role> actuals) {
		for(int i=0;i<expected.size();i++) {
			Role er = expected.get(i);
			Role ar = actuals.get(i);
			assertRole(er, ar);
		}
	}
	
	public static void assertUser(User expected,User actual) {
		Assert.assertNotNull(expected);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getUsername(), actual.getUsername());
		Assert.assertEquals(expected.getEmail(), actual.getEmail());
		Assert.assertEquals(expected.getNickname(), actual.getNickname());
		Assert.assertEquals(expected.getEmail(), actual.getEmail());
		Assert.assertEquals(expected.getPhone(), actual.getPhone());
		Assert.assertEquals(expected.getStatus(), actual.getStatus());
	}
	
	public static void assertUsers(List<User> expected,List<User> actuals) {
		for(int i=0;i<expected.size();i++) {
			User eu = expected.get(i);
			User au = actuals.get(i);
			assertUser(eu, au);
		}
	}
	
	
	public static void assertUser(User expected) {
		assertUser(expected, baseUser);
	}
	
	public static void assertRoleIds(List<Integer> expected, List<Integer> actuals){
		for(int i=0; i<expected.size(); i++){
			int eri = expected.get(i);
			int ari = actuals.get(i);
			Assert.assertEquals(eri, ari);
		}
	}
	
	public static void assertObjects(List<?> expected, List<?> actuals){
		for(int i=0; i<expected.size(); i++){
			Object eri = expected.get(i);
			Object ari = actuals.get(i);
			Assert.assertEquals(eri, ari);
		}
	}
	
	public static void assertGroups(List<Group> expected, List<Group> actuals){
		for(int i=0; i<expected.size(); i++){
			Group ge = expected.get(i);
			Group ga = actuals.get(i);
			assertGroup(ge, ga);
		}
	}
	
	public static void assertGroup(Group expected, Group actuals ){
		Assert.assertNotNull(expected);
		Assert.assertEquals(expected.getId(), actuals.getId());
		Assert.assertEquals(expected.getName(), actuals.getName());
		Assert.assertEquals(expected.getDescription(), actuals.getDescription());
	}
	
	public static void assertChannel(Channel expected, Channel actuals){
		Assert.assertNotNull(expected);
		Assert.assertEquals(expected.getId(), actuals.getId());
		Assert.assertEquals(expected.getName(), actuals.getName());
		Assert.assertEquals(expected.getIsIndex(), actuals.getIsIndex());
		Assert.assertEquals(expected.getCustomLink(), actuals.getCustomLink());
		Assert.assertEquals(expected.getCustomLinkUrl(), actuals.getCustomLinkUrl());
		Assert.assertEquals(expected.getIsRecmd(), actuals.getIsRecmd());
		Assert.assertEquals(expected.getIsTopNav(), actuals.getIsTopNav());
		Assert.assertEquals(expected.getOrders(), actuals.getOrders());
		Assert.assertEquals(expected.getStatus(), actuals.getStatus());
		Assert.assertEquals(expected.getType(), actuals.getType());
	}
	
	public static void assertChannels(List<Channel> expected, List<Channel> actuals){
		for(int i=0; i<expected.size(); i++){
			assertChannel(expected.get(i), actuals.get(i));
		}
	}
	
}
