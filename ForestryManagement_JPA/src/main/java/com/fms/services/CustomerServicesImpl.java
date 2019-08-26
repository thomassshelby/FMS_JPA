package com.fms.services;

import com.fms.beans.Address;
import com.fms.beans.Customer;
import com.fms.dao.CustomerDAO;
import com.fms.dao.CustomerJPAImpl;

public class CustomerServicesImpl implements CustomerServices {
	CustomerDAO services = new CustomerJPAImpl();

	@Override
	public Customer addCustomer(Customer customer, Address address) {
		return services.addCustomer(customer, address);
	}

	

	@Override
	public Customer modifyCustomer(Customer customer, String customerPassword, Address address) {
		return services.modifyCustomer(customer, customerPassword, address);
	}

	@Override
	public Customer searchCustomer(String customerId) {
		return services.searchCustomer(customerId);
	}



	@Override
	public boolean deleteCustomer(String customerId, String customerPassword) {
		return services.deleteCustomer(customerId, customerPassword);
	}
	
		
		
}
