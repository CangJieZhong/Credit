package com.zl.credit.creditcore.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.zl.credit.creditcore.dao.QuertzMapper;
import com.zl.credit.creditcore.dao.RepayMapper;
import com.zl.credit.creditcore.pojo.Repay;
import com.zl.credit.creditcore.pojo.RepayConditions;

@Service
public class RepayServiceImpl implements RepayService {
	@Autowired
	private RepayMapper repayMapper;

	@Autowired
	private QuertzMapper quertzMapper;



	@Override
	public List<Repay> queryAllRepaysInfo(RepayConditions repayConditions) {
		List<Repay> list = repayMapper.queryAllRepaysInfo(repayConditions);
		PageInfo<Repay> pageInfo = new PageInfo<Repay>();
		pageInfo.setList(list);
		return list;
	}
	@Override
	public void setMoney(String id) {
		BigDecimal money = quertzMapper.selectRepayMoney();
		String order=quertzMapper.selectOrder(id);
		//放款操作
		quertzMapper.cutMoney(money,"1234123412341234123");
		quertzMapper.addMoney(money,order);
		
	}


	@Override
	public List<Repay> queryRepayRecords(String loanId) {
		return repayMapper.queryRepayRecords(loanId);
	}

	@Override
	public int repayDel(Integer repayId) {
		return repayMapper.repayDel(repayId);
	}

}
