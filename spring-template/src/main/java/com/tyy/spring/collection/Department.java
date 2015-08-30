package com.tyy.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class Department {
	int id;
	String name;
	Employee[] employeeArray;
	List<Employee> employeeList;
	Set<Employee> employeeSet;
	Map<String, Employee> employeeMap;
	Properties employeeProperties;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee[] getEmployeeArray() {
		return employeeArray;
	}
	public void setEmployeeArray(Employee[] employeeArray) {
		this.employeeArray = employeeArray;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}
	public Map<String, Employee> getEmployeeMap() {
		return employeeMap;
	}
	public void setEmployeeMap(Map<String, Employee> employeeMap) {
		this.employeeMap = employeeMap;
	}
	public Properties getEmployeeProperties() {
		return employeeProperties;
	}
	public void setEmployeeProperties(Properties employeeProperties) {
		this.employeeProperties = employeeProperties;
	}

}
