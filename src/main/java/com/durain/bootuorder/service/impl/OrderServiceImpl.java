package com.durain.bootuorder.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durain.bootuorder.client.GameServiceClient;
import com.durain.bootuorder.dataobject.GameInfo;
import com.durain.bootuorder.dataobject.OrderDetails;
import com.durain.bootuorder.dataobject.OrderMaster;
import com.durain.bootuorder.dto.CartDTO;
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

	@Autowired
	private GameServiceClient gameServiceClient;

	@Override
	@Transactional
	public OrderDTO createOrder(OrderDTO orderDto) {

		String orderId = UuidUtil.genUniqueKey();

		List<String> productIdList = orderDto.getOrderDetailsList().stream().map(OrderDetails::getProductId)
				.collect(Collectors.toList());

		List<GameInfo> gameInfoList = gameServiceClient.listFromOrder(productIdList);

		BigDecimal orderAmt = new BigDecimal(BigInteger.ZERO);
		for (OrderDetails orderDtls : orderDto.getOrderDetailsList()) {
			for (GameInfo gameInfo : gameInfoList) {
				if (gameInfo.getGameId().equals(orderDtls.getProductId())) {
					orderAmt = gameInfo.getGamePrice().multiply(new BigDecimal(orderDtls.getProductQuantity()))
							.add(orderAmt);
					BeanUtils.copyProperties(gameInfo, orderDtls);
					orderDtls.setOrderId(orderId);
					orderDtls.setDetailId(UuidUtil.genUniqueKey());
					orderDtls.setProductIcon(gameInfo.getGameIcon());
					orderDtls.setProductId(gameInfo.getGameId());
					orderDtls.setProductName(gameInfo.getGameName());
					orderDtls.setProductPrice(gameInfo.getGamePrice());
					orderDtls.setProductId(gameInfo.getGameId());

					orderDetailsRepository.save(orderDtls);
				}
			}

		}

		List<CartDTO> cardDTOList = orderDto.getOrderDetailsList().stream()
				.map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
		gameServiceClient.decreaseGameStock(cardDTOList);
		orderDto.setOrderId(orderId);

		OrderMaster orderMaster = new OrderMaster();
		BeanUtils.copyProperties(orderDto, orderMaster);
		orderMaster.setOrderAmount(orderAmt);
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.NEW.getCode());
		orderMasterRepository.save(orderMaster);

		return orderDto;
	}

}
