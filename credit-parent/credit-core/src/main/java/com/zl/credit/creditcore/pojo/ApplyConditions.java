package com.zl.credit.creditcore.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
/**
 * 发放贷款条件查询
 * @author xdh
 *
 */
@Getter
@Setter
public class ApplyConditions {
	/**贷款人*/
	private String customer;
	/**单号*/
	private String loanOrder;
	/**还款日期 开始时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	/**还款日期 结束时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
}
