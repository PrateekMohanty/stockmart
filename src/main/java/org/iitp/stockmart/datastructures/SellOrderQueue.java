package org.iitp.stockmart.datastructures;

import java.util.LinkedList;

import org.iitp.stockmart.datastore.Datastore.Order;

public class SellOrderQueue extends OrderQueue {
	
	public SellOrderQueue() {
		queue = new LinkedList<Order>();
	}
}