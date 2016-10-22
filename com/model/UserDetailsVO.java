package com.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UserDetailsVO {

	private int id;
	private String googleId;
	private String emailId;
	private String name;
	private String role;
	private int department;
	private String pictureURL;

	public UserDetailsVO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	@Override
	public String toString() {
		return "UserDetailVO [id=" + id + ", googleId=" + googleId
				+ ", emailId=" + emailId + ", name=" + name + ", role=" + role
				+ ", department=" + department + ", pictureURL=" + pictureURL
				+ "]";
	}

	public UserDetailsVO(int id, String googleId, String name, int department,
			String pictureURL) {
		super();
		this.id = id;
		this.googleId = googleId;
		this.name = name;
		this.department = department;
		this.pictureURL = pictureURL;
	}

}
