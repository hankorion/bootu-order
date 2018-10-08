package com.durain.bootuorder.repository;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.durain.bootuorder.BootuOrderApplicationTests;
import com.durain.bootuorder.dataobject.OrderDetails;

@Component
public class OrderDetailsRepositoryTest extends BootuOrderApplicationTests {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Test
	public void test01_SaveOrderDetails() {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setDetailId("Dtls id 001");
		orderDetails.setProductIcon("xxx");
		orderDetails.setOrderId("T1");
		orderDetails.setProductId("Blizzard Entertainment - World of Warcraft");
		orderDetails.setProductName("World of Warcraft");
		orderDetails.setProductPrice(new BigDecimal(33.00));
		orderDetails.setProductQuantity(2);

		OrderDetails orderDtls = orderDetailsRepository.save(orderDetails);
		Assert.assertTrue(orderDtls != null);
	}

}
