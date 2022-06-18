package com.ejs.webServices.customersadministration.soap.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{http://ejs.com.br}001_customer_not_found")
public class CustomerNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFound(String message) {
		super(message);
	}
		
}
