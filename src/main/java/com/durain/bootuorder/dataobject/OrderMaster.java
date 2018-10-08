package com.durain.bootuorder.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class OrderMaster {
	@Id
	private String orderId;

	private String buyerName;
	private String buyerPhone;
	private String buyerAddress;
	private String buyerOpenid;
	private BigDecimal orderAmount;
	private Integer orderStatus;
	private Integer payStatus;

	@Column(name = "create_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "update_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
}
