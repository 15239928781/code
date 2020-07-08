<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>后台首页</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${ctx}/css/font_eolqem241z66flxr.css"
		  media="all" />
	<link rel="stylesheet" href="${ctx}/css/admin.css" media="all" />
	<script>

        <%--JS gloable varilible--%>
        var ctx = "${ctx}";
	</script>
	<style type="text/css">
		.juli{
			margin-top: 10px;
			margin-right: 15px;
		}
	</style>
</head>
<body class="childrenBody" style="margin: 1%">

<div class="wrap-container welcome-container">
	<div class="row">
		<div class="welcome-left-container col-lg-9">


			<!--服务器信息-->
			<div class="panel panel-default">
				<div class="panel-header" style="display: inline-flex;"><span class="juli">讲师销量信息</span>
					<form>
						<div class="layui-inline">
							<input type="text" id="createTimeStart2"
								   class="layui-input userName" name="createTimeStart"
								   placeholder="查询时间(开始)" value="">
						</div>
						<div class="layui-inline">
							<input type="text" id="createTimeEnd2" class="layui-input userName"
								   name="createTimeEnd" placeholder="查询时间(结束)" value="">
						</div>
						<a class="layui-btn search_btn" lay-submit="" data-type="search"
						   lay-filter="search" >查询</a>
					</form>
				</div>

				<div class="panel-body clearfix">
					<div class="layui-form">
						<table id="userList" lay-filter="userList"></table>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
</div>
<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/echarts/echarts.js"></script>
<script type="text/javascript">
    layui.use(['layer','jquery','laydate','form','table'], function(){
        var layer 	= layui.layer;
        var $=layui.jquery;
        var laydate = layui.laydate;
        var table = layui.table;
        var form = layui.form;
        var nowTime = new Date().valueOf();
        var  max = null;
        active = {
            search : function() {
                var createTimeStart = $("#createTimeStart2"),
                    createTimeEnd = $("#createTimeEnd2");
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
        var start = laydate.render({
            elem : '#createTimeStart2',
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
            elem : '#createTimeEnd2',
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
                url : ctx + '/sys/getTeacherNumList' //数据接口
                ,
                toolbar : true,
                limit : 10//每页默认数
                ,
                limits : [ 10, 20, 30, 40 ],
                cols : [ [ //表头

                    {field:'tName', title: '讲师名'}
                    ,{field:'tNum', title: '课程销量'}
                    ,{field:'sumPrices', title: '总销售额'}
                ] ],
                page : true
                ,where: {timestamp: (new Date()).valueOf()}
                //开启分页
            });
        //查询
        $(".search_btn").click(function() {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        })


    });

</script>
</body>
</html>