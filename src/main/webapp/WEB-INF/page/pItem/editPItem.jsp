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
	<input type="hidden" name="iId" value="${productItem.iId}">
	<input type="hidden" name="pId" value="${productItem.pId}">
	<input type="hidden" name="iTime" value="${productItem.iTime}">


	<div class="layui-form-item">
		<label class="layui-form-label">章节名称</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input userName"
				   lay-verify="required" placeholder="请输入章节名称" name="iName" value="${productItem.iName}"/>
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">课程描述</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input userName"
				   lay-verify="required" placeholder="请输入课程描述" name="iDesc" value="${productItem.iDesc}">
		</div>
	</div>

	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit="" lay-filter="editCarousel">立即提交</button>
		</div>
	</div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/page/pItem/editPItem.js"></script>
</body>
</html>