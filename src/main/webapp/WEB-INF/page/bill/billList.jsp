<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
	media="all" />
<link rel="stylesheet" href="${ctx }/css/list.css" media="all" />
<script>
	var ctx = "${ctx}";
</script>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search">
		<form class="layui-form">
			<div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" id="id" value="" placeholder="团单id"
							class="layui-input search_input">
					</div>
					<div class="layui-inline">
						<input type="text" id="gCreatetime"
							   class="layui-input userName" name="gCreatetime"
							   placeholder="发起拼团时间(开始)" value="">
					</div>
					<div class="layui-inline">
						<input type="text" id="gEndtime" class="layui-input userName"
							   name="gEndtime" placeholder="拼团时间(结束)" value="">
					</div>
					<a class="layui-btn search_btn" lay-submit="" data-type="search"
					   lay-filter="search">查询</a>
				</div>
			</div>
			<%--<div style="margin-top: 1%">
				<div class="layui-inline">
					<input type="text" id="gCreatetime"
						class="layui-input userName" name="gCreatetime"
						placeholder="注册时间(开始)" value="">
				</div>
				<div class="layui-inline">
					<input type="text" id="gEndtime" class="layui-input userName"
						name="gEndtime" placeholder="注册时间(结束)" value="">
				</div>
				<a class="layui-btn search_btn" lay-submit="" data-type="search"
					lay-filter="search">查询</a>
				&lt;%&ndash;<shiro:hasPermission name="user:user:save">
					<div class="layui-inline">
						<a class="layui-btn layui-btn-normal userAdd_btn">添加用户</a>
					</div>
				</shiro:hasPermission>&ndash;%&gt;
				<shiro:hasPermission name="users:users:delete">
					<div class="layui-inline">
						<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
					</div>
				</shiro:hasPermission>
				<div class="layui-inline">（支持模糊查询）</div>
			</div>--%>
	</blockquote>
	</form>
	<div class="layui-form">
		<table id="userList" lay-filter="userList"></table>
	</div>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/html" id="barEdit">
  		<shiro:hasPermission name="users:users:delete">
  			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</shiro:hasPermission>
	</script>
	<script type="text/html" id="status">
 		 {{#  if(d.status === 0){ }}
   		 <span style="color: #F581B1;">待成团</span>
  		{{#  } else if(d.status === 1){ }}
		 拼团中
		 {{#  } else if(d.status === 2){ }}
		 拼团成功
		{{#  } else{ }}
		 拼团失败
  		{{#  } }}
	</script>
	<script type="text/html" id="statusTpl">
 		<%-- {{#  if(d.status === '0'){ }}
   		 <span style="color: #FFB800;">未激活</span>
  		{{#  } else if(d.status === '1'){ }}
			<span style="color: #01AAED;">正常</span>
		{{#  } else{ }}
   		 	<span style="color: #FF5722;">禁用</span>
  		{{#  } }}--%>
	</script>
	<script>
		layui
				.config({
					base : "js/"
				})
				.use(
						[ 'form', 'layer', 'jquery', 'table', 'laydate' ],
						function() {
							var form = layui.form, table = layui.table, layer = parent.layer === undefined ? layui.layer
									: parent.layer, laydate = layui.laydate
									$ = layui.jquery,
									nowTime = new Date().valueOf(),
									max = null,
									active = {
										search : function() {
											var id = $('#id');
													gCreatetime = $("#gCreatetime"),
													gEndtime = $("#gEndtime");
											//执行重载
											table
													.reload(
															'userList',
															{
																page : {
																	curr : 1
																//重新从第 1 页开始
																},
																where : {
																	//key: {
																	id : id
																			.val(),
																	gCreatetime : gCreatetime
																			.val(),
																	gEndtime : gEndtime
																			.val()
																//}
																}
															});
										}
									};

							var start = laydate.render({
								elem : '#gCreatetime',
								type : 'datetime',
								max : nowTime,
								btns : [ 'clear', 'confirm' ],
								done : function(value, date) {
									endMax = end.config.max;
									end.config.min = date;
									end.config.min.month = date.month - 1;
								}
							});
							var end = laydate.render({
								elem : '#gEndtime',
								type : 'datetime',
								max : nowTime,
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

							//加载页面数据
							table
									.render({
										id : 'userList',
										elem : '#userList',
										url : ctx + '/sys/getBillList' //数据接口
										,
										limit : 10//每页默认数
										,
										limits : [ 10, 20, 30, 40 ],
										cols : [ [ //表头
												{
													type : 'checkbox'
												},
												{
													field : 'id',
													title : '团单ID'
												},
												{
													field : 'pId',
													title : '商品id',
													width : 120
												},
												{
													field : 'pName',
													title : '商品名称'
												},
												{
													field : 'aValidity',
													title : '购买数量'
												},
												{
													field : 'gCreatetime',
													title : '发起拼团时间',
												},
												{
													field : 'gEndtime',
													title : '拼团结束时间'
												},
												{
													field : 'aMember',
													title : '成团人数'
												},

												{
													field : 'aCanjia',
													title : '参团人数'
												},
												{
													field : 'status',
													title : '拼团状态',
													toolbar:'#status'
												}, ] ],
										page : true
										,where: {timestamp: (new Date()).valueOf()}
									//开启分页
									});

							//监听工具条
							table.on('tool(userList)', function(obj) {
								var data = obj.data;
								console.log(data)
								if (obj.event === 'del') {
									layer.confirm('真的删除行么', function(index) {
										$.ajax({
											url : ctx + '/users/delUsersByUid/'
													+ data.uId,
											type : "get",
											success : function(d) {
												if (d.code == 0) {
													obj.del();
                                                    layer.msg("删除成功！", {
                                                        icon : 1
                                                    });
												} else {
													layer.msg("权限不足！", {
														icon : 5
													});
												}
											}
										})
										layer.close(index);
									});
								}

							});

							//查询
							$(".search_btn").click(function() {
								var type = $(this).data('type');
								active[type] ? active[type].call(this) : '';
							})



							//批量删除
							$(".batchDel")
									.click(
											function() {
												var checkStatus = table
														.checkStatus('userList'), data = checkStatus.data, userStr = '';
												if (data.length > 0) {
													$.each(data, function(n,
															value) {
													    console.log(value)
														userStr += value.uId
																+ ',';
													});
													userStr = userStr
															.substring(
																	0,
																	userStr.length - 1);
													layer
															.confirm(
																	'确定删除<strong>'
																			+ data.length
																			+ '</strong>条数据吗？',
																	function(
																			index) {
																		//调用删除接口
																		$
																				.ajax({
																					url : ctx
																							+ '/users/delUser/'
																							+ userStr,//接口地址
																					type : "get",
																					success : function(
																							d) {
																						if (d.code == 0) {
																							//删除成功，刷新父页面
																							parent.location
																									.reload();
                                                                                            layer.msg("删除成功！", {
                                                                                                icon : 1
                                                                                            });
																						} else {
																							layer
																									.msg(
																											"权限不足，联系超管！",
																											{
																												icon : 5
																											});
																						}
																					}
																				})
																	});
												} else {
													layer.msg("请选择需要删除的用户");
												}
											})

						})

	</script>
</body>
</html>