package com.zl.credit.creditgranter.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zl.credit.creditcore.util.BorrowOrLendMoney;

@RestController
public class BorrowAndLendController {

	
	@RequestMapping(path="/borrowAndLend.action",method=RequestMethod.POST)
	public String borrowAndLend(String idCard,String mobile,String name) {
		return BorrowOrLendMoney.checkBorrowOrLendMoney(idCard, mobile, name);
	}
}
