package com.zl.credit.creditcore.job;

import java.math.BigDecimal;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.zl.credit.creditcore.dao.QuertzMapper;
import com.zl.credit.creditcore.pojo.BankMoney;
/**
 * 定义任务类
 * @author Administrator
 *
 */
public class AutoRepay implements Job {

	@Autowired
	private QuertzMapper quertzMapper;
	/**
	 * 任务被触发时调用的方法
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void execute(JobExecutionContext context
			) throws JobExecutionException {
		
		BigDecimal money = quertzMapper.selectRepayMoney();
		String card = quertzMapper.selectNotMain();
		BigDecimal cardMoney=quertzMapper.selectAllMoney();
		//转账操作
		if (money.compareTo(cardMoney)==-1) {
			quertzMapper.cutMoney(money,card);
			quertzMapper.addMoney(money,"1234123412341234123");	
		}
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}
	
}
