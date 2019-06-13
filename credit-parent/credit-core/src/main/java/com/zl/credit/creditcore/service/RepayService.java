package com.zl.credit.creditcore.service;

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
	Repay queryRepayRecords(Integer repayid);

	/**
	 * 还款删除 返回的结果
	 * @param repayId
	 * @return
	 */
	int repayDel(Integer repayId);

	//放款

	void updateRepayState(String loanId);

	
	String setMoney(String id);

	/**
	 * 更新用户积分（grade）
	 * @param grades
	 * @param name
	 * @return
	 */
	int updateGrade(Integer grades, String name);

	/**
	 * 评价后 改评价按钮的状态
	 * @param repayid
	 * @return
	 */
	int updateCreditStatus(Integer repayid);

}
