package com.zl.credit.creditcore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.credit.creditcore.dao.ApplyMapper;
import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.pojo.ApplyCondition;
import com.zl.credit.creditcore.pojo.ApplyConditions;
import com.zl.credit.creditcore.pojo.PageBean;

@Service
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyMapper applyMapper;

	@Override
	public List<Apply> queryApplyAndUserinfo(Integer currentPage, Integer pageSize, 
			String loan_type,String realname,String startTime,String endTime,Integer auditor3_msg)throws Exception {
		PageHelper.startPage(currentPage, pageSize);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("loan_type", loan_type);
		map.put("realname",realname );
		map.put("startTime",startTime );
		map.put("endTime", endTime);
		map.put("auditor3_msg", auditor3_msg);
		
		ApplyCondition applyCondition = new ApplyCondition();
		applyCondition.setAuditor3_msg(auditor3_msg);
		applyCondition.setEndTime(endTime);
		applyCondition.setLoan_type(loan_type);
		applyCondition.setRealname(realname);
		applyCondition.setStartTime(startTime);
		
		List<Apply> allList = applyMapper.queryApplyAndUserinfo(map);
		PageBean<Apply> pageDate = new PageBean<>(currentPage,pageSize);
		pageDate.setItems(allList);

		return pageDate.getItems();
	}

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


}
