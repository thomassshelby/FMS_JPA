package com.fms.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="product")
public class Product {
	@Id @Column(name="product_id")

	private  int productId;
	private String productName;
	private String productDescription;
	@OneToMany
	private List<Contract> contract = new ArrayList<Contract>();
	@OneToMany
	private List<Orders> orders = new ArrayList<Orders>();
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public List<Contract> getContract() {
		return contract;
	}
	public void setContract(List<Contract> contract) {
		this.contract = contract;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", contract=" + contract + "]";
	}
	
}
