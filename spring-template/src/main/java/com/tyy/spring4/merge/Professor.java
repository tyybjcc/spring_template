package com.tyy.spring4.merge;

import java.util.List;


public class Professor {
	//basic info
	int id;
	boolean man;
	String name;
	String telephone;
	
	//privacy info
	int salary;
	Student[] students;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isMan() {
		return man;
	}
	public void setMan(boolean man) {
		this.man = man;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Student[] getStudents() {
		return students;
	}
	public void setStudents(Student[] students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		String str = "Professor: id("+id+"), name("+name+"), isMan("+man+"), telephone("+telephone+"); salary("+salary+"), students: ";
		for(Student s: students) {
			str+=s.getName()+" ";
		}
		return str;
	}
	

}
