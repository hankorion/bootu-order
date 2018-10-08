package com.durain.bootuorder.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
	NEW(0, "New Order"), COMPLETED(1, "Completed Order"), CANCEL(2, "Canceled Order"),;

	private Integer code;
	private String message;

	OrderStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

}
