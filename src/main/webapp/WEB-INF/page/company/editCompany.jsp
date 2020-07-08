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
<form class="layui-form" style="width: 80%;" id="auf" enctype="multipart/form-data">
	<input type="hidden" value="${company.id}" name="id">




	<div class="layui-form-item">
		<label class="layui-form-label">公司简介</label>
		<div class="layui-input-block">
			<script type="text/javascript" src="${ctx}/js/kindeditor/kindeditor-min.js"></script>
			<script type="text/javascript" src="${ctx}/js/kindeditor/kindeditor.js"></script>
			<script type="text/javascript" src="${ctx}/js/kindeditor/lang/zh_CN.js"></script>
			<script type="text/javascript" src="${ctx}/js/kindeditor/plugins/code/prettify.js"></script>
			<script>

                KindEditor.ready(function(K) {
                    K.create('#editor_id', {
                        uploadJson : '${ctx}/sys/upload_json_company',
                        fileManagerJson :  '${ctx}/sys/file_manager_json_company',
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
                        },
                        afterBlur: function(){this.sync();}
                    });
                });
			</script>
			<!-- /KindEditor -->
			<textarea id="editor_id" name="companyDesc" style="width:800px;height:600px;" class="textArea">${company.companyDesc}</textarea>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit="" lay-filter="addCarousel">立即提交</button>
		</div>
	</div>
</form>

<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/page/company/editCompany.js"></script>
<script type="text/javascript">
	function selectClick() {
	    console.log("aaa")
	    var cId = $('#cId option:selected');


    }
</script>
</body>
</html>