package com.zl.credit.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.pojo.ApplyConditions;
import com.zl.credit.creditcore.service.ApplyService;
import com.zl.credit.creditcore.util.DateUtil;
import com.zl.credit.creditcore.util.JsonResult;

@RestController
public class LoansListController {
	@Autowired
	private ApplyService applyService;
	
	/**
	 * 带条件分页查询贷款信息
	 * @param pageIndex
	 * @param applyConditions
	 * @return
	 */
	@RequestMapping("/applysLoans")
	public PageInfo<Apply> applyLoans(@RequestParam(defaultValue = "1")Integer pageIndex,
			ApplyConditions applyConditions,HttpServletRequest  request){
		applyConditions.setStartTime(DateUtil.beginForDate(applyConditions.getStartTime()));
		applyConditions.setEndTime(DateUtil.endForDate(applyConditions.getEndTime()));
		PageHelper.startPage(pageIndex, 3);
		List<Apply> list = applyService.queryAllApplysInfo(applyConditions);
		PageInfo<Apply> applyList = new PageInfo<Apply>(list);
		System.out.println("8092"+request.getSession().getAttribute("user"));
		return applyList;
	}
	
	/**
	 * 查询一条记录
	 * @param loanOrder
	 * @return
	 */
	@RequestMapping("/aLoanRecord")
	public Apply queryALoanRecord(String loanOrder){
		Apply apply = applyService.queryALoanRecord(loanOrder);
		return apply;
	}
	
	/**
	 * 放款删除操作
	 * @param loanOrder
	 * @return
	 */
	@RequestMapping("/loanDelete")
	public JsonResult loanDel(String loanOrder) {
		JsonResult json = new JsonResult();
		int rows = applyService.loanDelete(loanOrder);
		if(rows > 0) {
			return json;
		}
		json.setSuccess(false);
		return json;
	}
	
}
