package com.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fms.beans.Contract;

public class ContractJPAImpl implements ContractDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");

	@Override
	public Contract addContractor(Contract contract) {
		try{
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(contract);
			em.getTransaction().commit();
			em.close();
			return contract;
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public boolean deleteContractor(Integer contractId)
	{

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Contract contract = em.find(Contract.class, contractId);
		em.remove(contract);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	

}
