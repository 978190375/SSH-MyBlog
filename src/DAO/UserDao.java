package DAO;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import Pojo.User;

public class UserDao extends HibernateDaoSupport implements UserDaoInterface{

	@Override
	public User getUser(String username, String password) {
		System.out.println(username+""+password);
		
		List users=this.getHibernateTemplate().find("from User as u where u.userName='"+username+"' and u.userPassword='"+password+"'");
		if(users.size()>0)
			return (User)users.get(0);
		else return null;
		// TODO Auto-generated method stub
		
	}

	
	
}
