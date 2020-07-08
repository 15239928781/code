<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>添加管理员</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<script>  
        <%--JS gloable varilible--%>  
        var ctx = "${ctx}";  
    </script>  
<style type="text/css">
.layui-form-item .layui-inline {
	width: 33.333%;
	float: left;
	margin-right: 0;
}

@media ( max-width :1240px) {
	.layui-form-item .layui-inline {
		width: 100%;
		float: none;
	}
}
</style>
</head>
<body class="childrenBody">
	<form class="layui-form" style="width: 80%;" id="aaf">
	<input type="hidden" name="pId" value="${psb.pId }"/>
		<input type="hidden" name="sbid" value="${psb.sbid }"/>
		<div class="layui-form-item">
			<label class="layui-form-label">商品名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   lay-verify="required" readonly="readonly"  placeholder="请输入分区名称" id="pName" name="pName" value="${psb.pName }">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">分区名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					lay-verify="required" readonly="readonly"  placeholder="请输入分区名称" id="sbName" name="sbName" value="${psb.sbName }">
			</div>
		</div>

		<div class="layui-form-item" >
			<label class="layui-form-label">原价</label>
			<div class="layui-input-block">
				<input type="number" class="layui-input userName"
					   lay-verify="required" placeholder="请输入原价" name="psbOldprices" value="${psb.psbOldprices }">
			</div>

		</div>

		<div class="layui-form-item" >
		<label class="layui-form-label" >现价</label>
		<div class="layui-input-block" id="yuanjia2">
			<input type="number" id="psbPrices" class="layui-input userName"
				   lay-verify="required" placeholder="请输入现价" name="psbPrices" value="${psb.psbPrices }">
		</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="editSubarea">立即提交</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>

<script>

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
                url: ctx+"/subarea/updateProduct",
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
</script>

</body>
</html>