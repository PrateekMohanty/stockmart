package org.iitp.stockmart.actions;

import org.iitp.stockmart.datastore.Datastore.User;
import org.iitp.stockmart.datastore.DatastoreClient;

@SuppressWarnings("serial")
public class UserAction extends BaseAction {

	// user attributes
	private String username;
	private String password;

	// validate
	public void validate() {
		if (username.isEmpty()) {
			addFieldError("username", "Username is required.");
		}

		if (password.isEmpty()) {
			addFieldError("password", "Password is required.");
		}
	}

	// action methods
	public String loginAction() {
		DatastoreClient datastoreClient = new DatastoreClient();
		User user = datastoreClient.tryLogin(username, password);
		if (user == null) {
			addActionError("Username/Password incorrect.");
			return "fail";
		}
		getSession().setAttribute("userid", user.getUserId());
		return "success";
	}

	public String logoutAction() {
		getSession().removeAttribute("userid");
		return "success";
	}

	public String registerAction() {
		return "success";
	}

	public String viewProfile() {
		return "success";
	}

	public String editProfile() {
		return "success";
	}

	// getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
