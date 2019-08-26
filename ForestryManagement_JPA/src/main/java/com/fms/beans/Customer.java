package com.fms.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id@Column(name="customer_id")
	private String customerId;
	private String customerName;
	private Long telephoneNumber;
	private String emailAddress;
	private String customerPassword;
	@Embedded
	private Address address;
	@OneToMany
	private List<Contract> contract = new ArrayList<Contract>();
	@OneToMany
	private List<Orders> order = new ArrayList<Orders>();
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Long getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(Long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Orders> getOrder() {
		return order;
	}
	public void setOrder(List<Orders> order) {
		this.order = order;
	}
	public List<Contract> getContract() {
		return contract;
	}
	public void setContract(List<Contract> contract) {
		this.contract = contract;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", telephoneNumber="
				+ telephoneNumber + ", emailAddress=" + emailAddress + ", customerPassword=" + customerPassword
				+ ", address=" + address + ", contract=" + contract + ", order=" + order + "]";
	}
	
	
	
	
	


}
