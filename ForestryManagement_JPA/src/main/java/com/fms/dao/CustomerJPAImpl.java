package com.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fms.beans.Address;
import com.fms.beans.Customer;

public class CustomerJPAImpl implements CustomerDAO {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("myPersistanceUnit");
	@Override
	public Customer addCustomer(Customer customer, Address address) {
		try{
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
			em.close();
			return customer;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean deleteCustomer(String customerId, String customerPassword) {
		EntityManager em = emf.createEntityManager();
		Customer deleteCustomer = new Customer();
		deleteCustomer = em.find(Customer.class,customerId );
		if(deleteCustomer.getCustomerPassword().equals(customerPassword))
		{
			em.getTransaction().begin();
			em.remove(deleteCustomer);
			em.getTransaction().commit();
			em.close();
			return true;
		}
		return false;
	}

	@Override
	public Customer modifyCustomer(Customer customer, String customerPassword, Address address) {
		EntityManager em = emf.createEntityManager();
		Customer modifyCustomer = new Customer();
		String custId = customer.getCustomerId();
		modifyCustomer = em.find(Customer.class,custId );
		if(modifyCustomer.getCustomerPassword().equals(customerPassword))
		{
			em.getTransaction().begin();
			em.merge(customer);
			em.getTransaction().commit();
			em.close();
			return customer;
		}
		return null;
	}

	@Override
	public Customer searchCustomer(String customerId) {
		EntityManager em =emf.createEntityManager();
		Customer customer = em.find(Customer.class, customerId);
		if(customer!=null){
			return customer;
		}
		return null;
	}

}
