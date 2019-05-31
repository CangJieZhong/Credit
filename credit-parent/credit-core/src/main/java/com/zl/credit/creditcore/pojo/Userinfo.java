package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 用户信息（表）实体类
 */
@Getter
@Setter
@ToString
public class Userinfo implements Serializable{
	private static final long serialVersionUID = 1L;

	/**用户登录表id*/
	private Integer userId;
	/**身份证*/
	private Integer idcard;
	/**真实姓名*/
	private String realname;
	/**性别id 0:男 , 1:女*/
	private Integer sex_id;
	/**出生年月日*/
	private Date birthday;
	/**家庭住址*/
	private String address;
	/**当前住址*/
	private String now_address;
	/**手机号码*/
	private String phone_number;
	/**银行卡*/
	private String bank_card;
	/**预留电话*/
	private String reser_phone;
	/**紧急联系人*/
	private String urgent_person;
	/**紧急联系人电话*/
	private String urgent_phone;
	/**婚姻状况*/
	private String marital_status;
	/**学历*/
	private String educa;
	/**职业*/
	private String occ;
	/**就职公司名*/
	private String company;
	/**就职公司电话*/
	private String company_phone;
	/**公司地址*/
	private String company_address;
	/**身份证正面*/
	private String img_on;
	/**身份证反面*/
	private String img_down;
	/**手持证件照照片*/
	private String img_hode;
	/**信誉评级*/
	private Integer credit_rating;
	/**创建时间*/
	private Date create_date;
	/**修改时间*/
	private Date update_date;
	/**状态码*/
	private Integer status_code;
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
