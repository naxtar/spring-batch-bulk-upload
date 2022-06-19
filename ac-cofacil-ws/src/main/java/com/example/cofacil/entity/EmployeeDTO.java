package com.example.cofacil.dto;

public class EmployeeDTO {
	private String name;

	private String lastName;

	private int age;

	public EmployeeDTO() {
	}

	public EmployeeDTO(String name, String lastName, int age) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" ").append(lastName).append(", ").append(age);

		return sb.toString();
	}

}
