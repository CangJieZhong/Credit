package com.zl.credit.creditcore.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BankMoney implements Serializable{

	private String bank_card;
	
	private BigDecimal bank_money;
}
