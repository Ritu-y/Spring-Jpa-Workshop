package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cybage.model.Employee;

@Service
public class EmployeeService {
	List<Employee> employees;
	Employee emp;
	
	public EmployeeService(){
		employees=new ArrayList<>();
		//employees.add(new Employee(101L,"Rachel","SE"));
	}
	
	public Employee getEmpById(Long long1) {
		emp=new Employee();
		employees.stream()
		.filter(e -> e.getEid()==long1)
		.forEach(res->this.emp=res );
		return emp;
	}
	public Employee getEmpByName(String name) {
		emp=new Employee();
		employees.stream()
		.filter(e -> (e.getEname()).equals(name))
		.forEach(res->this.emp=res );
		return emp;
	}
	
	public Employee createEmployee(Employee emp) {
		employees.add(emp);
		return emp;
	}
	
	public List<Employee> getAllEmployee(){
		return employees;
	}
	public void deleteEmployee(long id) {
		employees.remove(getEmpById(id));
	}
	public void updateEmployee(Employee Employee,Long long1) {
		employees.set(employees.indexOf(getEmpById(long1)), Employee);
		
	}
}
