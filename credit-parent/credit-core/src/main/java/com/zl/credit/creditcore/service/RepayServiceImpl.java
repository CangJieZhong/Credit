package com.zl.credit.creditcore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.zl.credit.creditcore.dao.RepayMapper;
import com.zl.credit.creditcore.pojo.Repay;
import com.zl.credit.creditcore.pojo.RepayCondition;
@Service
public class RepayServiceImpl implements RepayService {
	@Autowired
	private RepayMapper repayMapper;
	@Override
	public List<Repay> queryAllRepaysInfo(RepayCondition repayCondition) {
		List<Repay> list = repayMapper.queryAllRepaysInfo(repayCondition);
		PageInfo<Repay> pageInfo = new PageInfo<Repay>();
		pageInfo.setList(list);
		return list;
	}

}
