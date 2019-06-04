package com.zl.credit.creditcore.service;

import java.util.List;

/**
 * 贷款申请业务类
 * @author THINK
 *
 */
public interface ApplyService {

	/**
	 * 查询所有贷款类型
	 * @return
	 */
	List<String> qureyAllLoanType();

}
