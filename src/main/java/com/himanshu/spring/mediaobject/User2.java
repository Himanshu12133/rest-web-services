package com.himanshu.spring.mediaobject;

import java.time.LocalDate;

import org.hibernate.annotations.Filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


//static filter
//@JsonIgnoreProperties({ "id" })

//@JsonFilter("filteridandage")
public class User2 {

	public User2(int id, String name, LocalDate birthdate, int age) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.age = age;
	}

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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	int id;
	
	//static filter
	@JsonIgnore
	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Size(min = 2, message = "Name should atleast contain 2 characaters")
	String name;
	@Past(message = "Date should not past date")
	LocalDate birthdate;
}
