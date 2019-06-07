package com.zl.credit.creditcore.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.pojo.ApplyCondition;

/**
 * 贷款申请表数据访问
 * @author THINK
 *
 */
@Mapper
public interface ApplyMapper {
	/**
	 * 贷款申请表的分页加高级查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Apply> queryApplyAndUserinfo(Map<String,Object> map) throws Exception;
	
}
