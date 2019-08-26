package com.fms.services;

import com.fms.beans.Address;
import com.fms.beans.Haulier;
import com.fms.dao.HaulierDAO;
import com.fms.dao.HaulierJPAImpl;

public class HaulierServicesImpl implements HaulierServices{
	HaulierDAO db = new HaulierJPAImpl();
	@Override
	public Haulier addHaulier(Haulier haulier,Address address) {
		return db.addHaulier(haulier,address);
	}
	
	@Override
	public boolean deleteHaulier(String haulierId, String haulierPassword) {
		return db.deleteHaulier(haulierId, haulierPassword);
	}
	@Override
	public Haulier searchHaulier(String haulierId) {
		return db.searchHaulier(haulierId);
	}

	@Override
	public Haulier modifyHaulier(Haulier haulier, String passwd,Address address) {
		// TODO Auto-generated method stub
		return db.modifyHaulier(haulier, passwd,address);
	}

}
