package com.model;

public class ResolverVO {

	private int id;
	private String emailId;
	private String name;
	private int departmentId;
	private String departmentName;
	private String pictureURL;
	private int numberOfPendingIssues;//
	private int numberOfSolvedIssues;//
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	public int getNumberOfPendingIssues() {
		return numberOfPendingIssues;
	}
	public void setNumberOfPendingIssues(int numberOfPendingIssues) {
		this.numberOfPendingIssues = numberOfPendingIssues;
	}
	public int getNumberOfSolvedIssues() {
		return numberOfSolvedIssues;
	}
	public void setNumberOfSolvedIssues(int numberOfSolvedIssues) {
		this.numberOfSolvedIssues = numberOfSolvedIssues;
	}
	

	
	
}
