package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 查询条件类
 * @author THINK
 *
 */
@Getter
@Setter
@ToString
public class Condition implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**贷款类型*/
	private String loanType; 
	/**审核状态*/
	private String examineType;
	/**开始日期*/
	private Date start;
	/**结束日期*/
	private Date end;
	

}
