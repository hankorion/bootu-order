package com.durain.bootuorder.dto;

import java.math.BigDecimal;
import java.util.List;

import com.durain.bootuorder.dataobject.OrderDetails;

import lombok.Data;

@Data
public class OrderDTO {

	private String orderId;
	private String buyerName;
	private String buyerPhone;
	private String buyerAddress;
	private String buyerOpenid;
	private BigDecimal orderAmount;
	private Integer orderStatus;
	private Integer payStatus;

	private List<OrderDetails> orderDetailsList;
}
