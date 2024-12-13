package com.blogs.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dao.UserDao;
import com.blogs.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	// Dependency
	@Autowired
	private UserDao userDao;

	@Override
	public User authenticateUser(String em, String pass) {
//		Optional<User> optional = userDao.findByEmailAndPassword(em, pass);
//		if (optional.isPresent())
//			return optional.get();
		return userDao.findByEmailAndPassword(em, pass).orElseThrow();

		/*
		 * valid login - returns user to the caller invalid login - throws
		 * NoSuchElementException
		 */
	}

}
