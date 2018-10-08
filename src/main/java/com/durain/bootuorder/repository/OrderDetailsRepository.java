package com.durain.bootuorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durain.bootuorder.dataobject.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {

}
