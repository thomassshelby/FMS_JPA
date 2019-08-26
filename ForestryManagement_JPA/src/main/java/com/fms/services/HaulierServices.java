package com.fms.services;

import com.fms.beans.Address;
import com.fms.beans.Haulier;

public interface HaulierServices {
	public Haulier addHaulier(Haulier haulier,Address address);
	public boolean deleteHaulier(String haulierId,String haulierPassword);
	public Haulier searchHaulier(String haulierId);
	public Haulier modifyHaulier(Haulier haulier,String passwd,Address address);


}
