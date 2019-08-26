package com.fms.services;

import com.fms.beans.Product;
import com.fms.dao.ProductDAO;
import com.fms.dao.ProductJpaImpl;

public class ProductServicesImpl implements ProductServices {
	ProductDAO db = new ProductJpaImpl();

	@Override
	public Product addProduct(Product product) {
		return db.addProduct(product);
	}

	@Override
	public boolean deleteProduct(Integer productId) {
		return db.deleteProduct(productId);
	}

	@Override
	public Product modifyProduct(Integer productId, Product product) {
		return db.modifyProduct(product, productId);
	}

	@Override
	public Product searchProduct(Integer productId) {
		return db.searchProduct(productId);
	}

	

	
}
