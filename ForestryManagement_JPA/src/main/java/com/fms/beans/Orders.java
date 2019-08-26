package com.fms.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="orders")
public class Orders {
	
	
	@Id 
	@Column (name = "order_no")
	private Integer orderNo;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Haulier haulier;
	
	private String deliveryDate;
	private Integer quantity;
	
	@OneToOne
	@JoinColumn(name="order_no", referencedColumnName="product_id")
	private Product product;
	
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
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
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Orders [orderNo=" + orderNo +  ", deliveryDate=" + deliveryDate + ", quantity=" + quantity  +",customer id= " +customer.getCustomerId()  +",Haulier id "  +  haulier.getHaulierId()  +",product id"  +  product.getProductId()+ "]";
	}
	
	
}
