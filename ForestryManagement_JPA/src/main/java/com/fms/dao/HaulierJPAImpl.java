package com.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fms.beans.Address;
import com.fms.beans.Customer;
import com.fms.beans.Haulier;

public class HaulierJPAImpl implements HaulierDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");

	@Override
	public Haulier addHaulier(Haulier haulier, Address address) {
		try{
			EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(haulier);
		em.getTransaction().commit();
		em.close();
		return haulier;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteHaulier(String haulierId, String haulierPassword) {
		EntityManager em = emf.createEntityManager();
		Haulier deleteHaulier = new Haulier();
		//Address address = new Address();
		deleteHaulier = em.find(Haulier.class,haulierId );
	//	address = em.find(Address.class, deleteHaulier.getAddress().getStreetAddress1());
		if(deleteHaulier.getHaulierPassword().equals(haulierPassword))
		{
			em.getTransaction().begin();
			em.remove(deleteHaulier);
			em.getTransaction().commit();
			em.close();
			return true;
		}
		return false;
	}

	@Override
	public Haulier searchHaulier(String haulierId) {
		EntityManager em =emf.createEntityManager();
		Haulier haulier = em.find(Haulier.class, haulierId );
		if(haulier!=null){
			return haulier;
		}
		return null;
	}

	@Override
	public Haulier modifyHaulier(Haulier haulier, String passwd, Address address) {
		EntityManager em = emf.createEntityManager();
		Haulier modifyHaulier = new Haulier();
		modifyHaulier = em.find(Haulier.class, haulier.getHaulierId());
		if(modifyHaulier.getHaulierPassword().equals(passwd))
		{
			em.getTransaction().begin();
			em.merge(haulier);
			em.getTransaction().commit();
			em.close();
			return haulier;	
		}
		return null;
	}

}
