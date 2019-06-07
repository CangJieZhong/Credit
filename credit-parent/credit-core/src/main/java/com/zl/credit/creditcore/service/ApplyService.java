package com.zl.credit.creditcore.service;

import java.util.List;
import java.util.Map;

import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.pojo.ApplyCondition;

public interface ApplyService {

	List<Apply> queryApplyAndUserinfo(Integer currentPage, Integer pageSize, 
			String loan_type,String realname,String startTime,String endTime,Integer auditor3_msg) throws Exception;
	
}
