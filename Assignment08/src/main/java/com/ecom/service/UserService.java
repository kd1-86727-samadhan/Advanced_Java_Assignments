package com.ecom.service;

import java.util.List;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.UserReqDto;
import com.ecom.pojos.Product;

public interface UserService {

	ApiResponse addNewUser(UserReqDto userReqDto);

	List<Product> showAllProducts(Long userId);
}

