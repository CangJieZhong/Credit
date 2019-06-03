package com.zl.credit.creditgranter.web;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 贷款审核管理
 * @author THINK
 *
 */
@RestController
public class GranterLoanController {

	/**
	 * 分页查询
	 * @param result
	 * @return
	 */
	@RequestMapping(path="/loan.do")
	public String loan(Map<String, Object> result) {
        
        return "loan";
    }
	
}
