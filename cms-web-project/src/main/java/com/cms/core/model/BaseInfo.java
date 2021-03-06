package com.cms.core.model;

import org.hibernate.validator.constraints.NotEmpty;

public class BaseInfo {
	
	private String name;
	private String address;
	private String zipCode;
	private String phone;
	private String email;
	private int indexPicWidth;
	private int indexPicHeight;
	private String domainName;
	private String recordCode;
	private int indexPicNumber;
	
	public String getRecordCode() {
		return recordCode;
	}
	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}
	public int getIndexPicNumber() {
		return indexPicNumber;
	}
	public void setIndexPicNumber(int indexPicNumber) {
		this.indexPicNumber = indexPicNumber;
	}

	
	@NotEmpty(message="website name not empty")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIndexPicWidth() {
		return indexPicWidth;
	}
	public void setIndexPicWidth(int indexPicWidth) {
		this.indexPicWidth = indexPicWidth;
	}
	public int getIndexPicHeight() {
		return indexPicHeight;
	}
	public void setIndexPicHeight(int indexPicHeight) {
		this.indexPicHeight = indexPicHeight;
	}
	
	@Override
	public String toString() {
		return "BaseInfo [name=" + name + ", address=" + address + ", zipCode=" + zipCode + ", phone=" + phone
				+ ", email=" + email + ", indexPicWidth=" + indexPicWidth + ", indexPicHeight=" + indexPicHeight + "]";
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
}
