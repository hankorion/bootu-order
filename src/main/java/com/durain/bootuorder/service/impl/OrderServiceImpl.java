package com.durain.bootuorder.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durain.bootuorder.dataobject.OrderMaster;
import com.durain.bootuorder.dto.OrderDTO;
import com.durain.bootuorder.enums.OrderStatusEnum;
import com.durain.bootuorder.enums.PayStatusEnum;
import com.durain.bootuorder.repository.OrderDetailsRepository;
import com.durain.bootuorder.repository.OrderMasterRepository;
import com.durain.bootuorder.service.OrderService;
import com.durain.bootuorder.utils.UuidUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMasterRepository orderMasterRepository;

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Override
	public OrderDTO createOrder(OrderDTO orderDto) {
		orderDto.setOrderId(UuidUtil.genUniqueKey());
		
		OrderMaster orderMaster = new OrderMaster();
		BeanUtils.copyProperties(orderDto, orderMaster);
		orderMaster.setOrderAmount(new BigDecimal(5));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.NEW.getCode());
		orderMasterRepository.save(orderMaster);
		
		return orderDto;
	}

}
