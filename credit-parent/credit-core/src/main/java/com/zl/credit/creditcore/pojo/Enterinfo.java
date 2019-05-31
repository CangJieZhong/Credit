package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 企业信息（表）实体类
 */
@Getter
@Setter
@ToString
public class Enterinfo implements Serializable{
	private static final long serialVersionUID = 1L;

	/**用户登录表id*/
	private Integer user_id;
	/**公司名称*/
	private String comp_name;
	/**公司类型*/
	private String comp_type;
	/**公司地址*/
	private String comp_address;
	/**法人代表*/
	private String comp_deputy;
	/**注册资金*/
	private Integer comp_capital;
	/**注册时间*/
	private Date register_date;
	/**营业执照*/
	private String bus_license;
	/**公司规模*/
	private String comp_size;
	/**法人代表个人有效证件*/
	private String deputy_card;
	/**公司电话*/
	private String comp_number;
	/**公司账户*/
	private String comp_account;
	/**公司账户绑定的电话*/
	private String comp_account_number;
	/**创建时间*/
	private Date create_date;
	/**修改时间*/
	private Date update_date;
	/**征信评级(征信接口自动生成)*/
	private Integer credit1;
	/**反诈骗评级(反诈骗接口)*/
	private Integer credit2;
	/**风控评级(风控接口)*/
	private Integer credit3;
	/**分数,类似于蚂蚁积分*/
	private Integer grade;
	/**版本*/
	private Integer edition;
}
