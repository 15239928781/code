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
		<div class="layui-form-item">
			<label class="layui-form-label">商品名</label>
			<div class="layui-input-block">
				<select name="pId" lay-search id="pId">
					<option value="-1"></option>
					<c:forEach items="${list }" var="product">
						<option value="${product.pId }" >${product.pName }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<%--<div class="layui-form-item">
			<label class="layui-form-label">商品原价</label>
			<div class="layui-input-block">
				<input type="text" id="aOldprice" name="aOldprice" class="layui-input userName"
					   lay-verify="" placeholder="请输商品原" value="" disabled>
			</div>
		</div>--%>

		<div class="layui-form-item">
			<label class="layui-form-label">拼团价</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName"
					   lay-verify="required" placeholder="请输入拼团价" name="aNowprice" value="">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">活动时间</label>
			<div class="layui-inline" style="width: 32%;float: left;">
				<input type="text" id="createTimeStart"
					   class="layui-input userName" name="pCreatetime"
					   placeholder="活动时间(开始)" value="">
			</div>
			<div class="layui-inline" style="width: 32%;float: right;">
				<input type="text" id="createTimeEnd" class="layui-input userName"
					   name="pEndtime" placeholder="活动时间(结束)" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">成团有效时间(小时)</label>
			<div class="layui-input-block">
				<input type="number" class="layui-input userName"
					   lay-verify="number" placeholder="请输入成团有效时间" name="pValidity" value="">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">成团人数</label>
			<div class="layui-input-block">
				<input type="number" class="layui-input userName"
					   lay-verify="number" placeholder="请输入成团人数" name="pMember" value="">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">每人限购</label>
			<div class="layui-input-block">
				<input type="number" class="layui-input userName"
					   lay-verify="number" placeholder="请输入每人限购" name="aMaxnum" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block" >
				<button class="layui-btn" lay-submit="" lay-filter="addCarousel">立即提交</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/page/group/addGroup.js"></script>

<script type="text/javascript">

</script>
</body>
</html>