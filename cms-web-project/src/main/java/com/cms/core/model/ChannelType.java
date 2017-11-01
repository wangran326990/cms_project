package com.cms.core.model;

public enum ChannelType {
	NAV_CHANNEL("NAVIGATION BAR"),
	TOPIC_LIST("ARTICAL LIST"),
	TOPIC_CONTENT("ARTICAL CONTENT LIST"),
	TOPIC_IMG("ARTICAL IMAGE LIST");
	
	private String name;
	private ChannelType(String name){
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
