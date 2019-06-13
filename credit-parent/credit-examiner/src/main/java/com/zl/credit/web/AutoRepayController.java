package com.zl.credit.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import com.zl.credit.creditcore.service.LoadMoneyService;

@Component
public class AutoRepayController {

	@Autowired
	private LoadMoneyService loadMoneyService;
	
	//还款操作
		@Transactional
		@Scheduled(cron = "0/5 * * * * ? ")
		public void sendLoan() {
			//查询除主账户的其他账户
			List<String> list = loadMoneyService.selectNotMain();
			for (String notMainList : list) {
				//查询总贷款金额
				BigDecimal loanMoney = loadMoneyService.selectAllMoney(notMainList);
				//当前应还金额
				BigDecimal num1=new BigDecimal("0.05");
				BigDecimal num2=new BigDecimal("12");
				BigDecimal nowMoney = loanMoney.multiply(num1).divide(num2,2,BigDecimal.ROUND_DOWN);
				//	当前应还金额
				try {
					loadMoneyService.cutMoney(nowMoney, notMainList);
					loadMoneyService.addMoney(nowMoney, "1234123412341234123");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			

		}
		}
	

