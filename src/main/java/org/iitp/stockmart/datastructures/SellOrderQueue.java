package org.iitp.stockmart.datastructures;

import java.util.LinkedList;
import java.util.Queue;

import org.iitp.stockmart.datastore.Datastore.Order;

public class SellOrderQueue extends OrderQueue {
	Queue<Order> sellOrderQueue = new LinkedList<Order>();
	
	public boolean placeOrder(Order order) {
		return sellOrderQueue.offer(order);
	}
	
	public Order executeOrder() {
		return sellOrderQueue.poll();
	}
}