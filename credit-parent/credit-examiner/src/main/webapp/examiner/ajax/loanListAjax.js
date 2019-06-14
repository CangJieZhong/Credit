//补0操作  
function getzf(num){  
    if(parseInt(num) < 10){  
        num = '0'+num;  
    }  
    return num;  
}
//毫秒值转换为时间（'yyyy-MM-dd HH:mm:ss'） 
//获得年月日      得到日期oTime  
function getMyDate(str){
    var oDate = new Date(str),  
    oYear = oDate.getFullYear(),  
    oMonth = oDate.getMonth()+1,  
    oDay = oDate.getDate(),  
    oHour = oDate.getHours(),  
    oMin = oDate.getMinutes(),  
    oSen = oDate.getSeconds(),  
    //最后拼接时间  
    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);
    return oTime;  
};

$(function(){
	//日期控件
	$("#startTime,#endTime").click(function(){
			WdatePicker();
		})
		
		//分页查询
		var pageIndex = 1;
		var pageSize = 3;
		IninPage();
		getInfoList();
		function IninPage(){
			$.ajax({	
				url:"/applysLoans",
				type:"POST",
				async: false,
				data:'',
				dataType:"json",
				success:function(data){
					$("#pagination").twbsPagination({
		 				totalPages: data.pages,//总页数
		 				visiblePages : 5 , //表示页面上面最多可以显示几页 
		 				//startPage: data.pageNum,
		 				first: '首页',
						prev: '前一页',
						next: '下一页',
						last: '尾页',
						loop:false,
						href:"javascript:void(0)",
		 				onPageClick:function(event,index){
		 					pageIndex = index;
		 					//alert(pageIndex);
		 					$('#tabBody').html('');
		 					getInfoList();
		 				}
		 			})
				}
			});
		}
		//显示分页数据
		
		function getInfoList(){
			$.ajax({
				url:"/applysLoans",
				data:{pageIndex:pageIndex,pageSize:pageSize},
				type:"POST",
				dataType:"json",
				async:false,
				success:function(rs){
					//alert(rs.list[i]);
					var apply = rs.list;
					var tabHtml = '';
					for ( var i in apply) {
						//贷款类型 
						if(apply[i].loan_type == 1){
							apply[i].loan_type = '个人贷';
						}else{
							apply[i].loan_type = '企业贷';
						}
						//分期类型
						if(apply[i].repay_method == 1){
							apply[i].repay_method = '6+12套餐';
						}else if(apply[i].repay_method == 2){
							apply[i].repay_method = '9+12套餐';
						}else{
							apply[i].repay_method = '11+1套餐';
						}
						//审核状态
						if(apply[i].audit_status == 4){
							apply[i].audit_status = '已审核';
						}
						//判断放款按钮状态
						var loanBtn = "";
						if(apply[i].loanBtn_status == 1){
							loanBtn = '<button type="button" disabled class="btn btn-success">已放款</button>';
						}else{
							loanBtn = '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="fangLoan('+apply[i].loan_order+')">放款</button>';
						}
						//审核结束时间（'yyyy-MM-dd HH:mm:ss'）
						var applyEndDate = getMyDate(apply[i].apply_end) ;
					
					tabHtml += '<tr><td>'+apply[i].loan_type+'</td>'+
						'<td id="loanorder">'+apply[i].loan_order+'</td>'+
						'<td>'+apply[i].userinfo.realname+'</td>'+
						'<td>'+apply[i].loan_money.toFixed(2)+'￥</td>'+
						'<td id="applyDate">'+applyEndDate+'</td><td>'+apply[i].repay_method+'</td>'+
						'<td>'+apply[i].audit_status+'</td><td>'+loanBtn+
						'&emsp;<button type="button" class="btn btn-warning" onclick="loanDel('+apply[i].loan_order+')">删除</button></td></tr>';
					}
				$("#tabBody").append(tabHtml);
			}
		});
	}

});

function query(){
	$('#tabBody').html('');
	var pageIndex = 1;
	var pageSize = 3;
	var customerVal = $("#customer").val();
	var loanOrderVal = $("#loanOrder").val();
	var startTimeVal = $("#startTime").val();
	var endTimeVal = $("#endTime").val();
	IninPage();
	getInfoList();
	
	function IninPage(){
	$('#pagination').remove();
	$("#pagination-on").append('<ul id="pagination" class="pagination"></ul>');
		$.ajax({	
			url:"/applysLoans",
			type:"POST",
			async: false,
			data:{customer:customerVal,loanOrder:loanOrderVal,startTime:startTimeVal,endTime:endTimeVal,pageIndex:pageIndex,pageSize:pageSize},
			dataType:"json",
			success:function(data){
				$("#pagination").twbsPagination({
		 			totalPages: data.pages,//总页数
		 			visiblePages : 5 , //表示页面上面最多可以显示几页 
		 			//startPage: data.pageNum,
		 			first: '首页',
					prev: '前一页',
					next: '下一页',
					last: '尾页',
					loop:false,
					href:"javascript:void(0)",
		 			onPageClick:function(event,index){
		 				pageIndex = index;
		 				//alert(pageIndex);
		 				$('#tabBody').html('');
		 				getInfoList();
		 			}
		 		})
			}
		});
	}	
	
	function getInfoList(){
	 	$.ajax({
        	type: "POST",
            dataType: "json",
            url: "/applysLoans" ,
            async:false,
            data: {pageIndex:pageIndex,pageSize:pageSize,customer:customerVal,loanOrder:loanOrderVal,startTime:startTimeVal,endTime:endTimeVal},
            success: function (rs) {
            	var apply = rs.list;
				var tabHtml = '';
				for ( var i in apply) {
            	 	//alert(apply[i].userinfo.realname);
					//贷款类型 
					if(apply[i].loan_type == 1){
						apply[i].loan_type = '个人贷';
					}else{
						apply[i].loan_type = '企业贷';
					}
					//分期类型
					if(apply[i].repay_method == 1){
						apply[i].repay_method = '6+12套餐';
					}else if(apply[i].repay_method == 2){
						apply[i].repay_method = '9+12套餐';
					}else{
						apply[i].repay_method = '11+1套餐';
					}
					//审核状态
					if(apply[i].audit_status == 4){
						apply[i].audit_status = '已审核';
					}
					
					var loanBtn = "";
					if(apply[i].loanBtn_status == 1){
						loanBtn = '<button type="button" disabled="disabled" class="btn btn-success">已放款</button>';
					}else{
						loanBtn = '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="fangLoan('+apply[i].loan_order+')">放款</button>';
					}
					//审核结束时间（'yyyy-MM-dd HH:mm:ss'）
					var applyEndDate = getMyDate(apply[i].apply_end) ;
					//alert(commonTime);
				tabHtml += '<tr><td>'+apply[i].loan_type+'</td>'+
					'<td>'+apply[i].loan_order+'</td>'+
					'<td>'+apply[i].userinfo.realname+'</td>'+
					'<td>'+apply[i].loan_money.toFixed(2)+'￥</td>'+
					'<td>'+applyEndDate+'</td><td>'+apply[i].repay_method+'</td>'+
					'<td>'+apply[i].audit_status+'</td><td>'+loanBtn+
					'&emsp;<button type="button" class="btn btn-warning" onclick="loanDel('+apply[i].loan_order+')">删除</button></td></tr>';
				}
			$("#tabBody").append(tabHtml);
            }
       })
	}
}
