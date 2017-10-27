package com.cms.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.cms.core.model.User;

public class UserDto {
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String phone;
	private int status;
	
	private Integer[] roleIds;
	private Integer[] groupIds;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@NotNull(message="username is required")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@NotNull(message="password is required")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Email(message="not a valid email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}

	public Integer[] getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(Integer[] groupIds) {
		this.groupIds = groupIds;
	}

	
	
	public User getUser(){
		User u = new User();
		u.setId(this.id);
		u.setEmail(this.email);
		u.setNickname(nickname);
		u.setPhone(phone);
		u.setPassword(password);
		u.setUsername(username);
		u.setStatus(status);
		return u;
	}
	
	public UserDto(User user){
		setId(user.getId());
		setEmail(user.getEmail());
		setNickname(user.getNickname());
		setPhone(user.getPhone());
		setPassword(user.getPassword());
		setUsername(user.getUsername());
		setStatus(user.getStatus());
	}
	
	public UserDto(User user, Integer[] roleIds, Integer[] groupIds){
		setId(user.getId());
		setEmail(user.getEmail());
		setNickname(user.getNickname());
		setPhone(user.getPhone());
		setPassword(user.getPassword());
		setUsername(user.getUsername());
		setStatus(user.getStatus());
		setGroupIds(groupIds);
		setRoleIds(roleIds);
	}
	
	public UserDto(){
		
	}
}
