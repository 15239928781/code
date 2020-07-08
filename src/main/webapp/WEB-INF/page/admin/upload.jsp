<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/28
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../../css/jquery.plupload.queue.css">
</head>
<body>
<div id="uploader">
    <p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
</div>
<button id="toStop">暂停一下</button>
<button id="toStart">再次开始</button>

<script type="text/javascript" src="../../../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../../js/plupload.full.min.js"></script>
<script type="text/javascript" src="../../js/jquery.plupload.queue.js"></script>
<script type="text/javascript" src="../../js/zh_CN.js"></script>
<script type="text/javascript">
    $(function() {
        // Initialize the widget when the DOM is ready
        var uploader = $("#uploader").pluploadQueue({
            // General settings
            runtimes: 'html5,flash,silverlight,html4',
            url: "../pluploadUpload",

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
                {title: "Zip files", extensions: "zip,avi"}
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
            flash_swf_url: 'js/Moxie.swf',

            // Silverlight settings
            silverlight_xap_url: 'js/Moxie.xap'
        });

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
