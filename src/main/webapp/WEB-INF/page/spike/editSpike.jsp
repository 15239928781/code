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
	<input type="hidden" value="${spike.spId}" name="spId">
	<input type="hidden" value="${spike.pOldprice}" name="pOldprice">
	<input type="hidden" value="${spike.spStatus}" name="spStatus">
	<input type="hidden" value="${spike.pImage}" name="pImage">
	<input type="hidden" value="${spike.pDesc}" name="pDesc">
	<input type="hidden" value="${spike.spNum}" name="spNum">
	<div class="layui-form-item">
		<label class="layui-form-label">商品名</label>
		<div class="layui-input-block">
			<select name="pId" lay-search id="pId">
				<option value="-1"></option>
				<c:forEach items="${list }" var="product">
					<option value="${product.pId }" <c:if test="${product.pId==spike.pId }">selected='selected'</c:if>>${product.pName }</option>
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
				   lay-verify="required" placeholder="请输入拼团价" name="aNowprice" value="${spike.pNowprice}">
		</div>
	</div>


	<div class="layui-form-item">
		<label class="layui-form-label">活动时间</label>
		<div class="layui-inline" style="width: 32%;float: left;">
			<input type="text" id="createTimeStart"
				   class="layui-input userName" name="pCreatetime"
				   placeholder="活动时间(开始)" value="${spike.pCreatetime}">
		</div>
		<div class="layui-inline" style="width: 32%;float: right;">
			<input type="text" id="createTimeEnd" class="layui-input userName"
				   name="pEndtime" placeholder="活动时间(结束)" value="${spike.pEndtime}">
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block" >
			<button class="layui-btn" lay-submit="" lay-filter="editCarousel">立即提交</button>
		</div>
	</div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/page/spike/editSpike.js"></script>

<script type="text/javascript">

</script>
</body>
</html>