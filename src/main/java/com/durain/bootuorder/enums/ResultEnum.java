package com.durain.bootuorder.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	PARAM_ERROR(5001, "Order form error"), CART_EPMTY(5002, "Cart is empty");

	private Integer code;

	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

}
