package com.zl.credit.creditcore.service;

import java.util.List;

import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.pojo.ApplyConditions;

public interface ApplyService {

	List<Apply> queryApplyAndUserinfo(Integer currentPage, Integer pageSize, 
			String loan_type,String realname,String startTime,String endTime,Integer auditor3_msg) throws Exception;

	/**
	 *  （发放）查询贷款所有信息
	 * @param applyCondition
	 * @return
	 */
	List<Apply> queryAllApplysInfo(ApplyConditions applyConditions);

	/**
	 * 查询一条贷款记录（模态框）
	 * @param loanOrder
	 * @return
	 */
	Apply queryALoanRecord(String loanOrder);

	/**
	 * 判断删除成功与否
	 * @param loanOrder
	 * @return
	 */
	int loanDelete(String loanOrder);

	/**
	 * 更新放款按钮状态
	 * @param loanId
	 * @return
	 */
	int updateApplyStatus(String loanId);
	
}
