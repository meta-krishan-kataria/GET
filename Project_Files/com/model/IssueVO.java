package com.model;

import java.util.List;

public class IssueVO {
	private int id;
	private String title;
	private int createdBy;
	private String creater;
	private String createdOn;
	private int deptId;
	private String department;
	private String body;
	private String currentStatus;
	private String priority;
	private String targetResolutionDate;
	private String actualResolutionDate;
	private List<String> tags;
	private List<Integer> resolvers;
	
	public IssueVO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	
	
	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTargetResolutionDate() {
		return targetResolutionDate;
	}

	public void setTargetResolutionDate(String targetResolutionDate) {
		this.targetResolutionDate = targetResolutionDate;
	}

	public String getActualResolutionDate() {
		return actualResolutionDate;
	}

	public void setActualResolutionDate(String actualResolutionDate) {
		this.actualResolutionDate = actualResolutionDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<Integer> getResolvers() {
		return resolvers;
	}

	public void setResolvers(List<Integer> resolvers) {
		this.resolvers = resolvers;
	}

	@Override
	public String toString() {
		return "IssueVO [id=" + id + ", title=" + title + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", department="
				+ department + ", body=" + body + ", currentStatus="
				+ currentStatus + ", priority=" + priority
				+ ", targetResolutionDate=" + targetResolutionDate
				+ ", actualResolutionDate=" + actualResolutionDate + ", tags="
				+ tags + ", resolvers=" + resolvers + "]";
	}
	
	
}
