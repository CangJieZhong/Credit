//bootstrap组件定制    ：  单据审核 
~function(){
 var auditDialogTpl = '<div class="modal fade" data-backdrop="static">'+
	'		<div class="modal-dialog">'+
	'			<div class="modal-content">'+
	'				<div class="modal-header">'+
	'					<button type="button" class="close" data-dismiss="modal"'+
	'						aria-label="Close">'+
	'						<span aria-hidden="true">&times;</span>'+
	'					</button>'+
	'					<h4 class="modal-title">审核确认</h4>'+
	'				</div>'+
	'				<div class="modal-body"></div>'+
	'				<div class="modal-footer">'+
	'					<button data-cmd="audit" data-success="true" type="button"'+
	'						class="btn btn-primary">'+
	'						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>'+
	'						审核确认'+
	'					</button>'+
	'					<button data-cmd="audit" data-success="false" type="button"'+
	'						class="btn btn-danger">'+
	'						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>'+
	'						审核拒绝'+
	'					</button>'+
	'					<button type="button" class="btn btn-default" data-dismiss="modal">'+
	'						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>'+
	'						关闭'+
	'					</button>'+
	'				</div>'+
	'			</div>'+
	'		</div>'+
	'	</div>';
 
 	//private 打开窗口 
 	function openDialog(target){
 		var dialog = target.data("dialog");
 		if(!dialog){
 			dialog = $(auditDialogTpl);
 			dialog.appendTo(document.body);
 			
 			dialog.on("click.el.auditDialog.buttons.data-api","[data-cmd=audit]",function(){
 				var button = $(this);
 				buttonHandler(dialog,button);
 			});
 			
 			target.data("dialog",dialog);
 		}
 		dialog.find("button[data-cmd=audit]").hide();
 		
 		dialog.modal();
 		
 		loadContent(dialog,target);
 	}
 	//private 加载窗口中数据
 	function loadContent(dialog,target){
 		var url = target.data("auditurl");
		dialog.find(".modal-body").html("数据加载中,请稍后");
		dialog.find(".modal-body").load(url,function(data,status) {
			if(status=="success"){
				dialog.find("button[data-cmd=audit]").show();
			}else{
				dialog.find(".modal-body").html("数据加载失败,请稍后再试");
			}
		});
 	}
 	//private 审核按钮处理
 	function buttonHandler(dialog,button){
 			//（同意、拒绝）审核操作
			var val = button.data("success");
			dialog.find("form").ajaxSubmit({
			data : {success : val},
			success : function(data) {
				if (data.success) {
					$.messager.popup("操作成功");
					dialog.modal("hide");

					setTimeout(function() {
						location.reload();
					}, 1000);
				}
			}
		});
 	}
 	$(document).on("click.el.auditDialog.open.data-api","[data-auditurl]",function(){
 		var me = $(this);
 		openDialog(me);
 	});
}();