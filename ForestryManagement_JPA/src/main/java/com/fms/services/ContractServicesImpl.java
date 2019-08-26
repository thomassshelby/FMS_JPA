package com.fms.services;

import com.fms.beans.Contract;
import com.fms.dao.ContractDAO;
import com.fms.dao.ContractJPAImpl;

public class ContractServicesImpl implements ContractServices {
	ContractDAO services = new ContractJPAImpl();

	@Override
	public Contract addContract(Contract contract) {
		return services.addContractor(contract);
	}

	@Override
	public boolean deleteContract(Integer contractId) {
		return services.deleteContractor(contractId);
	}

	
}
