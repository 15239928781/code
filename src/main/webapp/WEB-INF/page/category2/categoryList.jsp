<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>管理员列表</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${ctx}/css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="${ctx}/css/list.css" media="all" />
	<script>  
        <%--JS gloable varilible--%>
        var ctx = "${ctx}";  
    </script>  
<style type="text/css">
</style>
</head>
<body class="childrenBody">
	<input type="hidden" id="adminId" value="<shiro:principal property='id'/>"/>

	<blockquote class="layui-elem-quote list_search">
		<shiro:hasPermission name="sys:category2:save">
			<div class="layui-inline">
				<a class="layui-btn layui-btn-normal carouselAdd_btn" ><i class="layui-icon">&#xe608;</i>添加二级分类</a>
			</div>
		</shiro:hasPermission>

		<div class="layui-inline">
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
	</blockquote>
	<!-- 数据表格 -->
	<table id="carouselList" lay-filter="test"></table>
	<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx}/page/category2/categoryList.js"></script>
	<script type="text/html" id="barEdit">
		<shiro:hasPermission name="sys:category2:update">
  			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="sys:category2:delete">
  			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</shiro:hasPermission>
	</script>
	<script type="text/html" id="statusTpl">
		<input type="checkbox" name="cId" value="{{d.cId}}" title="展示" lay-filter="lockStatus" {{ d.cIsshow == 1 ? 'checked' : '' }}>
	</script>
	<style>
	.layui-table-cell{
	    height:36px;
	    line-height: 36px;
	}
	</style>
</body>
</html>