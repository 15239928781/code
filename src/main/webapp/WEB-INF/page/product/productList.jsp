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
						<input type="text" id="pName" value="" placeholder="请输入素材名称"
							class="layui-input search_input">
					</div>
					<div class="layui-input-inline layui-form">
						<select name="cId" class="" id="cId">
							<option value="-1">请选择素材分类</option>
							<c:forEach items="${list }" var="category">
        						<option value="${category.cId }" >&nbsp;&nbsp;${category.cName }</option>
							</c:forEach>
						</select>
					</div>
					<div class="layui-input-inline layui-form">
						<select name="pIson" class="" id="pIson">
							<option value="-1">请选择是否上架</option>
							<option value="0">否</option>
							<option value="1">是</option>
						</select>
					</div>
				</div>
			</div>
			<div style="margin-top: 1%">
				<div class="layui-inline">
					<input type="text" id="createTimeStart"
						class="layui-input userName" name="createTimeStart"
						placeholder="商品添加时间(开始)" value="">
				</div>
				<div class="layui-inline">
					<input type="text" id="createTimeEnd" class="layui-input userName"
						name="createTimeEnd" placeholder="商品添加时间(结束)" value="">
				</div>
				<a class="layui-btn search_btn" lay-submit="" data-type="search"
					lay-filter="search">查询</a>
				<shiro:hasPermission name="sys:product:save">
					<div class="layui-inline">
						<a class="layui-btn layui-btn-normal userAdd_btn">添加商品</a>
					</div>
				</shiro:hasPermission>
				<shiro:hasPermission name="sys:product:delete">
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
		<shiro:hasPermission name="sys:product:update">
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		</shiro:hasPermission>
  		<shiro:hasPermission name="sys:product:delete">
  			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</shiro:hasPermission>
	</script>
	<script type="text/html" id="comment">
			<a class="layui-btn layui-btn-xs" lay-event="edit2" style="background-color: #5FB878;">评论内容</a>
	</script>
	<script type="text/html" id="pItem">
		{{#  if(d.pValidity === 0){ }}
		<a class="layui-btn layui-btn-xs" lay-event="pItem" style="background-color: #5FB878;">课程章节</a>
		{{#  } else if(d.pValidity === 1){ }}
		<a class="layui-btn layui-btn-xs" lay-event="pItem" style="background-color: #5FB878;">课程章节</a>
		{{#  } else if(d.pValidity === 2){ }}
		<a class="layui-btn layui-btn-xs" lay-event="pItem" style="background-color: #5FB878;">课程章节</a>
		{{#  } }}
	</script>
	<script type="text/html" id="pIsonTpl">
 		 {{#  if(d.pIson === 0){ }}
   		 <span style="color: #F581B1;">否</span>
  		{{#  } else if(d.pIson === 1){ }}
   		 	是
		{{#  } else{ }}
   		 	保密
  		{{#  } }}
	</script>
	<script type="text/html" id="pValidity">
		{{#  if(d.pValidity === 0){ }}
		<span style="color: #F581B1;">视频</span>
		{{#  } else if(d.pValidity === 1){ }}
		PPT/PDF
		<%--{{#  } else if(d.pValidity === 2){ }}
		PDF--%>
		{{#  } else if(d.pValidity === 3){ }}
		实物
		{{#  } }}
	</script>
	<script type="text/html" id="statusTpl">
 		 {{#  if(d.status === '0'){ }}
   		 <span style="color: #FFB800;">未激活</span>
  		{{#  } else if(d.status === '1'){ }}
			<span style="color: #01AAED;">正常</span>
		{{#  } else{ }}
   		 	<span style="color: #FF5722;">禁用</span>
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
											var pName = $('#pName'), pIson = $('#pIson option:selected'), cId = $('#cId option:selected');
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
                                                                    pName : pName
																			.val(),
                                                                    pIson : pIson
																			.val(),
                                                                    cId : cId
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
										url : ctx + '/sys/getProductList' //数据接口
										,
										limit : 10//每页默认数
										,
										limits : [ 10, 20, 30, 40 ],
										cols : [ [ //表头
												{
													type : 'checkbox'
												},
												{
													field : 'pId',
													title : 'ID',
													width : 60
												},
                                            {
                                                field : 'cName',
                                                title : '一级分类'
                                            },
                                            {
                                                field : 'sbName',
                                                title : '分区'
                                            },
                                            {
                                                field : 'cName1',
                                                title : '二级分类'
                                            },

												{
													field : 'pName',
													title : '素材名称'
												},
												{
													field : 'pIson',
													title : '素材类型',
													templet : '#pValidity'
												},
												{
													field : 'pOldprice',
													title : '原价'
												},
												{
													field : 'pPrice',
													title : '现价'
												},
												{
													field : 'pIson',
													title : '是否上架',
													templet : '#pIsonTpl'
												},
												{
													title : '评论',
                                                    toolbar : '#comment'
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
								if (obj.event === 'del') {
									layer.confirm('真的删除行么', function(index) {
										$.ajax({
											url : ctx + '/sys/delProductByPid?pId='+data.pId,
											type : "get",
											success : function(d) {
												if (d.code == 0) {
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
								} else if (obj.event === 'edit') {
                                    var index = layui.layer.open({
                                        title : "编辑商品",
                                        type : 2,
                                        content : ctx + "/sys/editProduct/"
                                            + data.pId, //这里content是一个普通的String
                                        success : function(layero, index) {

                                        }
                                    })
                                    //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                                    $(window).resize(function() {
                                        layui.layer.full(index);
                                    })
                                    layui.layer.full(index);
								}else if(obj.event==='edit2'){
                                    layer.open({
                                        type: 2,
                                        title:"查看评论信息",
                                        area: ['780px', '680px'],
                                        content:ctx+"/sys/commentList?pId="+data.pId //这里content是一个普通的String
                                    })
								}else if(obj.event==='pItem'){
                                  var index=layui.layer.open({
                                        type: 2,
                                        title:"查看章节",
                                        area: ['780px', '680px'],
                                        content:ctx+"/sys/pItemList?pId="+data.pId //这里content是一个普通的String
                                    })
                                    //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                                    $(window).resize(function(){
                                        layui.layer.full(index);
                                    })
                                    layui.layer.full(index);
								}

							});

							//查询
							$(".search_btn").click(function() {
								var type = $(this).data('type');
								active[type] ? active[type].call(this) : '';
							})

							//添加文章
							$(".userAdd_btn").click(function() {
								var index = layui.layer.open({
									title : "添加商品",
									type : 2,
									content : ctx + "/sys/addProduct",
									success : function(layero, index) {

									}
								})
								//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
								$(window).resize(function() {
									layui.layer.full(index);
								})
								layui.layer.full(index);
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
														userStr += value.pId
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
																							+ '/sys/delProducts/'
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

						})

		//格式化时间
		function formatTime(datetime, fmt) {
			if (datetime == null || datetime == 0) {
				return "";
			}
			if (parseInt(datetime) == datetime) {
				if (datetime.length == 10) {
					datetime = parseInt(datetime) * 1000;
				} else if (datetime.length == 13) {
					datetime = parseInt(datetime);
				}
			}
			datetime = new Date(datetime);
			var o = {
				"M+" : datetime.getMonth() + 1, //月份   
				"d+" : datetime.getDate(), //日   
				"h+" : datetime.getHours(), //小时   
				"m+" : datetime.getMinutes(), //分   
				"s+" : datetime.getSeconds(), //秒   
				"q+" : Math.floor((datetime.getMonth() + 3) / 3), //季度   
				"S" : datetime.getMilliseconds()
			//毫秒   
			};
			if (/(y+)/.test(fmt))
				fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			for ( var k in o)
				if (new RegExp("(" + k + ")").test(fmt))
					fmt = fmt.replace(RegExp.$1,
							(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
									.substr(("" + o[k]).length)));
			return fmt;
		}
	</script>
</body>
</html>