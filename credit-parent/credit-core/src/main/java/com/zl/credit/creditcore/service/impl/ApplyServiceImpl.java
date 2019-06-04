package com.zl.credit.creditcore.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zl.credit.creditcore.dao.ApplyMapper;
import com.zl.credit.creditcore.service.ApplyService;

@Service
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyMapper applyMapper;
	@Override
	public List<String> qureyAllLoanType() {
		List<Integer> typeList = applyMapper.queryAllLoanType();
		List<String> list = new ArrayList<String>();
		for (Integer integer : typeList) {
			if (integer == 1) {
				list.add("个人贷");
			}else {
				list.add("企业贷");
			}
		}
		return list;
	}

	
}
