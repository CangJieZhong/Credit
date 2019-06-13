//补0操作  
function getzf(num) {
	if (parseInt(num) < 10) {
		num = '0' + num;
	}
	return num;
}
// 毫秒值转换为时间（'yyyy-MM-dd）
// 获得年月日 得到日期oTime
function getMyDate(str) {
	var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
			.getMonth() + 1, oDay = oDate.getDate(),
	// 最后拼接时间
	oTime = oYear + '-' + getzf(oMonth) + '-' + getzf(oDay);
	return oTime;
};
/* 还款模态框 */
function returnLoan(repayid) {
	// alert(loanOrder);
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "/repayRecords",
		async : false,
		data : {
			repayid : repayid
		},
		success : function(rs) {
//			alert(rs.loan_order)
				var loanType = rs.apply.loan_type;
				if (loanType == 1) {
					loanType = "个人贷";
				} else {
					loanType = "企业贷";
				}
				var repayType = rs.apply.repay_method;
				if (repayType == 1) {
					repayType = "6+12套餐";
				} else if (repayType == 2) {
					repayType = "9+12套餐";
				} else {
					repayType = "11+1套餐";
				}
				var repayState = rs.repay_status;
				if (repayState == 0) {
					repayState = "未还款";
				} else if (repayState == 1) {
					repayState = "当前已还款";
				} else {
					repayState = "已全部还款";
				}

				$("#loanType").val(loanType);
				$("#loanId").val(rs.loan_order);
				$("#loanName").val(rs.apply.userinfo.realname);
				$("#phone").val(rs.apply.userinfo.phone_number);
				$("#loanMoney").val(rs.apply.loan_money.toFixed(2));
				$("#returnMoney").val(rs.repay_money.toFixed(2));
				$("#returnTime").val(getMyDate(rs.repay_date));
				$("#repayType").val(repayType);
				$("#returnState").val(repayState);
				$("#hid").val(rs.repay_id);
		}
	});
}
/* 还款删除操作 */
function repayDel(repayId) {
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "/repayDelete",
		async : false,
		data : {
			repayId : repayId
		},
		success : function(rs) {
			if (rs.success) {
				alert("删除成功!");
				location.reload();
			}
		}
	})
}
/* 更新评价 */
function credit(){
	var grades = $("#credit").val();
	var name = $("#loanName").val();
	var repayid = $("#hid").val();
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "/credit",
		async : false,
		data : {
			grades : grades,
			name : name,
			repayid : repayid
		},	
		success : function(rs) {
			if (rs.success) {
				alert("评价成功!");
				location.reload();
			}
		}
	})
}