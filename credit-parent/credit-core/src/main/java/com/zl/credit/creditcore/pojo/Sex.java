package com.zl.credit.creditcore.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 *  性别（表）实体类
 */
@Getter
@Setter
@ToString
public class Sex implements Serializable{
	private static final long serialVersionUID = 1L;

	/**性别id*/
	private Integer sex_id;
	/**性别 0:男 , 1:女*/
	private String sex_sex;
}
