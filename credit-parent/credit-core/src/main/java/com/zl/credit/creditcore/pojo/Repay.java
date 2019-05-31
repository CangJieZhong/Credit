package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
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

	/**单号*/
	private Integer loan_order;
	/**当前第几期*/
	private Integer now_stage;
	/**还款状态  0: 未还款  , 1: 已还款*/
	private Integer repay_status;
	/**还款金额*/
	private Integer repay_money;
	/**还款日期*/
	private Date repay_date;
}
