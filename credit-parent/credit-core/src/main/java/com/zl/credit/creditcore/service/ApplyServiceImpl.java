package com.zl.credit.creditcore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.credit.creditcore.dao.ApplyMapper;
import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.pojo.ApplyConditions;
@Service
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyMapper applyMapper;
	@Override
	public List<Apply> queryAllApplysInfo(ApplyConditions applyConditions) {
		List<Apply> list = applyMapper.queryAllApplysInfo(applyConditions);
		PageInfo<Apply> pageInfo = new PageInfo<Apply>();
		pageInfo.setList(list);
		return list;
	}

	@Override
	public Apply queryALoanRecord(String loanOrder) {
		return applyMapper.queryALoanRecord(loanOrder);
	}

	@Override
	public int loanDelete(String loanOrder) {
		return applyMapper.loanDelete(loanOrder);
	}

	@Override
	public int updateApplyStatus(String loanId) {
		return applyMapper.updateApplyStatus(loanId);
	}

	@Override
	public int updateShenHeStatus(String loanId) {
		return applyMapper.updateShenHeStatus(loanId);
	}

	@Override
	public List<Apply> queryAllApplyInfo(ApplyConditions applyConditions) {
		List<Apply> list = applyMapper.queryAllApplyInfo(applyConditions);
		PageInfo<Apply> pageInfo = new PageInfo<Apply>();
		pageInfo.setList(list);
		return list;
	}

	@Override
	public int updateAuditStatus(String loanId) {
		return applyMapper.updateAuditStatus(loanId);
	}

	@Override
	public Apply queryALoanRecords(String loanOrder) {
		return applyMapper.queryALoanRecords(loanOrder);
	}


}
