package Service;

import DAO.UserDaoInterface;

public class UserService {
	UserDaoInterface ud;
	public boolean UserLogin(String username,String password) {
		if(ud.getUser(username, password)!=null)
			return true;
		else return false;
	}
	public void setUd(UserDaoInterface ud) {
		this.ud = ud;
	}
	public UserDaoInterface getUd() {
		return ud;
	}
	
	
}
