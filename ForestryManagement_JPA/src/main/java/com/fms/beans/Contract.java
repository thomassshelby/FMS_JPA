
package com.fms.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "contract")
public class Contract {
	
	@Id //@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="contract_no")
	private Integer contractNo;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Haulier haulier;
	@ManyToOne
	private Product product;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Haulier getHaulier() {
		return haulier;
	}
	public void setHaulier(Haulier haulier) {
		this.haulier = haulier;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	private String deliveryDate;
	private String deliveryDay;
	private Integer quantity;
	

	
	public Integer getContractNo() {
		return contractNo;
	}
	public void setContractNo(Integer contractNo) {
		this.contractNo = contractNo;
	}
	
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryDay() {
		return deliveryDay;
	}
	public void setDeliveryDay(String deliveryDay) {
		this.deliveryDay = deliveryDay;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Contract [contractNo=" + contractNo + ", customer=" + customer + ", haulier=" + haulier.getHaulierId() + ", product="
				+ product.getProductId() + ", deliveryDate=" + deliveryDate + ", deliveryDay=" + deliveryDay + ", quantity=" + quantity
				+ "]";
	}
	
	
}
