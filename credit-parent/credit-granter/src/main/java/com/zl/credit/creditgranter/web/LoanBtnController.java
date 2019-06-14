package com.zl.credit.creditgranter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.credit.creditcore.service.ApplyService;
import com.zl.credit.creditcore.util.JsonResult;

@Controller
public class LoanBtnController {

	@Autowired
	private ApplyService applyService;
	
	
	//审核操作
	@Transactional
	@RequestMapping("/sendLoans")
	@ResponseBody
	public JsonResult sendLoan(String loanId) {
		JsonResult json=new JsonResult();
		//更新审核按钮状态
		 int row = applyService.updateShenHeStatus(loanId);
		 int auditStatus = applyService.updateAuditStatus(loanId);
		 if(row <=0 && auditStatus<=0) {
			 json.setSuccess(false);
			 return json;
		 }
		 
		return json;
	}
	

}
