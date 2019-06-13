package com.zl.credit.creditcore.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zl.credit.creditcore.pojo.Apply;

import com.zl.credit.creditcore.pojo.ApplyCondition;

import com.zl.credit.creditcore.pojo.ApplyConditions;
import com.zl.credit.creditcore.pojo.ApplyData;

import java.util.List;
import java.util.Map;

/**
 * 贷款申请表数据访问
 * @author THINK
 *
 */
@Mapper
public interface ApplyMapper {


	 void insertApply(ApplyData apply);

	Apply queryByUid(@Param("user_id")Integer user_id);


	/**
	 * 贷款申请表的分页加高级查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Apply> queryApplyAndUserinfo(ApplyCondition applyCondition) throws Exception;

	List<Apply> queryApplyAndUserinfo(Map<String,Object> map) throws Exception;

	/**
	 * （发放）查询所有Apply信息
	 * @param applyCondition
	 * @return
	 */
	List<Apply> queryAllApplysInfo(ApplyConditions applyConditions);

	/**
	 * 查询一条贷款记录（模态框）
	 * @param loanOrder
	 * @return
	 */
	Apply queryALoanRecord(String loanOrder);

	/**
	 * 处理删除
	 * @param loanOrder
	 * @return
	 */
	int loanDelete(String loanOrder);

	/**
	 * 更新放款按钮状态
	 * @param loanId
	 * @return
	 */
	int updateApplyStatus(String loanId);
}
