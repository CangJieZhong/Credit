package com.zl.credit.creditcore.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LoadMoneyService {
	/**
	 * 转账扣款
	 */
	
	void cutMoney(@Param("Money") BigDecimal Money,@Param("BankCard") String BankCard);
	
	//转账增款
	void addMoney(@Param("Money") BigDecimal Money,@Param("BankCard") String BankCard);
	
	//查询应还金额
	BigDecimal selectRepayMoney(@Param("order")String order);
	
	//查询除了主账户的其他账
	List<String> selectNotMain();

	//查询总余额
	BigDecimal selectAllMoney(String notMainList);

	//查询单号
	String selectOrder(@Param("id") String id);
	
	//根据
}
