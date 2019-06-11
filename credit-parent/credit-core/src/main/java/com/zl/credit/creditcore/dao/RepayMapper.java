package com.zl.credit.creditcore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zl.credit.creditcore.pojo.Repay;
import com.zl.credit.creditcore.pojo.RepayConditions;

/**
 * 还款记录数据访问
 * @author THINK
 *
 */
@Mapper
public interface RepayMapper {

	/**
	 * 查询所有还款信息
	 * @return
	 */
	List<Repay> queryAllRepaysInfo(RepayConditions repayConditions);

	/**
	 * 查询多条还款记录（模态框）
	 * @param loanId
	 * @return
	 */
	List<Repay> queryRepayRecords(String loanId);

	/**
	 * 还款删除成功与否 返回的 int 结果
	 * @param repayId
	 * @return
	 */
	int repayDel(Integer repayId);

}
