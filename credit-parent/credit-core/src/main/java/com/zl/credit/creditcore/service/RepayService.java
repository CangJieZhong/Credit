package com.zl.credit.creditcore.service;

import java.util.List;

import com.zl.credit.creditcore.pojo.Repay;
import com.zl.credit.creditcore.pojo.RepayCondition;

public interface RepayService {

	/**
	 * 查询所有还款信息
	 * @return
	 */
	List<Repay> queryAllRepaysInfo(RepayCondition repayCondition);

}
