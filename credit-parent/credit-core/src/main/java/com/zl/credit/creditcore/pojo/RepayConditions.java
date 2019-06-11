package com.zl.credit.creditcore.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepayConditions {
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
	/**还款状态 （0：未还款，1：当前已还款，2：已全部还款）*/
	private Integer state;
}
