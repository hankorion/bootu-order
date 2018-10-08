package com.durain.bootuorder.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
	NEW(0, "Pending Payment"), SUCCESS(1, "Completed Payment"),;

	private Integer code;
	private String message;

	PayStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
