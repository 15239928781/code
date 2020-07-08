// 静态储存区,全局变量
// 1.接口地址
// 线上
var ctx = 'http://www.bybart.cn'
// 本地
// var ctx = 'http://115.158.20.211:8888'

// 2.用户的uId
// var uId = $.cookie("uId");
var uId = localStorage.getItem('uId');

/**
 * 3.用户token
 * @type {string}
 */
var token = localStorage.getItem('token');

function getToken() {
    if (localStorage.getItem('token')) {
        return localStorage.getItem('token');
    }else {
        window.location.href = "login.html";
    }
}

/**
 * 4.获取指定标签对象
 * @param id 标签的id属性值
 * @returns {Element}根据id属性值返回指定标签对象
 */
function my$(id) {
    return document.getElementById(id);
}

/**
 * 退出登录，并清空uId，token
 */
function edit() {
    localStorage.setItem('uId', '')
    localStorage.setItem('token', '')
    window.location.reload();
}

/**
 * 获取地址栏中?后面的value值
 * head中需要加<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 * @param name
 * @returns {*}
 */
//不能传中文
function getQueryStringEng(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return unescape(r[2]);
    return null;
}
//可以识别中文
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return decodeURIComponent(r[2]);
    return null;
}


