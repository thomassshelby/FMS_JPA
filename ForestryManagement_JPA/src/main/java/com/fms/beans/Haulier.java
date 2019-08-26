package com.fms.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="haulier")
public class Haulier {
	@Id @Column(name="haulier_id")
	
	private String haulierId;
	private String haulierName;
	private Long telephoneNumber;
	private String emailAddress;
	@Embedded
	private Address address;
	private String haulierPassword;
	@OneToMany(mappedBy="haulier")
	private List<Contract> contracts = new ArrayList<Contract>();
	@OneToMany(mappedBy="haulier")
	private List<Orders> orders = new ArrayList<Orders>();
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getHaulierPassword() {
		return haulierPassword;
	}
	public void setHaulierPassword(String haulierPassword) {
		this.haulierPassword = haulierPassword;
	}
	public String getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(String haulierId) {
		this.haulierId = haulierId;
	}
	public String getHaulierName() {
		return haulierName;
	}
	public void setHaulierName(String haulierName) {
		this.haulierName = haulierName;
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
	public List<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	public List<Orders> getOrder() {
		return orders;
	}
	public void setOrder(List<Orders> order) {
		this.orders = order;
	}
	@Override
	public String toString() {
		return "Haulier [haulierId=" + haulierId + ", haulierName=" + haulierName + ", telephoneNumber="
				+ telephoneNumber + ", emailAddress=" + emailAddress + ", address=" + address + ", haulierPassword="
				+ haulierPassword + ", contracts=" + contracts + ", orders=" + orders + "]";
	}


}
