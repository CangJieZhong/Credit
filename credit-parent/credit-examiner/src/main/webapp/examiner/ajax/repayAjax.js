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
		function IninPage(){
			$.ajax({	
				url:"/returnLoans",
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
		getInfoList();
		function getInfoList(){
			$.ajax({
				url:"/returnLoans",
				data:{pageIndex:pageIndex,pageSize:pageSize},
				type:"POST",
				dataType:"json",
				async:false,
				success:function(rs){
					var repay = rs.list;
					var tabHtml = '';
					for ( var i in repay) {
//						alert(repay[i].credit_status);
						//贷款类型 
						if(repay[i].apply.loan_type == 1){
							repay[i].apply.loan_type = '个人贷';
						}else{
							repay[i].apply.loan_type = '企业贷';
						}
						
						//分期类型 
						if(repay[i].apply.repay_method == 1){
							repay[i].apply.repay_method = '6+12套餐';
						}else if(repay[i].apply.repay_method == 2){
							repay[i].apply.repay_method = '9+12套餐';
						}else{
							repay[i].apply.repay_method = '11+1套餐';
						}
						//还款状态
						if(repay[i].repay_status == 0){
							repay[i].repay_status = '未还款';
						}else if(repay[i].repay_status == 1){
							repay[i].repay_status = '当前已还款';
						}else{
							repay[i].repay_status = '已全部还款';
						}
						var creditBtn = '';
						if(repay[i].credit_status == 1){
							creditBtn = '<button type="button" disabled class="btn btn-success">已评价</button>'
						}else{
							creditBtn = '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="returnLoan('+repay[i].repay_id+')">评&nbsp;&nbsp;&nbsp;价</button>'
						}
						//还款时间（'yyyy-MM-dd HH:mm:ss'）
						var repayDate = getMyDate(repay[i].repay_date) ;
   						//alert(commonTime);
					
					tabHtml += '<tr><td>'+repay[i].apply.loan_type+'</td>'+
						'<td>'+repay[i].loan_order+'</td>'+
						'<td>'+repay[i].apply.userinfo.realname+'</td>'+
						'<td>'+repay[i].apply.loan_money.toFixed(2)+'￥</td>'+
						'<td>'+repay[i].repay_money.toFixed(2)+'￥</td>'+
						'<td>'+(repay[i].apply.loan_money-repay[i].repay_money).toFixed(2)+'￥</td>'+
						'<td id="repayDate">'+repayDate+'</td><td>'+repay[i].apply.repay_method+'</td>'+
						'<td>'+repay[i].repay_status+'</td><td>'+creditBtn+
						'&emsp;<button type="button" class="btn btn-warning" onclick="repayDel('+repay[i].repay_id+')">删&nbsp;&nbsp;除</button></td></tr>';
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
	var stateVal = $("#state").val(); 
	IninPage();
	
	function IninPage(){
		$('#pagination').remove();
		$("#pagination-on").append('<ul id="pagination" class="pagination"></ul>');
		$.ajax({	
			url:"/returnLoans",
			type:"POST",
			async: false,
			data:{customer:customerVal,loanOrder:loanOrderVal,startTime:startTimeVal,endTime:endTimeVal,state:stateVal},
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
	
	getInfoList();
	function getInfoList(){
	 	$.ajax({
        	type: "POST",
            dataType: "json",
            url: "/returnLoans" ,
            async:false,
            data: {pageIndex:pageIndex,pageSize:pageSize,customer:customerVal,loanOrder:loanOrderVal,startTime:startTimeVal,endTime:endTimeVal,state:stateVal},
            success: function (rs) {
            	var repay = rs.list;
				var tabHtml = '';
				for ( var i in repay) {
            	 	//alert(repay[i].apply.userinfo.realname);
					//贷款类型 
					if(repay[i].apply.loan_type == 1){
						repay[i].apply.loan_type = '个人贷';
					}else{
						repay[i].apply.loan_type = '企业贷';
					}
					//分期类型
					if(repay[i].apply.repay_method == 1){
						repay[i].apply.repay_method = '6+12套餐';
					}else if(repay[i].apply.repay_method == 2){
						repay[i].apply.repay_method = '9+12套餐';
					}else{
						repay[i].apply.repay_method = '11+1套餐';
					}
					//还款状态
					if(repay[i].repay_status == 0){
						repay[i].repay_status = '未还款';
					}else{
						repay[i].repay_status = '已还款';
					}
					
					var creditBtn = '';
					if(repay[i].credit_status == 1){
						creditBtn = '<button type="button" disabled class="btn btn-success">已评价</button>'
					}else{
						creditBtn = '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="returnLoan('+repay[i].repay_id+')">评&nbsp;&nbsp;&nbsp;价</button>'
					}
					//还款时间（'yyyy-MM-dd HH:mm:ss'）
					var repayDate = getMyDate(repay[i].repay_date) ;
					//alert(commonTime);
				tabHtml += '<tr><td>'+repay[i].apply.loan_type+'</td>'+
					'<td>'+repay[i].loan_order+'</td>'+
					'<td>'+repay[i].apply.userinfo.realname+'</td>'+
					'<td>'+repay[i].apply.loan_money.toFixed(2)+'￥</td>'+
					'<td>'+repay[i].repay_money.toFixed(2)+'￥</td>'+
					'<td>'+(repay[i].apply.loan_money-repay[i].repay_money).toFixed(2)+'￥</td>'+
					'<td id="repayDate">'+repayDate+'</td><td>'+repay[i].apply.repay_method+'</td>'+
					'<td>'+repay[i].repay_status+'</td><td>'+creditBtn+
					'&emsp;<button type="button" class="btn btn-warning" onclick="repayDel('+repay[i].repay_id+')">删&nbsp;&nbsp;除</button></td></tr>';
				}
			$("#tabBody").append(tabHtml);
            }
       })
	}
}