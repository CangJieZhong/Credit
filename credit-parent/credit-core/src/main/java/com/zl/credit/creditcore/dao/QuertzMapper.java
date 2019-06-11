package com.zl.credit.creditcore.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuertzMapper {

	/**
	 * 转账扣款
	 */
	
	void cutMoney(@Param("Money") BigDecimal Money,@Param("BankCard") String BankCard);
	
	//转账增款
	void addMoney(@Param("Money") BigDecimal Money,@Param("BankCard") String BankCard);
	
	//查询应还金额
	BigDecimal selectRepayMoney();
	
	//查询除了主账户的其他账
	String selectNotMain();

	//查询总余额
	BigDecimal selectAllMoney();

	//查询单号
	String selectOrder(@Param("id") String id);
}
