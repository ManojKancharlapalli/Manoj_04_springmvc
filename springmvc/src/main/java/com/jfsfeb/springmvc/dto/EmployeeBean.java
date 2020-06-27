package com.jfsfeb.springmvc.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class EmployeeBean implements Serializable{
	private int id;
	private String name;
	private long mobilenumber;
	private String emailId;
	private String password;
	private int age;

}