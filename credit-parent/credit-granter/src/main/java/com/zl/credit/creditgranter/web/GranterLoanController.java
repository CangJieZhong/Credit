package com.zl.credit.creditgranter.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zl.credit.creditcore.pojo.Condition;
import com.zl.credit.creditcore.service.ApplyService;

/**
 * 贷款审核管理
 * @author THINK
 *
 */
@RestController
public class GranterLoanController {

	@Autowired
	private ApplyService applyService;
	/**
	 * 主页高级查询带分页
	 * @param result
	 * @return
	 */
	@RequestMapping(path="/loan.do")
	public String loan(HttpServletRequest request,Condition condition,String pageIndex) {
		List<String> loanTypeList = applyService.qureyAllLoanType();
		request.setAttribute("loanTypeList", loanTypeList);
        return "loan";
    }
	
}
