package org.iitp.stockmart.datastructures;

import java.util.Queue;

import org.iitp.stockmart.datastore.Datastore.Order;

public abstract class OrderQueue {
	Queue<Order> queue;
	
	public synchronized boolean placeOrder(Order order) {
		return queue.offer(order);
	}
	
	public synchronized Order getOrder() {
		return queue.poll();
	}
}
