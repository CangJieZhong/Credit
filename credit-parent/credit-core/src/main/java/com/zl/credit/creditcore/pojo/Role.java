package com.zl.credit.creditcore.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 角色（表）实体类
 */
@Getter
@Setter
@ToString
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**角色id ( 1: 用户, 2: 审计员 , 3: 业务经理 ,4: 发放专员)*/
	private Integer role_id;
	/**角色名(用户,审计员,业务经理,发放专员)*/
	private String role_name;
}
