package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 用户（表）实体类
 */
@Getter
@Setter
@ToString
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**用户*/
	public static  final int  role_id_Personal = 1;
	
	/**审计员*/
	public static  final int  role_id_Auditor = 2;
	/**业务经理*/
	public static  final int  role_id_Busineer  = 3;
	/**发放专员*/
	public static  final int  role_id_Issuancer = 4;
	
	
	/**用户id*/
	private Integer user_id;
	/**用户名*/
	private String username;
	/**密码*/
	private String password;
	/**角色id ( 1: 用户, 2: 审计员 , 3: 业务经理 ,4: 发放专员)*/
	private Integer role_id;
	/**创建时间*/
	private Date create_date;
	/**修改时间*/
	private Date update_date;
}
