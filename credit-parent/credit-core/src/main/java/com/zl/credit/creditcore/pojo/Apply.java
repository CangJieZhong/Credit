package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 贷款申请（表）实体类
 */
@Getter
@Setter
@ToString
public class Apply implements Serializable{
	private static final long serialVersionUID = 1L;
	/**审核未通过*/
	public static final Integer OP_PASS = 0;
	/**用户登录表id*/
	private Integer user_id;
	/**单号*/
	private String loan_order;
	/**贷款金额*/
	private BigDecimal loan_money;
	/**贷款类型  1: 个人贷 ，2: 企业贷*/
	private Integer loan_type;
	/**贷款用途*/
	private String loan_purpose;
	/**分期方式  0: 6+12 ,1: 9+12 , 2: 11+1*/
	private Integer repay_method;
	/**申请日期*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date apply_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	/**审核结束日期*/
	private Date apply_end;
	/**审计专员1*/
	private Integer auditor1;
	/**审计专员2*/
	private Integer auditor2;
	/**审计专员3*/
	private Integer auditor3;
	/**审计1意见  0: 不予批准（否决延期）, 1: 批准通过（通过延期）*/
	private Integer auditor1_msg;
	/**审计2意见  0: 不予批准（否决延期）, 1: 批准通过（通过延期）*/
	private Integer auditor2_msg;
	/**审计3意见  0: 不予批准（否决延期）, 1: 批准通过（通过延期）*/
	private Integer auditor3_msg;
	/**审核状态  0: 未审核,1:审计审核中,2:业务经理审核中,3:审核失败,4:审核成功5:还款中,6:该贷款已结束*/
	private Integer audit_status = 0;
	/**业务经理 4: 业务经理*/
	private Integer manager;
	/**业务经理意见 0: 否决贷款（否决延期）, 1: 批准贷款（批准延期）*/
	private Integer manager_msg;
	/**版本*/
	private Integer edition;
	/**贷款删除状态（0：未删除，1：已删除） 默认为0*/
	private Integer isDelete;
	/** 放款按钮状态 */
	private Integer loanBtn_status;
	/** 审核按钮状态*/
	private Integer shenHe_status;

	/**一个贷款申请对应一个用户*/
	private Userinfo userinfo;
}
