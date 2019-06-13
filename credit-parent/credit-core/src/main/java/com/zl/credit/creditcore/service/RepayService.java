package com.zl.credit.creditcore.service;

import java.math.BigDecimal;
import java.util.List;

import com.zl.credit.creditcore.pojo.Repay;
import com.zl.credit.creditcore.pojo.RepayConditions;

public interface RepayService {

	/**
	 * （发放）查询所有还款信息
	 * @return
	 */
	List<Repay> queryAllRepaysInfo(RepayConditions repayConditions);

	/**
	 * 查询多条还款记录(模态框)
	 * @param loanId
	 * @return
	 */
	List<Repay> queryRepayRecords(String loanId);

	/**
	 * 还款删除 返回的结果
	 * @param repayId
	 * @return
	 */
	int repayDel(Integer repayId);

	//放款
	String setMoney(String id);

	void updateRepayState(String loanId);

	

}
