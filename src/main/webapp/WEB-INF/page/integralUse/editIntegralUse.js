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
		

 	form.on("submit(editIntegralUse)",function(data){
 		//弹出loading
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
 		console.log(data.field)
 		var msg;
 		$.ajax({
    		type: "post",
            url: ctx+"/integralUse/update",
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
            /*layer.msg(msg);*/
            layer.closeAll("iframe");

            //刷新父页面
            location.reload();
        },2000);
 		return false;
 	})
	
})