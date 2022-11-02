package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybage.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByEname(String name);
	
	@Query(value="SELECT e from Employee e where lower(e.ename) =lower(:ename)",nativeQuery=false)
	public Employee getEmployeeByEnameIgnoreCase(@Param(value="ename") String ename);
	
	@Query(value="SELECT * from Employee where ename = ?",nativeQuery=true)
	public Employee getEmployeeByEname(@Param("ename") String ename);
	
	@Query(value="SELECT * FROM Employee e, Department d WHERE e.department_did =d.did;",nativeQuery=true)
	public List<Employee> findAll();
}
