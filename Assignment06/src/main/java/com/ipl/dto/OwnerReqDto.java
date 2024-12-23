package com.ipl.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OwnerReqDto {

	private String name;

	private String email;

	private String company;

	private Long teamId;
}
