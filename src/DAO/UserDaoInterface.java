package DAO;

import Pojo.User;

public interface UserDaoInterface {
	User getUser(String username,String password);
}
