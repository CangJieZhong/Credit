package com.zl.credit.creditgranter.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.credit.creditcore.pojo.Apply;
import com.zl.credit.creditcore.service.ApplyService;

@Controller
public class ApplyController {
	@Autowired
	private ApplyService applyServiceImpl;

	@ResponseBody
	@RequestMapping("/ApplyPage.action")
	public PageInfo<Apply> ApplyPage(Integer currentPage, Integer pageSize,
			String loan_type,String realname,String startTime,String endTime,Integer auditor3_msg,HttpSession session) throws Exception{
		
		List<Apply> list = applyServiceImpl.queryApplyAndUserinfo(currentPage,
				pageSize, loan_type, realname, startTime, endTime, auditor3_msg);
		PageHelper.startPage(1,5);
		PageInfo<Apply> applyList = new PageInfo<Apply>(list);
		for (Apply apply : list) {
			System.out.println("分开之后"+apply.getUser_id());
		}
		session.setAttribute("applyList", applyList);
		
		  System.err.println(applyList.toString());
		  //System.err.println(applyList.getList().size());
		 
		return applyList;
	}

}
