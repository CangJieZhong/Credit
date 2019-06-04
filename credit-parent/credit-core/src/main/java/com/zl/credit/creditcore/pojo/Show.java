package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 高级查询显示包装类
 * @author THINK
 *
 */
@Getter
@Setter
@ToString
public class Show implements Serializable{
	private static final long serialVersionUID = 1L;

	/**贷款单号*/
	private Integer loan_order;
	/**贷款人姓名*/
	private String realname;
	/**贷款金额*/
	private BigDecimal loan_money;
	/**贷款类型  1: 个人贷 ，2: 企业贷*/
	private Integer loan_type;
	/**还款方式  1: 等额本息 , 2: 提前还款 , 3: 先息后本*/
	private Integer repay_method;
	/**申请日期*/
	private Date apply_date;
	/**审核状态  0: 未审核，1: 已审核*/
	private Integer audit_status;
	
	
}
