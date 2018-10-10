package com.durain.bootuorder.requestobject;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class OrderRequestObject {

	@NotEmpty(message="Name should not be null")
	private String name;
	
	@NotEmpty(message="Phone number should not be null")
	private String phone;
	
	@NotEmpty(message="Address should not be null")
	private String address;
	
	@NotEmpty(message="Openid should not be null")
	private String openid;
	
	@NotEmpty(message="Cart should not be null")
	private String items;
	
	
}
