package com.beans;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
	private int id;
	private String name;
	private String email;
	private String password;
	private String adresse;
	private String company;
	private String phone;
	private boolean role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}
	
	public Client() {}
	//Constructor
	public Client(int id, String name, String email, String password, String adresse, String company, String phone,
			boolean role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.adresse = adresse;
		this.company = company;
		this.phone = phone;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", adresse="
				+ adresse + ", company=" + company + ", phone=" + phone + ", role=" + role + "]";
	}


	
	

}
