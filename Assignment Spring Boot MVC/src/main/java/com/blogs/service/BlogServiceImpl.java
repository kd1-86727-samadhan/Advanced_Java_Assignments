package com.blogs.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.blogs.dao.BloggerDao;
import com.blogs.pojos.BlogPost;

@Service
@Transactional
public class BlogServiceImpl implements BloggerService {

	@Autowired
	private BloggerDao bloggerDao;

	@Override
	public List<BlogPost> getAllPost() {
		// TODO Auto-generated method stub
		return bloggerDao.findAll();
	}
}
