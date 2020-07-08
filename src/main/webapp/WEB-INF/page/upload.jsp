<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/28
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <link href="../../css/jquery.plupload.queue.css">
    <link rel="stylesheet" href="../../css/jquery.plupload.queue.css" media="all" />
</head>
<body>
<div id="uploader">
    <p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
</div>
<button id="toStop">暂停一下</button>
<button id="toStart">再次开始</button>
<%--<audio src="${ctx}/upload/player" controls="controls">
    Your browser does not support the audio element.
</audio>--%>
<script type="text/javascript" src="../../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../../js/plupload.full.min.js"></script>
<script type="text/javascript" src="../../js/zh_CN.js"></script>
<script type="text/javascript" src="../../js/jquery.plupload.queue.js"></script>

<script type="text/javascript">
    $(function() {
        // Initialize the widget when the DOM is ready
        var uploader = $("#uploader").pluploadQueue({
            // General settings
            runtimes: 'html5,flash,silverlight,html4',
            url: "http://localhost:81/upload/pluploadUpload",

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
</body>
</html>
