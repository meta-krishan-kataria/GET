package com.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DepartmentVO {

	private int id;
	private String departmentName;
	private int departmentHead;

	public DepartmentVO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(int departmentHead) {
		this.departmentHead = departmentHead;
	}

	@Override
	public String toString() {
		return "DepartmentVO [id=" + id + ", departmentName=" + departmentName
				+ ", departmentHead=" + departmentHead + "]";
	}

}
