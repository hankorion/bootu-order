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
public class OrderDetails {

	@Id
	private String detailId;

	private String orderId;
	private String productId;
	private String productName;
	private BigDecimal productPrice;
	private Integer productQuantity;
	private String productIcon;

	@Column(name = "create_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "update_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
}
