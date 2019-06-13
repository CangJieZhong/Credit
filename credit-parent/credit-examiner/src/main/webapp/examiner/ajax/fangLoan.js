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
	var oDate = new Date(str), 
	oYear = oDate.getFullYear(), 
	oMonth = oDate.getMonth() + 1, 
	oDay = oDate.getDate(),
	// 最后拼接时间
	oTime = oYear + '-' + getzf(oMonth) + '-' + getzf(oDay);
	return oTime;
};
/* 放款模态框*/
function fangLoan(loanOrder) {
	// alert(loanOrder);
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "/aLoanRecord",
		async : false,
		data : {
			loanOrder : loanOrder
		},
		success : function(rs) {
			// alert(rs.loan_order);
			var loanType = rs.loan_type;
			if (loanType == 1) {
				loanType = "个人贷";
			} else {
				loanType = "企业贷";
			}
			var repayType = rs.repay_method;
			if (repayType == 1) {
				repayType = "6+12套餐";
			} else if (repayType == 2) {
				repayType = "9+12套餐";
			} else {
				repayType = "11+1套餐";
			}
			$("#loanType").val(loanType);
			$("#loanId").val(rs.loan_order);
			$("#loanName").val(rs.userinfo.realname);
			$("#birthday").val(getMyDate(rs.userinfo.birthday));
			$("#idCard").val(rs.userinfo.idcard);
			$("#phone").val(rs.userinfo.phone_number);
			$("#bankCard").val(rs.userinfo.bank_card);
			$("#job").val(rs.userinfo.occ);
			$("#repayType").val(repayType);
			$("#loanMoney").val(rs.loan_money.toFixed(2));
			$("#nowAddr").val(rs.userinfo.now_address);
			$("#huKouAddr").val(rs.userinfo.address);
			$("#company").val(rs.userinfo.company);
			$("#companyAddr").val(rs.userinfo.company_address);
		}
	});
}
/* 放款删除操作*/
function loanDel(loanOrder) {
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "/loanDelete",
		async : false,
		data : {
			loanOrder : loanOrder
		},
		success : function(rs) {
			// alert(rs.success);
			if (rs.success) {
				alert("删除成功!");
				location.reload();
			}
		}
	})
	
	
}

/* 放款操作*/
function sendLoan() {
	var loanMoney = $("#loanMoney").val();
	var repayType = $("#repayType").val();
	var bankCard = $("#bankCard").val();
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "/sendLoans",
		async : false,
		data : {
			loanMoney : loanMoney,
			repayType: repayType,
			bankCard: bankCard
		},
		success : function(rs) {
			if (rs.success) {
				alert("放款成功!");
				location.reload();
				
			}
		}
	})
	
	
}
