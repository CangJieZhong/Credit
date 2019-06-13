package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 还款记录（表）实体类
 */
@Getter
@Setter
@ToString
public class Repay implements Serializable{
	private static final long serialVersionUID = 1L;

	/** 还款序列id 主键 自增 */
	private Integer repay_id;
	/**单号*/
	private String loan_order;
	/**当前第几期*/
	private Integer now_stage;
	/**还款状态  0: 未还款  , 1: 已还款*/
	private Integer repay_status;
	/**还款金额*/
	private BigDecimal repay_money;
	/**还款日期*/
	private Date repay_date;
	/**还款删除状态（0：未删除，1：已删除） 默认为0*/
	private Integer isDelte;
	/** 评价状态 0：未评价，1：已评价 */
	private Integer credit_status;
	
	private Apply apply;
}
