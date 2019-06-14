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
/* 审核模态框*/
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
//			alert(rs.loan_type);
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
			
			$("#customerType").val(loanType);
			$("#loanId").val(rs.loan_order);
			$("#loanName").val(rs.userinfo.realname);
			$("#birthday").val(getMyDate(rs.userinfo.birthday));
			$("#uploadImg1").attr("src",rs.userinfo.img_on);
			$("#uploadImg3").attr("src",rs.userinfo.img_down);
			$("#phone").val(rs.userinfo.phone_number);
			$("#bankCard").val(rs.userinfo.bank_card);
			$("#occ").val(rs.userinfo.occ);
			$("#fenQiType").val(repayType);
			$("#loanPurpose").val(rs.loan_purpose);
			$("#loanMoney").val(rs.loan_money.toFixed(2));
			$("#nowAddr").val(rs.userinfo.now_address);
			$("#huKouAddr").val(rs.userinfo.address);
			$("#company").val(rs.userinfo.company);
			$("#companyAddr").val(rs.userinfo.company_address);
			$("#creditRecord").val(rs.userinfo.credit1);
			$("#antiFraud").val(rs.userinfo.credit2);
			$("#shenHePeople1").val(rs.auditor1);
			$("#shenHePeople2").val(rs.auditor2);
			$("#shenHePeople3").val(rs.auditor3);
			$("#shenHeScore1").val(rs.auditor1_msg);
			$("#shenHeScore2").val(rs.auditor2_msg);
			$("#shenHeScore3").val(rs.auditor3_msg);
			$("#shenHeDate3").val(getMyDate(rs.apply_end));
			$("#emergencyContact").val(rs.userinfo.urgent_person);
			$("#marryState").val(rs.userinfo.marital_status);
		}
	});
}


/* 审核操作*/
function sendLoan() {
	var loanId = $("#loanId").val();
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "/sendLoans",
		async : false,
		data : {
			loanId: loanId
		},
		success : function(rs) {
			if (rs.success) {
				alert("审核成功!");
				location.reload();
			}
		}
	})
}

