package org.iitp.stockmart.datastructures;

import java.util.LinkedList;
import java.util.Queue;

import org.iitp.stockmart.datastore.Datastore.Order;

public class BuyOrderQueue extends OrderQueue {
	Queue<Order> buyOrderQueue = new LinkedList<Order>();
	
	public boolean placeOrder(Order order) {
		return buyOrderQueue.offer(order);
	}
	
	public Order executeOrder() {
		return buyOrderQueue.poll();
	}
}
