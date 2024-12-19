package com.ecom.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.stereotype.Service;

import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductDto;
import com.ecom.pojos.Product;
import com.ecom.pojos.User;
import com.ecom.pojos.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserDao userDao;

	@Override
	public ApiResponse addNewProduct(ProductDto productDto) {
		
	
		
		User admin = userDao.findById(productDto.getUserId()).orElseThrow(() -> new RuntimeException("Invalid user"));
		if(admin.getRole() == UserRole.ADMIN)
		{
			Product persist = mapper.map(productDto, Product.class);
			
			persist.setStatus(1);
			
			Product save = productDao.save(persist);
			return new ApiResponse("Product added successfully !!!!");
		}
		return new ApiResponse("Add product failed");
	}
	
	@Override
	public ApiResponse softDelete(Long productId, Long userId) {
		User admin = userDao.findById(userId).orElseThrow(() -> new RuntimeException("Invalid user"));
		
		Product prod= productDao.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
		
		if(admin.getRole() == UserRole.ADMIN && productDao.existsById(productId))
		{
			prod.setStatus(0);
			return new ApiResponse("Deleted successfully");
		}
		return new ApiResponse("Failed to delete");
	}

}
