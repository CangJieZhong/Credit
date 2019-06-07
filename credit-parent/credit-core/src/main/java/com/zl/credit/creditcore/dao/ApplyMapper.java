package com.zl.credit.creditcore.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.pojo.ApplyData;

/**
 * 贷款申请表数据访问
 * @author THINK
 *
 */
@Mapper
public interface ApplyMapper {

	 void insertApply(ApplyData apply);

	Apply queryByUid(@Param("user_id")Integer user_id);

}
