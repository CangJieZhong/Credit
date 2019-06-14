package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QueryByGranter implements Serializable{
	/**贷款类型 默认为个人贷(即值为1)*/
	private Integer loan_type = 1;
	/**单号*/
	private String loanOrder;
	/**还款日期 开始时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	/**还款日期 结束时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
}
