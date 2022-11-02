package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	Long eid;
	String ename;
	String desgn;
	
    @ManyToOne
    Department department;
	
	public Employee() {
		
	}

	public Employee(Long eid, String ename, String desgn, Department department) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.desgn = desgn;
		this.department = department;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDesgn() {
		return desgn;
	}

	public void setDesgn(String desgn) {
		this.desgn = desgn;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", desgn=" + desgn + ", department=" + department + "]";
	}

	
	
}
