package com.ecom.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.UserReqDto;
import com.ecom.pojos.Product;
import com.ecom.pojos.User;
import com.ecom.pojos.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public ApiResponse addNewUser(UserReqDto userReqDto) {
		
		User user = mapper.map(userReqDto, User.class);
//		System.out.println(user);
		
		User persist = userDao.save(user);
		return new ApiResponse("User added successfully");
	}
	
	
	@Override
	public List<Product> showAllProducts(Long userId) {
		User user = userDao.findById(userId).orElseThrow(() -> new RuntimeException("Invalid user id"));
		if(user.getRole() == UserRole.CUSTOMER)
		{
			List<Product> productList = productDao.findByStatus(1);
			return productList;
		}
		return null;
	}
}
