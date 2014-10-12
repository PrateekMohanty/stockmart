package org.iitp.stockmart.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {

	public String execute() {
		return "success";
	}
	
}