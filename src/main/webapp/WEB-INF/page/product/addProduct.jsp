<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp" %>
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
    <link rel="stylesheet" href="${ctx }/css/jquery.plupload.queue.css" media="all"/>
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all"/>
    <script>
        <%--JS gloable varilible--%>
        var ctx = "${ctx}";
        var lastJsonstring = '';

        var success = 0;
        var fail = 0;
        var pIsgroup = "";
        var pRealName = "";
    </script>
    <style type="text/css">
        .layui-form-item .layui-inline {
            width: 33.333%;
            float: left;
            margin-right: 0;
        }

        @media ( max-width: 1240px) {
            .layui-form-item .layui-inline {
                width: 100%;
                float: none;
            }
        }

        #uploader {
            padding-left: 100px;
        }
    </style>
</head>
<body class="childrenBody">
<form class="layui-form" style="width: 80%;" id="auf" enctype="multipart/form-data">
    <input type="hidden" name="pId" value="${pId}">
    <div class="layui-form-item">
        <label class="layui-form-label">素材分类</label>
        <div class="layui-inline">
            <select name="" class="" id="cId" lay-verify="required" lay-filter="test">
                <option value="">请选择素材分类</option>
                <c:forEach items="${list }" var="category">
                    <option value="${category.cId }"
                            <c:if test="${category.cId==product.cId }">selected='selected'</c:if>>
                        &nbsp;&nbsp;${category.cName }</option>
                </c:forEach>
            </select>
        </div>
        <label class="layui-form-label" style="display: none;" id="categorySecond">二级分类</label>
        <div class="layui-inline" style="display: none" id="block">
            <select name="cId" class="" id="selectCId" lay-verify="required">
                <option value="">请选择素材二级分类</option>
                <c:forEach items="${categoryList}" var="category">
                    <option value="${category.cId }"
                            <c:if test="${category.cId==product.cId }">selected='selected'</c:if>>
                        &nbsp;&nbsp;${category.cName }</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">素材名称</label>
        <div class="layui-inline">
            <input type="text" id="pName" name="pName" class="layui-input userName"
                   placeholder="请输入素材名称" value="">
        </div>
        <label class="layui-form-label">讲师</label>
        <div class="layui-inline">
            <select name="tId" class="" id="tId">
                <option value="">请选择讲师</option>
                <c:forEach items="${teacherList }" var="teacher">
                    <option value="${teacher.tId }">&nbsp;&nbsp;${teacher.tName }</option>
                </c:forEach>
            </select>
        </div>

    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">素材类型</label>
        <div class="layui-inline">
            <select name="pValidity" class="" id="pValidity" lay-filter="Validity" lay-verify="required">
                <option value="">请选择素材类型</option>
                <option value="0">视频</option>
                <option value="1">PPTX/PDF</option>
                <option value="3">实物</option>
                <option value="6">图片</option>
            </select>
        </div>
        <label class="layui-form-label">是否收费</label>
        <div class="layui-inline">
            <select name="pIsfee" class="" id="pIsfee" lay-filter="isfee" lay-verify="required">
                <option value="">请选择是否收费</option>
                <option value="0">否</option>
                <option value="1">是</option>
            </select>
        </div>
    </div>
    <!--轮播图片  -->
    <div class="layui-form-item">
        <label class="layui-form-label">素材图片</label>
        <div class="layui-inline">
            <button type="button" class="layui-btn" id="onePicUpload"><i class="layui-icon"></i>上传文件</button>
            <br/>
            <img class="layui-upload-img" id="preview" style="width: 150px;margin-top: 5px">
            <p id="uploadError"></p>
            <input type="hidden" lay-verify="imgurl" name="pImage" id="newsImg" value=""/>
        </div>
        <label class="layui-form-label" id="pIspc1">最低限购</label>
        <div class="layui-inline">

            <input type="number" name="pIspc" id="pIspc2" class="layui-input userName"
                   placeholder="请输入最低限购单位/本" value="">
        </div>
    </div>
    <div class="layui-form-item" id="ppt" style="display: none">
        <label class="layui-form-label">PPT/PDF上传</label>
             
        <div class="layui-input-block">
                      
            <button type="button" class="layui-btn" id="test1">
                               <i class="layui-icon">&#xe67c;</i>请选择PPTX/PDF/图片
                          
            </button>
                      
            <button type="button" class="layui-btn" id="test9">开始上传</button>
            <%--
                              <button type="button" class="layui-btn" id="cleanImgs"> <i class="fa fa-trash-o fa-lg"></i>清空图片预览</button>
            --%>
                   
        </div>
               <%-- <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">预览图： <div class="layui-upload-list" id="demo2"></div>
		        </blockquote>--%>
           
    </div>
      
    <script type="text/javascript" src="${ctx}/js/jquery-1.9.1.min.js"></script>

    <script>
        /**
         * 图片上传数量及其大小等控制
         * 点击开始上传按钮(test9)，执行上传
         *
         */
//debugger
        $(function () {
            // var imgsName="";
            layui.use(['upload', 'layer'], function () {
                var upload = layui.upload;
                var layer = layui.layer;
                upload.render({
                    elem: '#test1',
                    url: ctx + '/file/upload',
                    multiple: true,
                    auto: false,
//			上传的单个图片大小
                    // size:10240,
//			最多上传的数量
                    // number:20,
//			MultipartFile file 对应，layui默认就是file,要改动则相应改动
                    field: 'file',
                    exts: 'ppt|pdf|pptx|jpg|png|gif|jpeg',
                    bindAction: '#test9',
                    before: function (obj) {
                        //预读本地文件示例，不支持ie8
                        obj.preview(function (index, file, result) {
                            $('#demo2').append('<img src="' + result
                                + '" alt="' + file.name
                                + '"height="92px" width="92px" class="layui-upload-img uploadImgPreView">')
                        });
                    },
                    done: function (res, index, upload) {
                        //每个图片上传结束的回调，成功的话，就把新图片的名字保存起来，作为数据提交
                        console.log(res.code);
                        if (res.code == "1") {
                            fail++;
                        } else {
                            success++;
                            pIsgroup = pIsgroup + res.data.src + ",";
                            pRealName = pRealName + res.data.realName + ",";
                            console.log("pIsgroup=" + pIsgroup)
                            console.log("pRealName=" + pRealName)
                            $('#iTime').val(pIsgroup);
                            $('#pRealName').val(pRealName);
                            console.log($('#iTime').val(pIsgroup));
                            console.log($('#pRealName').val(pRealName));
                        }
                    },
                    allDone: function (obj) {
                        layer.msg("总共要上传文件总数为：" + (fail + success) + "\n"
                            + "上传成功文件数为：" + success + "\n"
                            + "上传失败文件数为：" + fail
                        )
                    }
                });

            });

            //清空预览图片
            cleanImgsPreview();

        });

        /**
         * 清空预览的图片及其对应的成功失败数
         * 原因：如果已经存在预览的图片的话，再次点击上选择图片时，预览图片会不断累加
         * 表面上做上传成功的个数清0，实际后台已经上传成功保存了的，只是没有使用，以最终商品添加的提交的为准
          */
        function cleanImgsPreview() {
            $("#cleanImgs").click(function () {
                success = 0;
                fail = 0;
                $('#demo2').html("");
                $('#iTime').val("");
                $('#pRealName').val("");
            });
        }
    </script>
    <input type="hidden" id="iTime" name="pIsgroup" class="layui-input userName" value="">
    <input type="hidden" id="pRealName" name="pRealName" class="layui-input userName" value="">
    <div id="uploader">
        <p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
    </div>

    <div class="layui-form-item" id="uploadPlayer">
        <label class="layui-form-label">上传操作</label>
        <div class="layui-input-block">
            <button id="toStop" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger">暂停一下</button>
            <button id="toStart" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger">再次开始</button>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">素材原价</label>
        <div class="layui-inline">
            <input type="text" id="pOldprice" onkeyup="value=value.replace(/[^\d.]/g,'')" class="layui-input userName"
                   lay-verify="required" placeholder="请输入原价" name="pOldprice" value="">
        </div>
        <label class="layui-form-label" id="yuanjia">素材现价</label>
        <div class="layui-inline" id="yuanjia2">
            <input type="text" id="pPrice" onkeyup="value=value.replace(/^(0+)|[^\d.]+/g,'')"
                   class="layui-input userName"
                   lay-verify="" placeholder="请输入现价" name="pPrice" value="">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">是否热销</label>
        <div class="layui-inline">
            <select name="pIshot" class="" id="pIshot" lay-verify="required">
                <option value="-1">请选择是否热销</option>
                <option value="0">否</option>
                <option value="1">是</option>
            </select>
        </div>
        <label class="layui-form-label">是否上架</label>
        <div class="layui-inline">
            <select name="pIson" class="" id="pIson" lay-verify="required">
                <option value="-1">请选择是否上架</option>
                <option value="0">否</option>
                <option value="1">是</option>
            </select>
        </div>

    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">是否推荐</label>
        <div class="layui-inline">
            <select name="pTuijian" class="" id="pTuijian" lay-verify="required">
                <option value="-1">请选择是否推荐</option>
                <option value="0">否</option>
                <option value="1">是</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品销量</label>
        <div class="layui-inline">
            <input type="text" name="pNum" onkeyup="value=value.replace(/[^\d.]/g,'')" class="layui-input userName"
                   lay-verify="required" placeholder="请输入商品销量" value="">
        </div>
        <label class="layui-form-label">商品库存</label>
        <div class="layui-inline">
            <input type="text" name="pStock" onkeyup="value=value.replace(/[^\d.]/g,'')" class="layui-input userName"
                   lay-verify="required" placeholder="请输入商品库存" value="">
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

                KindEditor.ready(function (K) {
                    K.create('#editor_id', {
                        uploadJson: '${ctx}/sys/upload_json',
                        fileManagerJson: '${ctx}/sys/file_manager_json',
                        cssData: '.ke-content img {max-width: 300px;height:auto;}',
                        allowFileManager: true,
                        allowImageUpload: true,

                        afterUpload: function (url, data, name) { //上传文件后执行的回调函数，必须为3个参数
                            if (name == "pImage" || name == "multiimage") { //单个和批量上传图片时
                                var img = new Image();
                                img.src = "http://pc-20180613wutp:8080/" + url;
                                img.onload = function () { //图片必须加载完成才能获取尺寸
                                    if (img.width > 600) KE.html(KE.html().replace('<img src="' + 'http://pc-20180613wutp:8080/' + +url + '"', '<img src="' + 'http://pc-20180613wutp:8080/' + +url + '" width="300" height="146"'))
                                }
                            }
                        },
                        afterBlur: function () {
                            this.sync();
                        }
                    });
                });
            </script>
            <!-- /KindEditor -->
            <textarea id="editor_id" name="pDesc" style="width:800px;height:600px;" class="textArea"></textarea>
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
        $(function () {
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
                    FileUploaded: function (uploader, file, responseObject) { //当队列中的某一个文件上传完成后触发
                        console.info(responseObject.response); //服务器返回的文本
                        console.info(responseObject.status); //服务器返回的http状态码，比如200
                        var jsonstr = JSON.parse(responseObject.response);
                        lastJsonstring = lastJsonstring + jsonstr.data.plupload.name + ',';
                        pRealName = pRealName + jsonstr.data.pRealName + ',';
                        $("#iPic").val(lastJsonstring);
                        $("#pRealName").val(pRealName);
                        var s = $("#iTime").val(lastJsonstring);
                        console.log("jsonstr.data.plupload.name=" + lastJsonstring);
                    },
                    /*  UploadComplete: function(uploader,file) { //当上传队列中所有文件都上传完成后触发
                          console.info("ok");
                      },*/
                    Error: function (uploader, errObject) { //当发生错误时触发
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
<script type="text/javascript" src="${ctx }/page/product/addProduct.js"></script>
</body>
</html>