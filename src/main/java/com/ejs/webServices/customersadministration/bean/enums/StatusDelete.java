package com.ejs.webServices.customersadministration.bean.enums;

import br.com.ejs.Status;

//import br.com.ejs.Status;

public enum StatusDelete {
	
	SUCCESS, FAILURE;
	
	public Status toStatus() {
		Status status = Status.fromValue(this.toString());
		return status;
	}
}
