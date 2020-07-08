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
	<link rel="stylesheet" href="${ctx }/js/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="${ctx }/js/kindeditor/plugins/code/prettify.css" />
<script>  
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
	<form class="layui-form" style="width: 80%;" id="auf" enctype="multipart/form-data">
		<div class="layui-form-item">
			<label class="layui-form-label">登陆邮箱</label>
			<div class="layui-input-block">
				<input type="text" id="eMail" name="eMail" class="layui-input userName"
					lay-verify="email" placeholder="请输入邮箱" value="">
				<label><span style="color: red">(激活账号、找回密码必须！)</span></label>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">昵称</label>
			<div class="layui-input-block">
				<input type="text" id="nickname" class="layui-input userName"
					lay-verify="required" placeholder="请输入昵称" name="nickname" value="">
					<!-- <label><span style="color: red">(谨慎设置，暂时不支持修改！)</span></label> -->
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input type="password" id="password" class="layui-input userName"
					lay-verify="pass" placeholder="请输入密码" name="password" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-block">
				<input type="password" class="layui-input userName"
					lay-verify="repass" placeholder="请输入确认密码" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<input type="radio" name="sex" value="1" title="男" checked>
				<input type="radio" name="sex" value="0" title="女"> <input
					type="radio" name="sex" value="2" title="保密">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">出生日期</label>
			<div class="layui-input-block">
				<input type="text" id="birthday" class="layui-input userName"
					name="birthday" lay-verify="required" placeholder="请输入出生日期">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">地址</label>
			<div class="layui-input-block">
				<input type="text" name="address" class="layui-input userName" lay-verify="required" placeholder="请输入地址" value="">
			</div>
		</div> 
		<div class="layui-form-item">
			<label class="layui-form-label">手机号</label>
			<div class="layui-input-block">
				<input type="text" name="phone" class="layui-input userName"
					lay-verify="phone" placeholder="请输入手机号" value="">
			</div>
		</div>

		<%--<div class="layui-form-item">
			<label class="layui-form-label">手机号</label>
			<div class="layui-input-block">
				<script type="text/javascript" src="${ctx}/js/kindeditor/kindeditor-min.js"></script>
				<script type="text/javascript" src="${ctx}/js/kindeditor/kindeditor.js"></script>
				<script type="text/javascript" src="${ctx}/js/kindeditor/lang/zh_CN.js"></script>
				<script type="text/javascript" src="${ctx}/js/kindeditor/plugins/code/prettify.js"></script>
				<script>

                    KindEditor.ready(function(K) {
                        K.create('#editor_id', {
                            uploadJson : 'upload_json',
                            fileManagerJson :  'file_manager_json',
                            cssData: '.ke-content img {max-width: 300px;height:auto;}',
                            allowFileManager : true,
                            allowImageUpload : true,
                            afterUpload : function(url, data, name) { //上传文件后执行的回调函数，必须为3个参数
                                if(name=="pImage" || name=="multiimage"){ //单个和批量上传图片时
                                    var img = new Image(); img.src = "http://pc-20180613wutp:8080/"+url;
                                    img.onload = function(){ //图片必须加载完成才能获取尺寸
                                        if(img.width>600) KE.html(KE.html().replace('<img src="'+ 'http://pc-20180613wutp:8080/'+ + url + '"','<img src="'+ 'http://pc-20180613wutp:8080/'+ + url + '" width="300" height="146"'))
                                    }
                                }
                            }
                        });
                    });
				</script>
				<!-- /KindEditor -->
				<textarea id="editor_id" name="pDesc" style="width:800px;height:600px;" class="textArea"></textarea>
			</div>--%>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addUser">立即提交</button>
			</div>
		</div>
	</form>

	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/page/user/addUser.js"></script>

</body>
</html>