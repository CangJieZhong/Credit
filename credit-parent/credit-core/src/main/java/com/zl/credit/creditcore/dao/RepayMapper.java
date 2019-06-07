package com.zl.credit.creditcore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zl.credit.creditcore.pojo.Repay;
import com.zl.credit.creditcore.pojo.RepayCondition;

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
	List<Repay> queryAllRepaysInfo(RepayCondition repayCondition);

}
