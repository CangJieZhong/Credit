$(function() {
	gainuser();
	//获取登录用户名 
	function gainuser(){
		$.ajax({
			url:"/gainUser",
			type:"POST",
			async: false,
			data:'',
			dataType:"json",
			success:function(rs){
				if(rs.username == null){
					location.href="http://localhost:8090/login/login.html";
				}else{					
//				alert(rs.username);
					$("#userName").text(rs.username);
				}
			}
		});
	}
})