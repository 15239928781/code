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
						<input type="text" id="phone" value="" placeholder="请输入手机号"
							class="layui-input search_input">
					</div>
					<div class="layui-input-inline layui-form lay-search">
						<select name="oState" lay-search class="lay-search" id="oState">
							<option value="-1">请选择订单状态</option>
							<option value="1">待付款</option>
							<option value="2">待发货</option>
							<option value="3">待收货</option>
							<option value="4">已完成</option>
						</select>
					</div>
				</div>
			</div>
			<div style="margin-top: 1%">
				<div class="layui-inline">
					<input type="text" id="createTimeStart"
						class="layui-input userName" name="createTimeStart"
						placeholder="订单时间(开始)" value="">
				</div>
				<div class="layui-inline">
					<input type="text" id="createTimeEnd" class="layui-input userName"
						name="createTimeEnd" placeholder="订单时间(结束)" value="">
				</div>
				<a class="layui-btn search_btn" lay-submit="" data-type="search"
					lay-filter="search">查询</a>

				<shiro:hasPermission name="sys:order:delete">
					<div class="layui-inline">
						<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
					</div>
				</shiro:hasPermission>
				<div class="layui-inline">（支持模糊查询）</div>
			</div>
		</form>
	</blockquote>
	<div class="layui-form">
		<table id="userList" lay-filter="userList"></table>
	</div>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/html" id="barEdit">
  		<shiro:hasPermission name="sys:order:delete">
  			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</shiro:hasPermission>
	</script>
	<script type="text/html" id="orderitem">
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit" style="background-color: #5FB878;">订单详情</a>
	</script>
	<script type="text/html" id="sexTpl">
 		 {{#  if(d.oState === 1){ }}
   		 <span style="color: #F581B1;">待付款</span>
  		{{#  } else if(d.oState === 2){ }}
		 <input type="checkbox" name="oId" value="{{d.oId}}" title="待发货" lay-filter="lockStatus" {{ d.status == 2 ? 'checked' : '' }}>
		 {{#  } else if(d.oState === 3){ }}
		 待收货
		{{#  } else{ }}
		 已完成
  		{{#  } }}
	</script>
	<script type="text/html" id="pValidity">
		{{#  if(d.remark === '0'){ }}
		<span style="color: #F581B1;">视频</span>
		{{#  } else if(d.remark === '1'){ }}
		PPT
		{{#  } else if(d.remark === '2'){ }}
		PDF
		{{#  } else if(d.remark === '3'){ }}
		实物
		{{#  } }}
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
											var phone = $('#phone'), oState = $('#oState option:selected');
													createTimeStart = $("#createTimeStart"),
													createTimeEnd = $("#createTimeEnd");
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
																	phone : phone
																			.val(),
																	oState : oState
																			.val(),
																	createTimeStart : createTimeStart
																			.val(),
																	createTimeEnd : createTimeEnd
																			.val()
																//}
																}
															});
										}
									};

							var start = laydate.render({
								elem : '#createTimeStart',
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
								elem : '#createTimeEnd',
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
										url : ctx + '/sys/getOrdersList' //数据接口
										,
                                        toolbar : true,
										limit : 10//每页默认数
										,
										limits : [ 10, 20, 30, 40 ],
										cols : [ [ //表头
												{
													type : 'checkbox'
												},
												{
													field : 'oId',
													title : '订单编号',
												},
												{
													field : 'total',
													title : '订单原价',
												},
                                            {
                                                field : 'money',
                                                title : '实付金额',
                                            },
                                            {
                                                field : 'yhmoney',
                                                title : '优惠金额',
                                            },
												{
													field : 'uName',
													title : '收货人姓名',
												},
												{
													field : 'phone',
													title : '收货人电话'
												},
												{
													field : 'oAddress',
													title : '收货人地址'
												},
												{
													field : 'oState',
													title : '订单状态',
													templet : '#sexTpl',
												},
												{
													title : '订单详情',
                                                    toolbar : '#orderitem'
												},
												{
													field : 'remark',
													title : '素材类型',
                                                    templet : '#pValidity'
												},
												{
													field : 'ordertime',
													title : '下单时间'
												}, {
													title : '操作',
													toolbar : '#barEdit'
												} ] ],
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
											url : ctx + '/sys/delOrderByOid/'
													+ data.oId,
											type : "get",
											success : function(d) {
												if (d.code == 0) {
													obj.del();
                                                    table.reload('userList', {})
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
								}else if(obj.event === 'edit'){
                                    layer.open({
                                        type: 2,
                                        title:"查看订单详情",
                                        area: ['780px', '680px'],
                                        content:ctx+"/sys/orderItemList?oId="+data.oId //这里content是一个普通的String
                                    })
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
														userStr += value.oId
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
																							+ '/sys/delOrders/'
																							+ userStr,//接口地址
																					type : "get",
																					success : function(
																							d) {
																						if (d.code == 0) {
																							//删除成功，刷新父页面
                                                                                            table.reload('userList', {})
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
                            //监听锁定操作
                            form.on('checkbox(lockStatus)', function(obj){
                                /*  layer.tips(this.value + '-- ' + this.name + '：'+ obj.elem.checked, obj.othis);  */
                                if(obj.elem.checked){
                                    $.ajax({
                                        url:'update/'+this.value+'/3',
                                        type : "get",
                                        success : function(d){
                                            if(d.code==0){
                                                table.reload('userList', {})
                                                layer.msg('已发货！',{icon: 1});
                                            }else{
                                                //重载表格
                                                table.reload('userList', {})
                                                layer.msg("权限不足，联系超管！",{icon: 5});
                                            }
                                        }
                                    })
                                }
                            });


                        })


	</script>
</body>
</html>