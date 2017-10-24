package com.cms.core.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_role")
public class Role {
	private int id;
	private String name;
	private RoleType roleSn;
	
	public Role(){
	}
	
	
	public Role(int id, String name, RoleType roleSn) {
		this.id = id;
		this.name = name;
		this.roleSn = roleSn;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="role_type")
	public RoleType getRoleSn() {
		return roleSn;
	}
	
	public void setRoleSn(RoleType roleSn) {
		this.roleSn = roleSn;
	}
	
}
