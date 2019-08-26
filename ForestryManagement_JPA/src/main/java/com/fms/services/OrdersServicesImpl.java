package com.fms.services;

import com.fms.beans.Orders;
import com.fms.dao.OrdersDAO;
import com.fms.dao.OrdersJPAImpl;

public class OrdersServicesImpl implements OrdersServices {
	OrdersDAO db = new OrdersJPAImpl();

	@Override
	public Orders addOrders(Orders order) {
		return db.addOrders(order);
	}

	@Override
	public Orders modifyOrders(Integer orderId, Orders order) {
		return db.modifyOrders(orderId, order);
	}

	@Override
	public boolean deleteOders(Integer orderId) {
		return db.deleteOders(orderId);
	}

	
	

	
}
