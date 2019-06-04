package com.zl.credit.creditcore.dao;

import java.util.List;

/**
 * 贷款申请表数据访问
 * @author THINK
 *
 */
public interface ApplyMapper {

	/**
	 * 查询所有贷款类型
	 * @return
	 */
	List<Integer> queryAllLoanType();

}
