package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class ApplyData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**用户id*/
	private Integer user_id;
	/**贷款用途*/
	private  String loan_purpose;
	/**贷款金额*/
	private String loan_money;
	/**紧急联系人*/
	private String urgent_person;
	/**紧急联系人电话*/
	private String urgent_phone;
	/**就职公司名*/
	private String company;
	/**公司地址*/
	private String company_address;
	/**就职公司电话*/
	private String company_phone;
	/**职业*/
	private String occ;
	/**婚姻状况*/
	private Integer marital_status;
	/**学历*/
	private Integer educa;
	/**分期方式  0: 6+12 ,1: 9+12 , 2: 11+1*/
	private Integer repay_method;
	/**贷款类型  1: 个人贷 ，2: 企业贷*/
	private Integer loan_type;
	/**修改时间OR创建时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
}
