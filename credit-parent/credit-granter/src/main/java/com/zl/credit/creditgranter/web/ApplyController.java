package com.zl.credit.creditgranter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.service.ApplyService;

@Controller
public class ApplyController {
	@Autowired
	private ApplyService applyServiceImpl;
	
	@ResponseBody
	@RequestMapping("/ApplyPage.action")
	public List<Apply> ApplyPage(Integer currentPage, Integer pageSize,
			String loan_type,String realname,String startTime,String endTime,Integer auditor3_msg) throws Exception{
		return applyServiceImpl.queryApplyAndUserinfo(currentPage, pageSize, loan_type, realname, startTime, endTime, auditor3_msg);
	}

}
