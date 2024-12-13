package com.blogs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.BlogPost;

public interface BloggerDao extends JpaRepository<BlogPost, Long> {
	List<BlogPost> findAll();
}
