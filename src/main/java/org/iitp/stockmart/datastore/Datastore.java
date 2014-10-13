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

	}
}
