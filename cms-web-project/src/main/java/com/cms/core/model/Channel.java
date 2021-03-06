package com.cms.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="t_channel")
public class Channel {
	public static final String ROOT_NAME="website system management channel";
	public static final int ROOT_ID =0;
	
	private int id;
	private String name;
	private int customLink;
	private String customLinkUrl;
	private ChannelType type;
	private int isIndex;
	private int isTopNav;
	private int isRecmd;
	private int status;
	private int orders;
	private Channel parentChannel;
	
	public Channel() {
		// TODO Auto-generated constructor stub
	}
	
	public Channel(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Channel(int id, String name, int customLink, String customLinkUrl, ChannelType type, int isIndex,
			int isTopNav, int isRecmd, int status, int orders, Channel parentChannel) {
		super();
		this.id = id;
		this.name = name;
		this.customLink = customLink;
		this.customLinkUrl = customLinkUrl;
		this.type = type;
		this.isIndex = isIndex;
		this.isTopNav = isTopNav;
		this.isRecmd = isRecmd;
		this.status = status;
		this.orders = orders;
		this.parentChannel = parentChannel;
	}



	@ManyToOne
	@JoinColumn(name="pid")
	public Channel getParentChannel() {
		return parentChannel;
	}
	
	public void setParentChannel(Channel parentChannel) {
		this.parentChannel = parentChannel;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name")
	@NotEmpty(message="栏目名称不能为空")
	//@NotEmpty(message="channel name is required")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="custom_link")
	public int getCustomLink() {
		return customLink;
	}
	public void setCustomLink(int customLink) {
		this.customLink = customLink;
	}
	
	@Column(name="custom_link_url")
	public String getCustomLinkUrl() {
		return customLinkUrl;
	}
	public void setCustomLinkUrl(String customLinkUrl) {
		this.customLinkUrl = customLinkUrl;
	}
	
	public ChannelType getType() {
		return type;
	}
	public void setType(ChannelType type) {
		this.type = type;
	}
	@Column(name="is_index")
	public int getIsIndex() {
		return isIndex;
	}
	public void setIsIndex(int isIndex) {
		this.isIndex = isIndex;
	}
	@Column(name="is_top_nav")
	public int getIsTopNav() {
		return isTopNav;
	}
	public void setIsTopNav(int isTopNav) {
		this.isTopNav = isTopNav;
	}
	@Column(name="recommend")
	public int getIsRecmd() {
		return isRecmd;
	}
	public void setIsRecmd(int isRecmd) {
		this.isRecmd = isRecmd;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}

}
