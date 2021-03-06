package com.cms.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_group_channel")
public class GroupChannel {

	
	private int id;
	private Group group;
	private Channel channel;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="g_id")
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	@ManyToOne
	@JoinColumn(name="c_id")
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public GroupChannel() {
		// TODO Auto-generated constructor stub
	}
	
	public GroupChannel(int id, Group group, Channel channel) {
		super();
		this.id = id;
		this.group = group;
		this.channel = channel;
	}
}
