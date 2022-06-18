package com.ejs.webServices.customersadministration.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ejs.webServices.customersadministration.bean.enums.StatusDelete;
import com.ejs.webServices.customersadministration.model.Customer;
import com.ejs.webServices.customersadministration.service.CustomerDetailService;

import br.com.ejs.DeleteCustomerDetailRequest;
import br.com.ejs.DeleteCustomerDetailResponse;
import br.com.ejs.GetAllCustomerDetailRequest;
import br.com.ejs.GetAllCustomerDetailResponse;
import br.com.ejs.GetCustomerDetailRequest;
import br.com.ejs.GetCustomerDetailResponse;
import br.com.ejs.SaveCustomerDetailRequest;
import br.com.ejs.SaveCustomerDetailResponse;


@Endpoint
public class CustomerDetailEndPoint {
	
	@Autowired
	private CustomerDetailService customerDetailService;
	
	@PayloadRoot(namespace = "http://ejs.com.br" , localPart = "GetCustomerDetailRequest")
	@ResponsePayload
	public GetCustomerDetailResponse processCustomerDetailRequest(@RequestPayload GetCustomerDetailRequest request) throws Exception {
		Customer customer = this.customerDetailService.findById(request.getId());
		return this.convertToGetCustomerDetailResponse(customer);
	}
	
	private GetCustomerDetailResponse convertToGetCustomerDetailResponse(Customer customer) {
		GetCustomerDetailResponse customerDetailResponse = new GetCustomerDetailResponse();
		customerDetailResponse.setCustomerDetail(customer.toCustomerDetail());
		return customerDetailResponse;
	}
	
	@PayloadRoot(namespace = "http://ejs.com.br", localPart = "GetAllCustomerDetailRequest")
	@ResponsePayload
	public GetAllCustomerDetailResponse processAllCustomerDetailRequest(@RequestPayload GetAllCustomerDetailRequest request) {
		List<Customer> customers = this.customerDetailService.findAll();
		return this.convertToGetAllCustomerDetailResponse(customers);
 	}
	
	private GetAllCustomerDetailResponse convertToGetAllCustomerDetailResponse(List<Customer> customers) {
		GetAllCustomerDetailResponse response = new GetAllCustomerDetailResponse();
		customers.stream().forEach(c -> response.getCustomerDetail().add(c.toCustomerDetail()));
		return response;
	}
	
	@PayloadRoot(namespace = "http://ejs.com.br", localPart = "DeleteCustomerDetailRequest")
	@ResponsePayload
	public DeleteCustomerDetailResponse processDeleteCustomerDetailRequest(@RequestPayload DeleteCustomerDetailRequest request) {
		StatusDelete statusDelete = this.customerDetailService.deleteById(request.getId());
		DeleteCustomerDetailResponse response = new DeleteCustomerDetailResponse();
		response.setStatus(statusDelete.toStatus());
		return response;
	}

	@PayloadRoot(namespace = "http://ejs.com.br", localPart = "SaveCustomerDetailRequest")
	@ResponsePayload
	public SaveCustomerDetailResponse processSaveCustomerDetailRequest(@RequestPayload SaveCustomerDetailRequest request) {
		Customer customer = new Customer();
		customer.fromCustomerDetail(request.getCustomerDetail());
		customer = this.customerDetailService.save(customer);
		SaveCustomerDetailResponse response = new SaveCustomerDetailResponse();
		response.setCustomerDetail(customer.toCustomerDetail());
		return response;
	}

}
