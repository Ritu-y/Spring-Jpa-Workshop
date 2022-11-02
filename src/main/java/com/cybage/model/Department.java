package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Department {

	@Id
	Long did;
	String name;
	
    
	public Department() {
		super();
	}


	public Department(Long did, String name) {
		super();
		this.did = did;
		this.name = name;
	}


	public Long getDid() {
		return did;
	}


	public void setDid(Long did) {
		this.did = did;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Department [did=" + did + ", name=" + name + "]";
	}

	
	
}
