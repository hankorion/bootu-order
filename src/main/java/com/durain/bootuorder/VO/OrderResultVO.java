package com.durain.bootuorder.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderResultVO {

	@JsonProperty("orderId")
	private String orderId;

}
