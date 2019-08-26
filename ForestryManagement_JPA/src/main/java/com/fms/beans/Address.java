package com.fms.beans;

import javax.persistence.Embeddable;


@Embeddable
public class Address {
	private String streetAddress1;
	private String streetAddress2;
	private String townCity;
	private String postCode;
	public String getStreetAddress1() {
		return streetAddress1;
	}
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}
	public String getTownCity() {
		return townCity;
	}
	public void setTownCity(String townCity) {
		this.townCity = townCity;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	@Override
	public String toString() {
		return "Address [streetAddress1=" + streetAddress1 + ", streetAddress2=" + streetAddress2 + ", townCity="
				+ townCity + ", postCode=" + postCode + "]";
	}
}
