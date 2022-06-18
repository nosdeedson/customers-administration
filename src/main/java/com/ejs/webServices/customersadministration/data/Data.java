package com.ejs.webServices.customersadministration.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.ejs.webServices.customersadministration.model.Customer;
import com.ejs.webServices.customersadministration.repository.CustomerRepository;

@Service
public class Data {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private List<Customer> customers = new ArrayList<Customer>();
	
	Customer c = new Customer().email("maria@email").id(1).name("maria").phone("11111111").build();
		
	Customer c1 = new Customer().email("lucineia@email").id(2)
				.name("lucineia").phone("11111111").build();
		
	Customer c2 = new Customer().email("joao@email").id(3)
				.name("joao").phone("11111111").build();
		
	Customer c3 = new Customer().email("sil@email").id(4)
				.name("sil").phone("11111111").build();
	
	public List<Customer> createData(){
		customerRepository.saveAll(Arrays.asList(c, c1, c2, c3));
		return customers;
	}
	
	@Bean
	public Data addData() {
		return new Data();
	}
}
