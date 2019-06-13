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
		if(currentPage==null) {
			currentPage=1;
		}
		
		/*
		 * Map<String,Object> map = new HashMap<String,Object>(); map.put("loan_type",
		 * loan_type); map.put("realname",realname ); map.put("startTime",startTime );
		 * map.put("endTime", endTime); map.put("auditor3_msg", auditor3_msg);
		 */
		
		ApplyCondition applyCondition = new ApplyCondition();
		applyCondition.setAuditor3_msg(auditor3_msg);
		applyCondition.setEndTime(endTime);
		applyCondition.setLoan_type(loan_type);
		applyCondition.setRealname(realname);
		applyCondition.setStartTime(startTime);


		return applyMapper.queryApplyAndUserinfo(applyCondition); 
		/*
		 * List<Apply> list = new ArrayList<Apply>();
		 * System.err.println("接收到的alllist"+allList);
		 * System.err.println(allList.size());
		 */
		
//		System.out.println(list);
		/*
		 * PageInfo<Apply> pageDate = new PageInfo<>(); pageDate.setList(allList);
		 * System.out.println("接收到的"+pageDate.getList());
			return allList;
			 */	
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
