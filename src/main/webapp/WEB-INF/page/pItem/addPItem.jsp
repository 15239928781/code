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
	<link href="${ctx }/css/jquery.plupload.queue.css">
    <link rel="stylesheet" href="${ctx }/css/jquery.plupload.queue.css" media="all" />
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
		#uploader{
			padding-left: 100px;
		}
	</style>
</head>
<body class="childrenBody">
<form class="layui-form" style="width: 80%;" id="auf" enctype="multipart/form-data">
<input type="hidden" name="pId" value="${pId}">


	<div class="layui-form-item">
		<label class="layui-form-label">章节名称</label>
		<div class="layui-input-block">
			<input type="text" id="iName" name="iName" class="layui-input userName"
				   lay-verify="required" placeholder="请输入章节名称" value="">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">章节简介</label>
		<div class="layui-input-block">
			<input type="text" id="iDesc" name="iDesc" class="layui-input userName"
				   lay-verify="required" placeholder="请输入章节简介" value="">
		</div>
	</div>
	<input type="hidden" id="iTime" name="iTime" class="layui-input userName"
		   lay-verify="required" value="">
	<div id="uploader">
		<p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">上传操作</label>
		<div class="layui-input-block">
			<button id="toStop" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger">暂停一下</button>
			<button id="toStart" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger" >再次开始</button>
		</div>
	</div>

	<%--<audio src="${ctx}/upload/player" controls="controls">
        Your browser does not support the audio element.
    </audio>--%>
	<script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${ctx }/js/plupload.full.min.js"></script>
	<script type="text/javascript" src="${ctx }/js/zh_CN.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery.plupload.queue.js"></script>

	<script type="text/javascript">
        $(function() {
            // Initialize the widget when the DOM is ready
            var uploader = $("#uploader").pluploadQueue({
                // General settings
                runtimes: 'html5,flash,silverlight,html4',
                url: "${ctx }/upload/pluploadUpload",

                // Maximum file size
                max_file_size: '10000mb',

                chunk_size: '1mb',

                // Resize images on clientside if we can
                resize: {
                    width: 200,
                    height: 200,
                    quality: 90,
                    crop: true // crop to exact dimensions
                },

                // Specify what files to browse for
                filters: [
                    {title: "Image files", extensions: "jpg,gif,png"},
                    {title: "Vedio files", extensions: "mp4,mkv"},
                    {title: "Zip files", extensions: "zip,avi,pptx,ppt,pdf"}
                ],

                // Rename files by clicking on their titles
                rename: true,

                // Sort files
                sortable: true,

                // Enable ability to drag'n'drop files onto the widget (currently only HTML5 supports that)
                dragdrop: true,

                // Views to activate
                views: {
                    list: true,
                    thumbs: true, // Show thumbs
                    active: 'thumbs'
                },

                // Flash settings
                flash_swf_url: '${ctx}/js/Moxie.swf',

                // Silverlight settings
                silverlight_xap_url: '${ctx}/js/Moxie.xap',
                init: { //监听函数
                    /*  FilesAdded: function(uploader,file) { //当文件添加到上传队列后触发
                          uploader.start(); //开始上传
                          return false;
                      },*/
                    /* UploadProgress: function(uploader,file) { //会在文件上传过程中不断触发
                         console.info(uploader.total.percent + "%");
                         console.info(file.percent + "%"); //文件已上传部分所占的百分比
                     },*/
                    FileUploaded: function(uploader,file,responseObject) { //当队列中的某一个文件上传完成后触发
                        console.info(responseObject.response); //服务器返回的文本
                        console.info(responseObject.status); //服务器返回的http状态码，比如200
                        var jsonstr = JSON.parse(responseObject.response);
                        $("#iPic").val(jsonstr.data.plupload.name);
						$("#iTime").val(jsonstr.data.plupload.timelength);
                    },
                    /*  UploadComplete: function(uploader,file) { //当上传队列中所有文件都上传完成后触发
                          console.info("ok");
                      },*/
                    Error: function(uploader,errObject) { //当发生错误时触发
                        console.info(errObject.code); //错误代码
                        console.info(errObject.message); //错误信息
                    }
                }
            }); //初始化Plupload实例

            $("#toStop").on('click', function () {
                uploader.stop();
            });

            $("#toStart").on('click', function () {
                uploader.start();
            });
        });
	</script>

	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit="" lay-filter="addCarousel">立即提交</button>
		</div>
	</div>
</form>

<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/page/pItem/addPItem.js"></script>
</body>
</html>