package com.gazoomobile.mfw.platform.dao.impl;

import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import com.gazoomobile.mfw.platform.dao.GenericDao;
import com.gazoomobile.mfw.platform.dao.MfwDataAccessException;
import com.gazoomobile.mfw.platform.dao.UserDao;
import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.User;

public class UserDaoImpl extends GenericDao<User, Long>
implements UserDao
{
	public User getUserByName(String username)
	{
		String query = "SELECT u FROM User u WHERE u.username = ?1";
		Object res = null;
		try {
			Query g = this.entityManager.createQuery(query);
			res = g.setParameter(1, username).getSingleResult();
			this.entityManager.refresh(res);
		}
		catch (NonUniqueResultException e) {
			System.out.println("Posible intento SQL injection");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Exception while retrieving user by username");
			e.printStackTrace();
		}

		if (res != null) {
			this.entityManager.refresh(res);
		}

		return res == null ? null : (User)res;
	}

	public List<Application> getUserApplications(User user)
	{
		User u = (User)getById(user.getIdUser());
		if (u == null) {
			throw new MfwDataAccessException("The specified user does not exist.");
		}
		
		List<Application> apps = u.getApplications();
		for (Application app : apps) {
			entityManager.refresh(app);
		}

		return u.getApplications();
	}
}