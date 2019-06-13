//package com.zl.credit.creditcore.job;
//
//import java.math.BigDecimal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.zl.credit.creditcore.dao.QuertzMapper;
//import com.zl.credit.creditcore.service.LoadMoneyService;
//
//@Component
//public class ScheduledRepay {
//
//	@Autowired
//	private LoadMoneyService loadMoneyService;
//	
//	@Transactional
//	@Scheduled(cron = "0/5 * * * * ? ")
//	public void autoRepay() {
//		System.out.println("aaa");
//		BigDecimal money = loadMoneyService.selectAllMoney();
////		String notMain = loadMoneyService.selectNotMain();
////		//账户余额
////		BigDecimal cardMoney=loadMoneyService.selectAllMoney();
//		//转账操作
////		if (money.compareTo(cardMoney)==-1) {
////		loadMoneyService.cutMoney(money,notMain);
////		loadMoneyService.addMoney(money,"1234123412341234123");	
////		}
//		System.out.println(money);
//	}
//}
