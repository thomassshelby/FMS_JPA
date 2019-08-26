package com.fms.dao;

import com.fms.beans.Address;
import com.fms.beans.Customer;

public interface CustomerDAO {
	public Customer addCustomer(Customer customer, Address address);
	public boolean deleteCustomer(String customerId, String customerPassword);
	public Customer modifyCustomer(Customer customer ,String customerPassword, Address address );
	public Customer searchCustomer(String customerId);
}
