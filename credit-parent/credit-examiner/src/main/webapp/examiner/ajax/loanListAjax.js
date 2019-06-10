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
	$("#startTime,#endTime").datepick({dateFormat:"yy-mm-dd"});
		
	/**放款**/
    $("a.fangLoan").fancybox({
    	'width' : 750,
        'height' : 630,
        'type' : 'iframe',
        'hideOnOverlayClick' : false,
        'showCloseButton' : true,
        'onClosed' : function() { 
        	location.href = 'loan_list.html';
        }
	});
	/**删除*/
	$(".del").click(function(){
   	if(confirm("确定删除?")){
   		location.href="";
		};		
	});

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
					//alert(rs.list[i]);
					var repay = rs.list;
					var tabHtml = '';
					for ( var i in repay) {
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
						//审核状态
						if(repay[i].repay_status == 1){
							repay[i].repay_status = '审核通过';
						}
						//审核时间（'yyyy-MM-dd HH:mm:ss'）
						var repayDate = getMyDate(repay[i].repay_date) ;
   						//alert(commonTime);
					
					tabHtml += '<tr><td>'+repay[i].apply.loan_type+'</td>'+
						'<td>'+repay[i].loan_order+'</td>'+
						'<td>'+repay[i].apply.userinfo.realname+'</td>'+
						'<td>'+repay[i].apply.loan_money.toFixed(2)+'</td>'+
						'<td id="repayDate">'+repayDate+'</td><td>'+repay[i].apply.repay_method+'</td>'+
						'<td>'+repay[i].repay_status+'</td><td>'+
						'<a href="fangLoan.html" class="fangLoan">放款</a>'+
						'<a href="" class="del">删除</a></td></tr>';
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
	var cuetomerVal = $("#customer").val();
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
			data:{customer:cuetomerVal,loanOrder:loanOrderVal,startTime:startTimeVal,endTime:endTimeVal,state:stateVal},
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
            data: {pageIndex:pageIndex,pageSize:pageSize,customer:cuetomerVal,loanOrder:loanOrderVal,startTime:startTimeVal,endTime:endTimeVal},
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
					//审核状态
					if(repay[i].repay_status == 1){
						repay[i].repay_status = '审核通过';
					}
					//贷款时间（'yyyy-MM-dd HH:mm:ss'）
					var repayDate = getMyDate(repay[i].repay_date) ;
					//alert(commonTime);
				tabHtml += '<tr><td>'+repay[i].apply.loan_type+'</td>'+
					'<td>'+repay[i].loan_order+'</td>'+
					'<td>'+repay[i].apply.userinfo.realname+'</td>'+
					'<td>'+repay[i].apply.loan_money.toFixed(2)+'</td>'+
					'<td id="repayDate">'+repayDate+'</td><td>'+repay[i].apply.repay_method+'</td>'+
					'<td>'+repay[i].repay_status+'</td><td>'+
					'<a href="fangLoan.html" class="fangLoan">放款</a>'+
					'<a href="" class="del">删除</a></td></tr>';
				}
			$("#tabBody").append(tabHtml);
            }
       })
	}
}
