package com.gazoomobile.mfw.platform.service.impl;

import com.gazoomobile.mfw.platform.dao.UserDao;
import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.User;
import com.gazoomobile.mfw.platform.service.MfwServiceException;
import com.gazoomobile.mfw.platform.service.UserService;
import com.gazoomobile.mfw.platform.web.MfwSecutiryException;
import java.util.List;
import org.springframework.dao.DataAccessException;

public class UserServiceImpl
implements UserService
{
	private UserDao userDao;

	public User createOrUpdateUser(User user)
	{
		return (User)this.userDao.InsertOrUpdate(user);
	}

	public User login(String username, String password)
	throws MfwSecutiryException
	{
		User user = this.userDao.getUserByName(username);
		if ((user == null) || (!user.getPassword().equals(password))) {
			throw new MfwSecutiryException("Invalid user credentials");
		}

		return user;
	}

	public void removeUser(User user)
	{
		this.userDao.Delete(user);
	}

	public List<Application> getAllUserApplications(User user)
	{
		try {
			return this.userDao.getUserApplications(user); 
		} catch (DataAccessException e) {
			throw new MfwServiceException(e);
		}
	}

	public User getByName(String userName)
	{
		return this.userDao.getUserByName(userName);
	}

	public UserDao getUserDao() {
		return this.userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}