package com.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IssueVO {
	private int id;
	private String title;
	private String createdBy;
	
	private String creater;//
	private String createdOn;
	private int departmentId;
	
	private String departmentName;//
	private String body;
	private String currentStatus;
	private String priority;
	private String targetResolutionDate;
	private String actualResolutionDate;
	private Set<String> tags;//
	private List<Integer> resolvers;
	//new
	private List<String> resolverNames;

	public IssueVO() {
		tags=new HashSet<String>();
		resolvers=new ArrayList<Integer>();
		resolverNames=new ArrayList<String>();
	}

	public List<String> getResolverNames() {
		return resolverNames;
	}

	public void setResolverNames(List<String> resolverNames) {
		this.resolverNames = resolverNames;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
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

	

	public List<Integer> getResolvers() {
		return resolvers;
	}

	public void setResolvers(List<Integer> resolvers) {
		this.resolvers = resolvers;
	}

	
}
