package com.cybage.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.model.Department;
import com.cybage.model.Employee;
import com.cybage.service.DepartmentServ;
import com.cybage.service.EmployeeServ;
import com.cybage.service.EmployeeService;

@Controller
public class EmployeeController {

	Logger log=LogManager.getLogger();
//	@Autowired
//	EmployeeService employeeService;
	
	@Autowired
	EmployeeServ employeeServ;
	@Autowired
	DepartmentServ departmentServ;
	
	@RequestMapping(path="/employee",method=RequestMethod.GET)
	public ModelAndView getAllEmployee() {
		List<Employee> employee=employeeServ.getAllEmployees();
		ModelAndView mv=new ModelAndView("allEmp","employees",employee);
		log.info(employee);
		return mv;
	}
	
	//Get Department
//	@RequestMapping(path="/department",method=RequestMethod.GET)
//	public ModelAndView getAllDepartment() {
//		ModelAndView mv=new ModelAndView("allEmp","department",departmentServ.getDepartments());
//		return mv;
//	}

	
//	@RequestMapping(path="/getemployee",method=RequestMethod.GET)
//	public ModelAndView showEmployee() {
//		Employee employee=new Employee(101,"Sam","Manager");
//		log.info("Inside First Controller");
//		ModelAndView mv=new ModelAndView("employee","emp",employee);
//		return mv;
//	}
	
	@RequestMapping(path="/getemp/{name}",method=RequestMethod.GET)
	public ModelAndView getEmployee(@PathVariable String name) {
		log.info("Inside GetByNameIgnoreCase Controller");

		ModelAndView mv=new ModelAndView("employee","emp",employeeServ.getEmployeeByName(name));
		return mv;
	}
	
	@RequestMapping(path="/getemployee/{id}",method=RequestMethod.GET)
	public ModelAndView getEmployeeById(@PathVariable long id) {
//		Employee employee=employeeService.getEmpById(id);
		Employee employee=employeeServ.getEmpById(id);
		ModelAndView mv;
		log.info("Employee Id: "+id);
		if(employee.getEid()!=0) {
			mv=new ModelAndView("employee","emp",employee);
			return mv;
		}
		else {
			mv=new ModelAndView("noemp","message","Employee Not Found!!");
			return mv;
		}

	}
//	@RequestMapping(path="/getemployeename",method=RequestMethod.GET)
//	public ModelAndView getEmployeeByName(@RequestParam String name) {
//		Employee employee=employeeService.getEmpByName(name);
//		ModelAndView mv;
//		log.info("Employee Name: "+employee.getEid());
//		if(employee.getEid()!=0) {
//			mv=new ModelAndView("employee","emp",employee);
//			return mv;
//		}
//		else {
//			mv=new ModelAndView("noemp","message","Employee Not Found!!");
//			return mv;
//		}
//
//	}
	
	//Create Employee
	@RequestMapping(path="/create",method=RequestMethod.GET)
	public ModelAndView addEmployee() {
		Employee employee=new Employee();
		log.info("Inside get create controller");
		ModelAndView mv=new ModelAndView("createEmployee","emp",employee);
		return mv;
	}
	@RequestMapping(path="/create",method=RequestMethod.POST)
	public ModelAndView createEmployee(@ModelAttribute Employee employee) {
		Employee emp=employeeServ.createEmployee(employee);
		log.info("Inside post create controller");
		ModelAndView mv=new ModelAndView("allEmp","employees",employeeServ.getAllEmployees());
		return mv;
	}
	
	
	//Create Department
	@RequestMapping(path="/add",method=RequestMethod.GET)
	public ModelAndView addDepartment() {
		Department department=new Department();
		log.info("Inside get create controller");
		ModelAndView mv=new ModelAndView("addDepartment","dept",department);
		return mv;
	}
	@RequestMapping(path="/add",method=RequestMethod.POST)
	public ModelAndView createDepartment(@ModelAttribute Department department) {
		Department dept=departmentServ.createDepartment(department);
		log.info("Inside post create controller");
		ModelAndView mv=new ModelAndView("allEmp","employees",employeeServ.getAllEmployees());
		return mv;
	}
	
	//Update Employee
	@RequestMapping(path="/edit/{id}",method=RequestMethod.GET)
	public ModelAndView editEmployee(@PathVariable long id) {
		Employee employee=employeeServ.getEmpById(id);
		ModelAndView mv=new ModelAndView("updateEmployee","emp",employee);
		return mv;
	}
	@RequestMapping(path="/edit",method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute  Employee employee) {
		employeeServ.updateEmployee(employee,employee.getEid());
		ModelAndView mv=new ModelAndView("allEmp","employees",employeeServ.getAllEmployees());
		return mv;
	}
	
	//Update Department
	//Update Employee
//	@RequestMapping(path="/update/{id}",method=RequestMethod.GET)
//	public ModelAndView editDepartment(@PathVariable long id) {
//		Department department=departmentServ.getDeptById(id);
//		ModelAndView mv=new ModelAndView("updateDepartment","dept",department);
//		return mv;
//	}
//	@RequestMapping(path="/update",method=RequestMethod.POST)
//	public ModelAndView updateDepartment(@ModelAttribute  Department department) {
//		departmentServ.updateDepartment(department, department.getDid());
//		ModelAndView mv=new ModelAndView("allEmp","department",departmentServ.getDepartments());
//		return mv;
//	}
	
	//Delete Employee
	@RequestMapping(path="/delete/{id}",method=RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable int id) {
		employeeServ.deleteEmployee(id);
		ModelAndView mv=new ModelAndView("allEmp","employees",employeeServ.getAllEmployees());
		return mv;
	}
	
	//Delete Department
//	@RequestMapping(path="/deletedept/{id}",method=RequestMethod.GET)
//	public ModelAndView deleteDepartment(@PathVariable int id) {
//		departmentServ.deleteDepartment(id);
//		ModelAndView mv=new ModelAndView("allEmp","department",departmentServ.getDepartments());
//		return mv;
//	}
}
