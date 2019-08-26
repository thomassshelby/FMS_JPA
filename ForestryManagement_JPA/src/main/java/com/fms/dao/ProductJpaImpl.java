package com.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fms.beans.Product;

public class ProductJpaImpl implements ProductDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
	@Override
	public Product addProduct(Product product) {
		try{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		return product;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteProduct(Integer productId) {
		EntityManager em = emf.createEntityManager();
		try
		{
			
			Product product = em.find(Product.class, productId);
			if(product!=null)
			{
				System.out.println(product);
				em.getTransaction().begin();
				em.remove(product);
				em.getTransaction().commit();
				em.close();
				return true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public Product modifyProduct(Product product, Integer productId) {
		try
		{
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Product modifyProduct = em.find(Product.class, productId);
			modifyProduct.setProductName(product.getProductName());
			modifyProduct.setProductDescription(product.getProductDescription());
			em.getTransaction().commit();
			em.merge(modifyProduct);
			em.close();
			return modifyProduct;

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product searchProduct(Integer productId) {
		EntityManager em =emf.createEntityManager();
		Product searchProduct  = em.find(Product.class, productId);
		if(searchProduct!=null)
		{
			return searchProduct;
		}
		return null;
	}

}
