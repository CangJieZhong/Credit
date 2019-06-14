package com.zl.credit.creditcore.service;

import java.util.List;

import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.pojo.ApplyConditions;

public interface ApplyService {
	/**
	 *  （发放）查询贷款所有信息
	 * @param applyCondition
	 * @return
	 * @throws Exception 
	 */
	List<Apply> queryAllApplysInfo(ApplyConditions applyConditions) throws Exception;

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
	
	/**
	 * 更新审核按钮状态
	 * @param loanId
	 * @return
	 */
	int updateShenHeStatus(String loanId);

	/**
	 * 审核查询贷款信息
	 * @param applyConditions
	 * @return
	 * @throws Exception 
	 */
	List<Apply> queryAllApplyInfo(ApplyConditions applyConditions) throws Exception;

	/**
	 *  点击审核按钮后,同时更新审核状态 
	 * @param loanId
	 * @return
	 */
	int updateAuditStatus(String loanId);

	/**
	 * 审核  查询一条记录
	 * @param loanOrder
	 * @return
	 */
	Apply queryALoanRecords(String loanOrder);
	
}
