package com.ejs.webServices.customersadministration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ejs.webServices.customersadministration.bean.enums.StatusDelete;
import com.ejs.webServices.customersadministration.data.Data;
import com.ejs.webServices.customersadministration.model.Customer;
import com.ejs.webServices.customersadministration.repository.CustomerRepository;
import com.ejs.webServices.customersadministration.soap.exceptions.CustomerNotFound;

@Component
public class CustomerDetailService {

	private Data data;
	
	@Autowired
	public CustomerDetailService(@Lazy Data data) {
		this.data = data;
		this.data.createData();
	}

	@Autowired
	private CustomerRepository customerRepository;
	
	public StatusDelete deleteById(Integer id) {
		try {
			this.customerRepository.deleteById(id);
			return StatusDelete.SUCCESS;
		} catch (Exception e) {
			throw new CustomerNotFound("Customer with the id: " + id + " doesn't exist.");
		}
	}	

	public Customer findById(Integer id) throws Exception {
		return this.customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFound("Customer with the id: " + id + " doesn't exist."));
	}
	
	public List<Customer> findAll(){
		return this.customerRepository.findAll();
	}
	
	
	public Customer save(Customer customer) {
		try {
			customer = this.customerRepository.save(customer);
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
