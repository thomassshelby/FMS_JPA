package com.fms.dao;

import com.fms.beans.Address;
import com.fms.beans.Haulier;

public interface HaulierDAO {
	public Haulier addHaulier(Haulier haulier, Address address);
	public boolean deleteHaulier(String haulierId,String haulierPassword);
	public Haulier searchHaulier(String haulierId);
	public Haulier modifyHaulier(Haulier haulier,String passwd,Address address);

}
	