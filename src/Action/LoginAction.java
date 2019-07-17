package Action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Service.ArticleService;
import Service.SortService;
import Service.UserService;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	private UserService us;
	
	public String Login() {
		if(us.UserLogin(username, password))
			return SUCCESS;
		else
			return ERROR;
	}
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
	public UserService getUs() {
		return us;
	}
	public void setUs(UserService us) {
		this.us = us;
	}
	
}
