package com.zl.credit.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.credit.creditcore.pojo.Repay;
import com.zl.credit.creditcore.pojo.RepayConditions;
import com.zl.credit.creditcore.service.RepayService;
import com.zl.credit.creditcore.util.DateUtil;
import com.zl.credit.creditcore.util.JsonResult;

@RestController
public class ReturnLoansListController {
	@Autowired
	private RepayService repayService;
	
	/**
	 * 带条件分页查询还款信息
	 * @param pageIndex
	 * @param repayConditions
	 * @return
	 */
	@RequestMapping("/returnLoans")
	public PageInfo<Repay> returnLoans(@RequestParam(defaultValue = "1")Integer pageIndex,
			RepayConditions repayConditions){
		repayConditions.setStartTime(DateUtil.beginForDate(repayConditions.getStartTime()));
		repayConditions.setEndTime(DateUtil.endForDate(repayConditions.getEndTime()));
		PageHelper.startPage(pageIndex, 3);
		List<Repay> list = repayService.queryAllRepaysInfo(repayConditions);
		PageInfo<Repay> repayList = new PageInfo<Repay>(list);
		return repayList;
	}
	
	/**
	 * 查询多条还款记录(模态框)
	 * @param loanId
	 * @return
	 */
	@RequestMapping("/repayRecords")
	public Repay queryRepayRecords(Integer repayid){
		Repay repay = repayService.queryRepayRecords(repayid);
		return repay;
	}
	
	/***
	 * 还款删除操作
	 * @param loanOrder
	 * @return
	 */
	@RequestMapping("/repayDelete")
	public JsonResult repayDel(Integer repayId) {
		JsonResult json = new JsonResult();
		int rows = repayService.repayDel(repayId);
		if(rows > 0) {
			return json;
		}
		json.setSuccess(false);
		return json;
	}
	/**
	 * 评价
	 * @param grades
	 * @return
	 */
	@RequestMapping("/credit")
	public JsonResult credit(Integer grades,String name,Integer repayid) {
		JsonResult json = new JsonResult();
		int rows = repayService.updateGrade(grades,name);
		int creditStatus = repayService.updateCreditStatus(repayid);
		if(rows > 0 && creditStatus > 0) {
			return json;
		}
		json.setSuccess(false);
		return json;
	}
}
