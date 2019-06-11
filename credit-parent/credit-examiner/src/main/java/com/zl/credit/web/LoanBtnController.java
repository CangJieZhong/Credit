package com.zl.credit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zl.credit.creditcore.service.RepayServiceImpl;

@Controller
public class LoanBtnController {

	@Autowired
	private RepayServiceImpl repayServiceImpl;
	
	
	//放款操作
	@RequestMapping(value = "loanBtn")
	public String loanBtn() {
		//repayServiceImpl.setMoney(id);
		
		return null;
		
	}
}
