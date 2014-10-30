package org.iitp.stockmart.datastructures;

import org.iitp.stockmart.datastore.Datastore.Order;

public abstract class OrderQueue {
	public boolean placeOrder(Order order){
		return false;
	}
	public Order executeOrder() {
		return null;
	}
}
