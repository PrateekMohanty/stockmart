package org.iitp.stockmart.datastore;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iitp.stockmart.utils.AppConfig;
import org.iitp.stockmart.datastore.Datastore.User;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatastoreClient {

	private static String JDBC_DRIVER;
	private static String DB_URL;
	private static String USER;
	private static String PASS;
	private Connection conn;
	private Statement stmt;

	static {
		AppConfig appConfig = AppConfig.getInstance();
		JDBC_DRIVER = appConfig.get("DB_JDBC_DRIVER");
		DB_URL = appConfig.get("DB_URL");
		USER = appConfig.get("DB_USER");
		PASS = appConfig.get("DB_PASS");
	}

	public DatastoreClient() {
		conn = null;
		stmt = null;
	}

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = (Statement) conn.createStatement();
	}

	private void disconnect() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
		}
	}

	public User tryLogin(String username, String password) {
		User user = null;
		try {
			connect();
			String query = "SELECT * FROM Users WHERE username = '" + username
					+ "' AND password = '" + password + "'";
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			user = new User(resultSet.getString("userid"),
					resultSet.getString("username"),
					resultSet.getString("password"));
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return user;
	}
	
	public User tryRegister(String username, String password){
		User user = null;
		int resultSet = 0;
		try {
			connect();
			String query = "INSERT INTO FROM Users (username, password) Values ('" + username
					+ "', '" + password + "')";
			resultSet = stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
			if(resultSet > 0){
				user = tryLogin(username, password);
			}
		}
		return user;
	}

}
