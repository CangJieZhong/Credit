package com.zl.credit.creditcore.pojo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PageBean<T> {
	/**当前页*/
	private Integer currentPage = 1;
	/** 每页显示的总条数*/
	private Integer pageSize = 10;
	/** 总条数*/
	private Integer totalNum;
	/** 是否有下一页*/
	private Integer isMore;
	/**当前页面第一个元素在数据库中的行号*/  
	private int startRow;
	/**当前页面最后一个元素在数据库中的行号 */
	private int endRow;
	/** 总页数*/
	private Integer totalPage;
	/** 开始索引*/
	private Integer startIndex;
	/** 分页结果*/
	private List<T> items;

	public PageBean() {
		super();
	}

	public PageBean(Integer currentPage, Integer pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
		this.startIndex = (this.currentPage-1)*this.pageSize;
		this.isMore = this.currentPage >= this.totalPage?0:1;
	}


}
