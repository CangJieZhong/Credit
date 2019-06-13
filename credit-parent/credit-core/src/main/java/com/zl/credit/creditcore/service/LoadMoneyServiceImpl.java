package com.zl.credit.creditcore.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.credit.creditcore.dao.QuertzMapper;

@Service
public class LoadMoneyServiceImpl implements LoadMoneyService{

	@Autowired
	private QuertzMapper quertzMapper;
	//扣
	@Override
	public void cutMoney(BigDecimal Money, String BankCard) {
		quertzMapper.cutMoney(Money, BankCard);
	}
	//增
	@Override
	public void addMoney(BigDecimal Money, String BankCard) {
		quertzMapper.addMoney(Money, BankCard);
	}
//
	// 查询应还
	@Override
	public BigDecimal selectRepayMoney(String order) {
		return quertzMapper.selectRepayMoney(order);
	}

	//查询除主账户
	@Override
	public List<String> selectNotMain() {

		 List<String> list = quertzMapper.selectNotMain();
		 return list;
	}
	//查询总余额
	@Override
	public BigDecimal selectAllMoney(String notMainList) {

		return quertzMapper.selectAllMoney(notMainList);
	}
	//查询单号
	@Override
	public String selectOrder(String id) {

		return quertzMapper.selectOrder(id);
	}

}
