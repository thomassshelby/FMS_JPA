package com.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fms.beans.Haulier;
import com.fms.beans.Orders;

public class OrdersJPAImpl implements OrdersDAO {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("myPersistanceUnit");

	@Override
	public Orders addOrders(Orders order) {
		try{
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(order);
			em.getTransaction().commit();
			em.close();
			return order;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Orders modifyOrders(Integer orderId, Orders order) {
		try
		{
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(order);
			em.getTransaction().commit();
			em.close();
			return order;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteOders(Integer orderId) {
		try{
			EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Orders order = em.find(Orders.class, orderId);
		em.remove(order);
		em.getTransaction().commit();
		em.close();
		return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
