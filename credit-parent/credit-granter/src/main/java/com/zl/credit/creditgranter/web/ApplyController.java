package com.zl.credit.creditgranter.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.pojo.ApplyConditions;
import com.zl.credit.creditcore.service.ApplyService;
import com.zl.credit.creditcore.util.DateUtil;
import com.zl.credit.creditcore.util.JsonResult;

@Controller
public class ApplyController {
	@Autowired
	private ApplyService applyService;
	
	/**
	 * 带条件分页查询贷款信息
	 * @param pageIndex
	 * @param applyConditions
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/applysLoans")
	@ResponseBody
	public PageInfo<Apply> applyLoans(@RequestParam(defaultValue = "1")Integer pageIndex,
		ApplyConditions applyConditions,HttpServletRequest  request) throws Exception{
		applyConditions.setStartTime(DateUtil.beginForDate(applyConditions.getStartTime()));
		applyConditions.setEndTime(DateUtil.endForDate(applyConditions.getEndTime()));
		PageHelper.startPage(pageIndex, 3);
		List<Apply> list = applyService.queryAllApplyInfo(applyConditions);
		PageInfo<Apply> applyList = new PageInfo<Apply>(list);
		return applyList;
	}
	
	/**
	 * 查询一条记录
	 * @param loanOrder
	 * @return
	 */
	@RequestMapping("/aLoanRecord")
	@ResponseBody
	public Apply queryALoanRecord(String loanOrder){
		Apply apply = applyService.queryALoanRecords(loanOrder);
		return apply;
	}
}
