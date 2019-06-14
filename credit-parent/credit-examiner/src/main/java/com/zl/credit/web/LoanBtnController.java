package com.zl.credit.web;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.credit.creditcore.service.ApplyService;
import com.zl.credit.creditcore.service.LoadMoneyService;
import com.zl.credit.creditcore.service.RepayService;
import com.zl.credit.creditcore.util.JsonResult;

@Controller
public class LoanBtnController {

	@Autowired
	private RepayService repayService;
	@Autowired
	private LoadMoneyService loadMoneyService;
	@Autowired
	private ApplyService applyService;
	
	
	//放款操作
	@Transactional
	@RequestMapping("/sendLoans")
	@ResponseBody
	public JsonResult sendLoan(BigDecimal loanMoney,String repayType,String bankCard,String loanId) {
		JsonResult json=new JsonResult();
		try {
			loadMoneyService.cutMoney(loanMoney, "1234123412341234123");
			loadMoneyService.addMoney(loanMoney, bankCard);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//修改状态为已还款
		repayService.updateRepayState(loanId);
		//更新放款按钮状态
		 int row = applyService.updateApplyStatus(loanId);
		 if(row <=0) {
			 json.setSuccess(false);
			 return json;
		 }
		 
		return json;
	}
	

}
