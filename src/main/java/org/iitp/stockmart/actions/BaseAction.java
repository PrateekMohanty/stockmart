package org.iitp.stockmart.actions;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	public String execute() {
		return "success";
	}

	public boolean checkLogin() {
		if (getSession().getAttribute("userid") == null)
			return false;
		return true;
	}

	public HttpServletRequest getServletRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getServletResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
}
