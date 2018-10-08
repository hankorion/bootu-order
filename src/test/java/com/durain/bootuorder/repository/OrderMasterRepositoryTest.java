package com.durain.bootuorder.repository;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.durain.bootuorder.BootuOrderApplicationTests;
import com.durain.bootuorder.dataobject.OrderMaster;
import com.durain.bootuorder.enums.OrderStatusEnum;
import com.durain.bootuorder.enums.PayStatusEnum;

@Component
public class OrderMasterRepositoryTest extends BootuOrderApplicationTests{

	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
	@Test
	public void test01SaveOrderMaster() {
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId("T1");
		orderMaster.setBuyerAddress("AMK");
		orderMaster.setBuyerName("HAHA");
		orderMaster.setBuyerOpenid("xxx");
		orderMaster.setBuyerPhone("88888888");
		orderMaster.setOrderAmount(new BigDecimal(8.8));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.NEW.getCode());

		OrderMaster orderm = orderMasterRepository.save(orderMaster);
		Assert.assertTrue(orderm != null);
	}

}
