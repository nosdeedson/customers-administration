package com.ejs.webServices.customersadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejs.webServices.customersadministration.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
