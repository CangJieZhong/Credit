package com.zl.credit.creditcore.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 贷款申请表的高级查询条件类
 * @author sun
 * @version  创建时间   2019年6月6日  下午4:01:18
 */
@Setter
@Getter
@ToString
public class ApplyCondition  implements Serializable{

	private static final long serialVersionUID = 1L;
	/**贷款类型*/
	private String loan_type;
	/**贷款人	*/
	private String realname;
	/**页面选择的开始时间*/
	private String startTime;
	/**页面选择的结束时间*/
	private String endTime;
	/**审核状态*/
	private Integer auditor3_msg;
	
}
