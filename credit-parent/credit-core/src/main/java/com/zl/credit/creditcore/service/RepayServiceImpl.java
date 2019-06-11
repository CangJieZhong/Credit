package com.zl.credit.creditcore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.zl.credit.creditcore.dao.RepayMapper;
import com.zl.credit.creditcore.pojo.Repay;
import com.zl.credit.creditcore.pojo.RepayConditions;

@Service
public class RepayServiceImpl implements RepayService {
	@Autowired
	private RepayMapper repayMapper;

	@Override
	public List<Repay> queryAllRepaysInfo(RepayConditions repayConditions) {
		List<Repay> list = repayMapper.queryAllRepaysInfo(repayConditions);
		PageInfo<Repay> pageInfo = new PageInfo<Repay>();
		pageInfo.setList(list);
		return list;
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
