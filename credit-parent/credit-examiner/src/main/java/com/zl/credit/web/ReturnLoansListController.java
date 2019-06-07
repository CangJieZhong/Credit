package com.zl.credit.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.credit.creditcore.pojo.Repay;
import com.zl.credit.creditcore.pojo.RepayCondition;
import com.zl.credit.creditcore.service.RepayService;
import com.zl.credit.creditcore.util.DateUtil;

@RestController
public class ReturnLoansListController {
	@Autowired
	private RepayService repayService;
	
	@RequestMapping("/returnLoans")
	public PageInfo<Repay> returnLoans(@RequestParam(defaultValue = "1")Integer pageIndex,
			RepayCondition repayCondition){
		repayCondition.setStartTime(DateUtil.beginForDate(repayCondition.getStartTime()));
		repayCondition.setEndTime(DateUtil.endForDate(repayCondition.getEndTime()));
		PageHelper.startPage(pageIndex, 3);
		List<Repay> list = repayService.queryAllRepaysInfo(repayCondition);
		PageInfo<Repay> repayList = new PageInfo<Repay>(list);
		return repayList;
	}
		
}
