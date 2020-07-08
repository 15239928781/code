<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp" %>
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
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
          media="all"/>
    <link rel="stylesheet" href="${ctx }/css/list.css" media="all"/>
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote news_search">
    <form class="layui-form">
        <div>
            <div class="layui-inline">

                <div class="layui-input-inline layui-form lay-search">
                    <select name="btype" lay-search class="lay-search" id="btype">
                        <option value="-1">请选择查询日期</option>
                        <option value="1">今天</option>
                        <option value="2">本月</option>
                        <option value="3">本年</option>
                    </select>
                </div>
            </div>
            <a class="layui-btn search_btn" lay-submit="" data-type="search"
               lay-filter="search">查询</a>
            <div class="layui-inline">（支持模糊查询）</div>
        </div>
        <div style="margin-top: 1%">


            <%--<shiro:hasPermission name="user:user:save">
                <div class="layui-inline">
                    <a class="layui-btn layui-btn-normal userAdd_btn">添加用户</a>
                </div>
            </shiro:hasPermission>--%>


        </div>
    </form>
</blockquote>
<div class="layui-form">
    <table id="userList" lay-filter="test"></table>
</div>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>

<script type="text/html" id="orderitem">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit" style="background-color: #5FB878;">订单详情</a>
</script>
<script type="text/html" id="barEdit">

    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="xq">详情</a>

</script>
<script>
    layui
        .config({
            base: "js/"
        })
        .use(
            ['form', 'layer', 'jquery', 'table', 'laydate'],
            function () {
                var form = layui.form, table = layui.table, layer = parent.layer === undefined ? layui.layer
                    : parent.layer, laydate = layui.laydate
                $ = layui.jquery,
                    nowTime = new Date().valueOf(),
                    max = null,
                    active = {
                        search: function () {
                            var btype = $('#btype option:selected');

                            //执行重载
                            table
                                .reload(
                                    'userList',
                                    {
                                        page: {
                                            curr: 1
                                            //重新从第 1 页开始
                                        },
                                        where: {
                                            //key: {

                                            btype: btype
                                                .val(),

                                            //}
                                        }
                                    });
                        }
                    };
                //监听工具条
                table.on('tool(test)', function (obj) {
                    var data = obj.data;
                    if (obj.event === 'xq') {
                        layer.open({
                            type: 2,
                            title: "浏览详情",
                            area: ['720px', '860px'],
                            content: ctx + "/sys/getBrowseUserList?bId=" + data.bId //这里content是一个普通的String
                        })
                    }
                });

                //加载页面数据
                table.render({
                        id: 'userList',
                        elem: '#userList',
                        url: ctx + '/sys/getBrowseList' //数据接口
                        ,limit: 10//每页默认数
                        ,limits: [10, 20, 30, 40],
                        cols: [[ //表头
                            {
                                type: 'checkbox'
                            },
                            {
                                field: 'bId',
                                title: 'ID',
                            },
                            {
                                field: 'pName',
                                title: '商品名',
                            },
                            {
                                field: 'pNum',
                                title: '浏览量'
                            }
                            , {title: '操作', toolbar: '#barEdit'}]],
                        page: true
                        , where: {timestamp: (new Date()).valueOf()}
                        //开启分页
                    });
                //查询
                $(".search_btn").click(function () {
                    var type = $(this).data('type');
                    active[type] ? active[type].call(this) : '';
                })
            })
</script>
</body>
</html>