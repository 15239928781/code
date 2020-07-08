var $;
var $form;
var form;
layui.config({
	base : "js/"
}).use(['form','layer','jquery','upload','laydate'],function(){
	var layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,upload = layui.upload,laydate = layui.laydate,nowTime = new Date().valueOf();
		$ = layui.jquery;
		form = layui.form;
    var start = laydate.render({
        elem : '#createTimeStart',
        type : 'datetime',
        // max : nowTime,
        btns : [ 'clear', 'confirm' ],
        done : function(value, date) {
            endMax = end.config.max;
            end.config.min = date;
            end.config.min.month = date.month - 1;
        }
    });
    var end = laydate.render({
        elem : '#createTimeEnd',
        type : 'datetime',
        // max : nowTime,
        done : function(value, date) {
            if ($.trim(value) == '') {
                var curDate = new Date();
                date = {
                    'date' : curDate.getDate(),
                    'month' : curDate.getMonth() + 1,
                    'year' : curDate.getFullYear()
                };
            }
            start.config.max = date;
            start.config.max.month = date.month - 1;
        }
    })
 	form.on("submit(editCarousel)",function(data){
 		//弹出loading
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
 		var msg;
 		$.ajax({
    		type: "post",
            url: ctx+"/sys/updGroup",
            data:data.field,
			dataType:"json",
			success:function(d){
				if(d.code==0){
		        	msg="更新成功！请刷新";
				}else{
		        	msg=d.msg;
				}
			}
        });
 		setTimeout(function(){
 			top.layer.close(index);
 			top.layer.msg(msg);
            layer.msg(msg);
 			layer.closeAll("iframe");
 			//刷新父页面
	 		parent.location.reload();
        },2000);
 		return false;
 	})
	
})