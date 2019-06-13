package com.zl.credit.creditcore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	Repay queryRepayRecords(Integer repayid);

	/**
	 * 还款删除成功与否 返回的 int 结果
	 * @param repayId
	 * @return
	 */
	int repayDel(Integer repayId);

	//修改还款状态
	void updateRepayState(String loanId);

	
	/**
	 * 更新用户积分 
	 * @param grades
	 * @param name
	 * @return
	 */
	int updateGrade(@Param("grades")Integer grades, @Param("name")String name);

	/**
	 * 更改评价按钮的状态
	 * @param repayid
	 * @return
	 */
	int updateCreditStatus(Integer repayid);

}
