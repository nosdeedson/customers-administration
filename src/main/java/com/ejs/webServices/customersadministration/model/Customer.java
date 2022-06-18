package com.ejs.webServices.customersadministration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.ejs.CustomerDetail;

@Entity
@Table
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String name;
	private String phone;
	
	public CustomerDetail toCustomerDetail() {
		CustomerDetail detail = new CustomerDetail();
		detail.setEmail(this.email);
		detail.setId(this.id);
		detail.setName(this.name);
		detail.setPhone(this.getPhone());
		return detail;
	}
	
	public void fromCustomerDetail(CustomerDetail customerDetail) {
		this.email = customerDetail.getEmail();
		this.id = customerDetail.getId();
		this.name = customerDetail.getName();
		this.phone = customerDetail.getPhone();
	}
	
	public Customer id(int id) {
		this.id = id;
		return this;
	}
	
	public Customer email(String email) {
		this.email = email;
		return this;
	}
	
	public Customer phone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public Customer name(String name) {
		this.name = name;
		return this;
	}
	
	public Customer build() {
		Customer c = new Customer();
		c.email = this.email;
		c.id = this.id;
		c.name = this.name;
		c.phone = this.phone;
		return c;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
	
}
