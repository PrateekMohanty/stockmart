package org.iitp.stockmart.datastore;

public class Datastore {
	public static class User {
		private String userid;
		private String username;
		private String password;

		protected User(String userid, String username, String password) {
			this.userid = userid;
			this.username = username;
			this.password = password;
		}

		public String getUserId() {
			return userid;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}

	public static class Order {
		private String orderId;
		private User user;
		private Company company;
		private int quantity;
		private String orderMode;	// BuyOrder/SellOrder
		private int limitPrice;	//-1 for market order & otherwise positive
		
		protected Order(String orderId, User user, Company company, int quantity, String orderMode, int limitPrice){
			this.orderId = orderId;
			this.user = user;
			this.company = company;
			this.quantity = quantity;
			this.orderMode = orderMode;
			this.limitPrice = limitPrice;
		}
		
		public String getID() {
			return orderId;
		}
		
		public User getUser() {
			return user;
		}
		
		public Company getCompany() {
			return company;
		}
		
		public int getNoOfStocks() {
			return quantity;
		}
		
		public String getOrderMode() {
			return orderMode;
		}
		
		public int getLimitPrice() {
			return limitPrice;
		}
	}
		
	public static class Company {
	}
}
