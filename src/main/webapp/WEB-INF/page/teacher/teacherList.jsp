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
		<div style="margin-top: 1%">
			<div class="layui-inline">
				<input type="text" id="tName" value="" placeholder="请输入讲师名称"
					   class="layui-input search_input">
			</div>
			<a class="layui-btn search_btn" lay-submit="" data-type="search"
			   lay-filter="search">查询</a>
			<shiro:hasPermission name="sys:teacher:save">
				<div class="layui-inline">
					<a class="layui-btn layui-btn-normal userAdd_btn">添加讲师</a>
				</div>
			</shiro:hasPermission>
			<shiro:hasPermission name="sys:teacher:delete">
				<div class="layui-inline">
					<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
				</div>
			</shiro:hasPermission>
			<div class="layui-inline">（支持模糊查询）</div>
		</div>
</blockquote>
</form>
<div class="layui-form">
	<table id="userList" lay-filter="userList"></table>
</div>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/html" id="barEdit">
	<shiro:hasPermission name="sys:teacher:update">
		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	</shiro:hasPermission>
	<shiro:hasPermission name="sys:teacher:delete">
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</shiro:hasPermission>
</script>
<script type="text/html" id="tableImg">
	<img src="${ctx}/file/showPic?fileName={{d.tPic}}" style="height:48px;width:48px;line-height:48px!important;"/>
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
                            var tName = $('#tName')
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
                                            tName : tName
                                                .val(),
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
                        url : ctx + '/sys/getTeacherList' //数据接口
                        ,
                        limit : 10//每页默认数
                        ,
                        limits : [ 10, 20, 30, 40 ],
                        cols : [ [ //表头
                            {
                                type : 'checkbox'
                            },
                            {
                                field : 'tId',
                                title : 'ID',
                                width : 60
                            },
                            {
                                field : 'tName',
                                title : '讲师名称',
                                width : 120
                            },
                            {
                                field : 'tPosition',
                                title : '讲师描述',
                            },
                            {
                                field : 'tPic',
                                title : '讲师头像',
                                templet : '#tableImg',
                                width : 120
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
                                url : ctx + '/sys/delTeacherById?id='+data.tId,
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
                        layer.open({
                            type : 2,
                            title : "编辑讲师信息",
                            area : [ '400px', '500px' ],
                            content : ctx + "/sys/editTeacher?id="+data.tId
                        })
                    }

                });

                //查询
                $(".search_btn").click(function() {
                    var type = $(this).data('type');
                    active[type] ? active[type].call(this) : '';
                })

                //添加讲师信息
                $(".userAdd_btn").click(function(){
                    layer.open({
                        type: 2,
                        title:"添加讲师信息",
                        area: ['380px', '460px'],
                        content:ctx+"/sys/addTeacher", //这里content是一个普通的String
                    })
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
                                    userStr += value.tId
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
                                                        + '/sys/delTeacher?carouselStr='+userStr,
                                                    type : "get",
                                                    success : function(
                                                        d) {
                                                        if (d.code == 0) {
                                                            //重载表格
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