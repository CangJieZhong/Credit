package com.zl.credit.creditcore.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zl.credit.creditcore.pojo.Apply;
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
	List<Apply> queryApplyAndUserinfo(Map<String,Object> map) throws Exception;
}
