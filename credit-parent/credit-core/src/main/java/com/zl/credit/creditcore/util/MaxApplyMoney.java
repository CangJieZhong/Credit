package com.zl.credit.creditcore.util;

import java.math.BigDecimal;

public class MaxApplyMoney {
	public static Integer getMaxApplyMoney(Integer grade) {
		if(grade>=500&&grade<600) {
			return 20000;
		} else if(grade>=600&&grade<700) {
			return 30000;
		}else {
			return 40000;
		}
		
	}
}
