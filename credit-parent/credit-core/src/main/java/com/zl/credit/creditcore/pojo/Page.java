package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页实体类
 * @author Administrator
 * @param <T>
 *
 */
@Getter
@Setter
@ToString
public class Page<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 当前页 */
	private int pageIndex;
	/** 页容量 */
	private int pageSize = 1;
	/** 总页数 */
	private int totalPages;
	/** 总记录数 */
	private int totalCount;
	/** 对象集合 */
	private List<T> datas;
	
	public int getTotalPages() {
		return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount
				/ pageSize + 1;
	}

}

