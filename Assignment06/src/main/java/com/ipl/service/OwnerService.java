package com.ipl.service;

import com.ipl.dto.ApiResponse;
import com.ipl.dto.OwnerReqDto;


public interface OwnerService {

	ApiResponse addOwner(OwnerReqDto ownerDto);

	 
}
