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
<div class="layui-inline">
    <input type="text" id="createTimeStart"
           class="layui-input userName" name="createTimeStart"
           placeholder="查询时间(开始)" value="">
</div>
<div class="layui-inline">
    <input type="text" id="createTimeEnd" class="layui-input userName"
           name="createTimeEnd" placeholder="查询时间(结束)" value="">
</div>
<a class="layui-btn search_btn" lay-submit=""
    onclick="searchs();">查询</a>
<div class="wrap-container welcome-container">
    <div class="row">
        <div class="welcome-left-container col-lg-9">
            <div class="data-show">
                <ul class="clearfix">
                    <li class="col-sm-12 col-md-4 col-xs-12">
                        <a href="javascript:;" class="clearfix">
                            <div class="icon-bg bg-blue f-l">
                                <span class="iconfont"><i class="layui-icon" data-icon="" style="font-size: 40px;"></i></span>
                            </div>
                            <div class="right-text-con">
                                <p class="name">累计总收入</p>
                                <p><span class="color-blue" id="sumtotal"></span></p>
                            </div>
                        </a>
                    </li>
                    <li class="col-sm-12 col-md-4 col-xs-12">
                        <a href="javascript:;" class="clearfix">
                            <div class="icon-bg bg-org f-l">
                                <span class="iconfont"><i class="layui-icon" data-icon="" style="font-size: 40px;"></i></span>
                            </div>
                            <div class="right-text-con">
                                <p class="name">今日新增用户</p>
                                <p><span class="color-org" id="todayuser"></span></p>
                            </div>
                        </a>
                    </li>

                    <li class="col-sm-12 col-md-4 col-xs-12">
                        <a href="javascript:;" class="clearfix">
                            <div class="icon-bg bg-green f-l">
                                <span class="iconfont"><i class="layui-icon" data-icon="" style="font-size: 40px;"></i></span>
                            </div>
                            <div class="right-text-con">
                                <p class="name">今日收入</p>
                                <p><span class="color-green" id="todaytotal"></span></p>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
            <!--图表-->
            <div class="chart-panel panel panel-default">
                <div class="panel-body" id="chart" style="height: 376px; -webkit-tap-highlight-color: transparent; user-select: none; background-color: rgba(0, 0, 0, 0); cursor: default;" _echarts_instance_="1552369663524"><div style="position: relative; overflow: hidden; width: 1265px; height: 376px;"><div data-zr-dom-id="bg" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 1221px; height: 376px; user-select: none;"></div><canvas width="1265" height="376" data-zr-dom-id="0" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 1265px; height: 376px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas><canvas width="1265" height="376" data-zr-dom-id="1" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 1265px; height: 376px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas><canvas width="1265" height="376" data-zr-dom-id="_zrender_hover_" class="zr-element" style="position: absolute; left: 0px; top: 0px; width: 1265px; height: 376px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas><div class="echarts-tooltip zr-element" style="position: absolute; display: none; border-style: solid; white-space: nowrap; transition: left 0.4s, top 0.4s; background-color: rgba(0, 0, 0, 0.7); border-width: 0px; border-color: rgb(51, 51, 51); border-radius: 4px; color: rgb(255, 255, 255); padding: 5px; left: 61px; top: 233px;">周一<br>会员 : 10<br>文章 : 30<br>评论 : 1,320</div></div></div>
            </div>
            <!--服务器信息-->
            <div class="panel panel-default">
                <div class="panel-header" style="display: inline-flex;"><span class="juli">素材排名信息</span>
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
                    <%--<div class="col-md-2">
                        <p class="title" id="pName">素材名称</p>
                    </div>
                    <div class="col-md-2">
                        <p class="title" id="cName"> 素材分类名称</p>

                    </div>
                    <div class="col-md-2">
                        <p class="title" id="teacher">讲师名</p>

                    </div>
                    <div class="col-md-2">
                        <p class="title" id="pNum">销量</p>

                    </div>

                    <div class="col-md-2">
                        <p class="title" id="prices">总销量</p>

                    </div>
                    <div class="col-md-2">
                        <p class="title" id="time">素材上架时间</p>

                    </div>--%>
                        <div class="layui-form">
                            <table id="userList" lay-filter="userList"></table>
                        </div>
                </div>
            </div>
        </div>

        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/js/lib/echarts/echarts.js"></script>
<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.9.1.min.js"></script>

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
        //图表
        var myChart;
        require.config({
            paths: {
                echarts: '${ctx}/js/lib/echarts'
            }
        });
        require(
            [
                'echarts',
                'echarts/chart/bar',
                'echarts/chart/line',
                'echarts/chart/map'
            ],
            function (ec) {
                //--- 折柱 ---
                myChart = ec.init(document.getElementById('chart'));
                myChart.setOption(
                    {
                        title: {
                            text: "数据统计",
                            textStyle: {
                                color: "rgb(85, 85, 85)",
                                fontSize: 18,
                                fontStyle: "normal",
                                fontWeight: "normal"
                            }
                        },
                        tooltip: {
                            trigger: "axis"
                        },
                        legend: {
                            data: ["每月收入总额", "每月新增用户", "每月订单总数"],
                            selectedMode: false,
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                dataView: {
                                    show: false,
                                    readOnly: true
                                },
                                magicType: {
                                    show: false,
                                    type: ["line", "bar", "stack", "tiled"]
                                },
                                restore: {
                                    show: true
                                },
                                saveAsImage: {
                                    show: true
                                },
                                mark: {
                                    show: false
                                }
                            }
                        },
                        calculable: false,
                        xAxis: [
                            {
                                type: "category",
                                boundaryGap: false,
                                data: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
                            }
                        ],
                        yAxis: [
                            {
                                type: "value"
                            }
                        ],
                        grid: {
                            x2: 30,
                            x: 50
                        },
                        series: [
                            {
                                name: "每月收入总额",
                                type: "line",
                                smooth: true,
                                itemStyle: {
                                    normal: {
                                        areaStyle: {
                                            type: "default"
                                        }
                                    }
                                },
                                data: getdata('income')
                            },
                            {
                                name: "每月新增用户",
                                type: "line",
                                smooth: true,
                                itemStyle: {
                                    normal: {
                                        areaStyle: {
                                            type: "default"
                                        }
                                    }
                                },
                                data: getdata('users')
                            },
                            {
                                name: "每月订单总数",
                                type: "line",
                                smooth: true,
                                itemStyle: {
                                    normal: {
                                        areaStyle: {
                                            type: "default"
                                        },
                                        color: "rgb(110, 211, 199)"
                                    }
                                },
                               // data: [1320, 1132, 601, 234, 120, 90, 20,710,710,710,710,710]
                                data: getdata('orders')
                            }
                        ]
                    }
                );
            }
        );
        $(window).resize(function(){
            myChart.resize();
        })
       // getPaiming();
        //加载页面数据
        table
            .render({
                id : 'userList',
                elem : '#userList',
                url : ctx + '/sys/propaihang' //数据接口
                ,
                toolbar : true,
                limit : 10//每页默认数
                ,
                limits : [ 10, 20, 30, 40 ],
                cols : [ [ //表头
                    {
                        field : 'pName',
                        title : '素材名',
                    },
                    {
                        field : 'tName',
                        title : '讲师名',
                    },
                    {
                        field : 'sales',
                        title : '素材销量',
                    },
                    {
                        field : 'privace',
                        title : '素材销量额',
                    }
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
    function getdata(str) {
        var jsonstr = [];
        var dataList
        $.ajax({
            type:"post",
            url:"${ctx}/sys/getTalbymoth",
            dataType:"json",
            async: false, //设置为同步请求
            success: function(d){
                console.log(d.data)
                if ('income' == str){
                    dataList=d.data.income
                }else if('orders' == str){
                    dataList=d.data.orders
                }else if('users' == str){
                    dataList=d.data.users
                }
                console.log(dataList)
                for (var i = 0; i < dataList.length; i++) {
                    var json = {};
                    json = dataList[i];
                    console.log(json)
                    jsonstr.push(json);
                }
                console.log(jsonstr)
            }
        })
        return jsonstr;
    }

    	$.ajax({
    		type:"post",
    		url:"${ctx}/sys/getIndex",
    		async:true,
    		success:function(d){
    			$("#sumtotal").text(d.data.subtotal)
    			$("#todayuser").text(d.data.todayuser)
    			$("#todaytotal").text(d.data.todayTotal)
    		}
    	});

    function searchs() {
        var createTimeStart=$("#createTimeStart").val();
        var createTimeEnd=$("#createTimeEnd").val();
        $.ajax({
            type:"post",
            url:"${ctx}/sys/sumTotalByTime",
            data:{'createTimeStart':createTimeStart,'createTimeEnd':createTimeEnd},
            async:true,
            success:function(d){
                $("#sumtotal").text(d.data.subtotal)
            }
        });
    }
</script>
</body>
</html>