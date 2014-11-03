package org.iitp.stockmart.datastructures;

import java.util.LinkedList;

import org.iitp.stockmart.datastore.Datastore.Order;

public class BuyOrderQueue extends OrderQueue {
	
	public BuyOrderQueue() {
		queue = new LinkedList<Order>();
	}
}
