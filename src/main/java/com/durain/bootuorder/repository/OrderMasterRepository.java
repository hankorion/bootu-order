package com.durain.bootuorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durain.bootuorder.dataobject.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String>{

}
