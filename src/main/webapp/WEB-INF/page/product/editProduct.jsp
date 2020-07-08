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
<form class="layui-form" style="width: 80%;" id="auf" enctype="multipart/form-data">
	<input type="hidden" value="${product.pId}" name="pId">
	<input type="hidden" value="${product.pIsgroup}" name="pIsgroup">
	<input type="hidden" value="${product.pValidity}" name="pValidity">
	<div class="layui-form-item" >
		<label class="layui-form-label">素材分类</label>
		<div class="layui-inline" >
			<select name="" class="" id="cId"  lay-verify="required" lay-filter="test">
				<c:forEach items="${list }" var="category">
					<option value="${category.cId }" <c:if test="${category.cId==product.fId }">selected='selected'</c:if>>&nbsp;&nbsp;${category.cName }</option>
				</c:forEach>
			</select>
		</div>
		<label class="layui-form-label">二级分类</label>
		<div class="layui-inline" style="display: block" id="block">
			<select name="cId" class="" id="selectCId" lay-verify="required">
				<c:forEach items="${categoryList }" var="category">
					<option value="${category.cId }" <c:if test="${category.cId==product.fId }">selected='selected'</c:if>>&nbsp;&nbsp;${category.cName }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">素材名称</label>
		<div class="layui-inline">
			<input type="text" id="pName" name="pName" class="layui-input userName"
				   lay-verify="required" placeholder="请输入素材名称" value="${product.pName}">
		</div>
		<label class="layui-form-label">讲师</label>
		<div class="layui-inline">
			<select name="tId" class="" id="tId">
				<option value="-1">请选择讲师</option>
				<c:forEach items="${teacherList }" var="teacher">
					<option value="${teacher.tId }" <c:if test="${teacher.tId==product.tId }">selected='selected'</c:if>>&nbsp;&nbsp;${teacher.tName }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<!--轮播图片  -->
	<div class="layui-form-item">
		<label class="layui-form-label">素材图片</label>
		<div class="layui-inline">
			<button type="button" class="layui-btn" id="onePicUpload"><i class="layui-icon"></i>上传文件</button><br />
			<img class="layui-upload-img" id="preview" style="width: 150px;margin-top: 5px" src="${ctx }/file/showPic?fileName=${product.pImage }">
			<p id="uploadError"></p>
			<input type="hidden" lay-verify="imgurl" name="pImage" id="newsImg" value="${product.pImage}"/>
		</div>
		<label class="layui-form-label">是否收费</label>
		<div class="layui-inline">
			<select name="pIsfee" class="" id="pIsfee" lay-filter="isfee">
				<option value="-1">请选择是否收费</option>
				<option value="0" <c:if test="${0==product.pIsfee }">selected='selected'</c:if>>否</option>
				<option value="1" <c:if test="${1==product.pIsfee }">selected='selected'</c:if>>是</option>
			</select>
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">素材原价</label>
		<div class="layui-inline">
			<input type="text" id="pOldprice" class="layui-input userName"
				   lay-verify="required" placeholder="请输入原价" name="pOldprice" value="${product.pOldprice}">
		</div>
		<label class="layui-form-label" id="yuanjia">素材现价</label>
		<div class="layui-inline" id="yuanjia2">
			<input type="text" id="pPrice" class="layui-input userName"
				   lay-verify="required" placeholder="请输入现价" name="pPrice" value="${product.pPrice}">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">是否热销</label>
		<div class="layui-inline">
			<select name="pIshot" class="" id="pIshot">
				<option value="-1">请选择是否热销</option>
				<option value="0" <c:if test="${0==product.pIshot }">selected='selected'</c:if>>否</option>
				<option value="1" <c:if test="${1==product.pIshot }">selected='selected'</c:if>>是</option>
			</select>
		</div>
		<label class="layui-form-label">是否上架</label>
		<div class="layui-inline">
			<select name="pIson" class="" id="pIson">
				<option value="-1">请选择是否上架</option>
				<option value="0" <c:if test="${0==product.pIson }">selected='selected'</c:if>>否</option>
				<option value="1"<c:if test="${1==product.pIson }">selected='selected'</c:if>>是</option>
			</select>
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">商品销量</label>
		<div class="layui-inline">
			<input type="number" name="pNum" class="layui-input userName"
				   lay-verify="required" placeholder="请输入商品销量" value="${product.pNum}">
		</div>
		<label class="layui-form-label">商品库存</label>
		<div class="layui-inline">
			<input type="number" name="pStock" class="layui-input userName"
				   lay-verify="required" placeholder="请输入商品库存" value="${product.pStock}">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">商品详情</label>
		<div class="layui-input-block">
			<script type="text/javascript" src="${ctx}/js/kindeditor/kindeditor-min.js"></script>
			<script type="text/javascript" src="${ctx}/js/kindeditor/kindeditor.js"></script>
			<script type="text/javascript" src="${ctx}/js/kindeditor/lang/zh_CN.js"></script>
			<script type="text/javascript" src="${ctx}/js/kindeditor/plugins/code/prettify.js"></script>
			<script>

                KindEditor.ready(function(K) {
                    K.create('#editor_id', {
                        uploadJson : '${ctx}/sys/upload_json',
                        fileManagerJson :  '${ctx}/sys/file_manager_json',
                        cssData: '.ke-content img {max-width: 300px;height:auto;}',
                        allowFileManager : true,
                        allowImageUpload : true,

                        afterUpload : function(url, data, name) { //上传文件后执行的回调函数，必须为3个参数
                            if(name=="pImage" || name=="multiimage"){ //单个和批量上传图片时
                                var img = new Image(); img.src = "http://pc-20180613wutp:8080/"+url;
                                img.onload = function(){ //图片必须加载完成才能获取尺寸
                                    if(img.width>600) KE.html(KE.html().replace('<img src="'+ 'http://pc-20180613wutp:8080/'+ + url + '"','<img src="'+ 'http://pc-20180613wutp:8080/'+ + url + '" width="300" height="146"'))
                                }
                            }
                        },
                        afterBlur: function(){this.sync();}
                    });
                });
			</script>
			<!-- /KindEditor -->
			<textarea id="editor_id" name="pDesc" style="width:800px;height:600px;" class="textArea">${product.pDesc}</textarea>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit="" lay-filter="addCarousel">立即提交</button>
		</div>
	</div>
</form>

<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/page/product/editProduct.js"></script>
<script type="text/javascript">


    $(function() {
        var pIsfee = $('#pIsfee option:selected').val();
        if (pIsfee==0){
            $("#yuanjia").hide();
            $("#yuanjia2").hide();
        }else if(pIsfee==1){
            $("#yuanjia").show();
            $("#yuanjia2").show();
        }
	})
</script>
</body>
</html>