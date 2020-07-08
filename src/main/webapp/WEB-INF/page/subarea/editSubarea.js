var $;
var $form;
var form;
layui.config({
	base : "js/"
}).use(['form','layer','jquery','upload'],function(){
	var layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,upload = layui.upload;
		$ = layui.jquery;
		form = layui.form;
    /*$("#sbName").blur(function(){
        $.ajax({
            type: "post",
            url: ctx+"/subarea/checkSubareaByleName?sbName="+$("#sbName").val(),
            success:function(data){
                if(data.code!=0){
                    top.layer.msg(data.msg);
                    $("#sbName").val("");
                    $("#sbName").focus();
                }
            }
        });
    });
*/
 	form.on("submit(editSubarea)",function(data){
 		//弹出loading
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
 		console.log(data.field)
 		var msg;
 		$.ajax({
    		type: "post",
            url: ctx+"/subarea/update",
            data:data.field,
			dataType:"json",
			success:function(d){
				if(d.code==0){
		        	msg="更新成功！";
				}else{
		        	msg=d.msg;
				}
			}
        });
 		setTimeout(function(){
 			top.layer.close(index);
 			top.layer.msg(msg);
 			layer.closeAll("iframe");
 			//刷新父页面
	 		parent.location.reload();
        },2000);
 		return false;
 	})
	
})