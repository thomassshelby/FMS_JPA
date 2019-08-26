package com.fms.services;

import com.fms.beans.Orders;

public interface OrdersServices {
	public Orders addOrders(Orders order);
	public Orders modifyOrders(Integer orderId, Orders order);
	public boolean deleteOders(Integer orderId);
}
