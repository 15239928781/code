var $;
var $form;
var form;
layui.config({
    base : "js/"
}).use(['form','layer','jquery','upload'],function(){
    var layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,upload = layui.upload;
    $ = layui.jquery;
    form = layui.form;

    //pImage
    form.verify({
        pImage:function(value){
            if(value.length==0){
                return "请上传图片！";
            }
        }
    })

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#onePicUpload'
        ,url: ctx+'/file/upload'
        ,before: function(obj){
            //预读本地文件
            obj.preview(function(index, file, result){
                $('#preview').attr('src', result); //图片链接（base64）
            });
        }
        ,done: function(res){
            //如果上传失败
            if(res.code > 0){
                return layer.msg(res.msg);
            }
            //上传成功
            //设置src给图片隐藏域
            $("#newsImg").val(res.data.src);
            layer.msg('上传成功')
        }
        ,error: function(){
            //失败状态，并实现重传
            var uploadError = $('#uploadError');
            uploadError.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
            uploadError.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });
//普通PPT上传
    var uploadInst = upload.render({
        elem: '#onePicUpload2'
        ,url: ctx+'/file/upload'
        ,before: function(obj){
        }
        ,done: function(res){
            //如果上传失败
            if(res.code > 0){
                return layer.msg(res.msg);
            }
            //上传成功
            //设置src给图片隐藏域
            $("#iTime").val(res.data.src);

            layer.msg('上传成功')
        }
        ,error: function(){
            //失败状态，并实现重传
            var uploadError = $('#uploadError2');
            uploadError.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
            uploadError.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });
    form.on('select(test)', function(data){
        var cId = $('#cId option:selected').val();
        $.ajax({
            type: "post",
            url: ctx+"/sys/selectByCId?cId="+cId,
            dataType:"json",
            success:function(d){
                if(d.code==0){
                    var category=d.data;
                    console.log(category)
                    var str='<select name="cId" class="" id="selectCId" lay-verify="required"><option value="-1">请选择素材二级分类</option>';
                    for (var i=0;i<category.length; i++){
                        str+='<option value="'+category[i].cId+'">'+category[i].cName+'</option>'
                    }
                    str+="</select>";
                    $("#selectCId").html(str);
                    $("#block").css("display","block");
                    $("#categorySecond").css("display","block");
                    form.render();
                }else{
                    msg=d.msg;
                }
            }
        });
    });
    form.on("select(isfee)", function(data){
        var pIsfee = $('#pIsfee option:selected').val();
        if (pIsfee==0){
            $("#yuanjia").hide();
            $("#yuanjia2").hide();
        }else if(pIsfee==1){
            $("#yuanjia").show();
            $("#yuanjia2").show();
        }

    })
    form.on("select(Validity)", function(data){
        var pValidity = $('#pValidity option:selected').val();
        if (pValidity==0){
            $("#uploadPlayer").show();
            $("#uploader").show();
            $("#ppt").hide();
            $("#ppt2").hide();
            $("#pdf").hide();
            $("#pIspc1").hide();
            $("#pIspc2").hide();
        }else if(pValidity==1){
            $("#uploadPlayer").hide();
            $("#uploader").hide();
            $("#ppt").show();
            $("#ppt2").show();
            $("#pdf").hide();
            $("#pIspc1").hide();
            $("#pIspc2").hide();
        }
        else if(pValidity==6){
            $("#uploadPlayer").hide();
            $("#uploader").hide();
            $("#ppt").show();
            $("#ppt2").show();
            $("#pdf").hide();
            $("#pIspc1").hide();
            $("#pIspc2").hide();
        }
        else if(pValidity==3){
            $("#uploadPlayer").hide();
            $("#uploader").hide();
            $("#ppt").hide();
            $("#ppt2").hide();
            $("#pdf").hide();
            $("#pIspc1").show();
            $("#pIspc2").show();

        }


    })
    form.on("submit(addCarousel)",function(data){
        console.log("----------1111-----------------------------------");
        console.log(typeof (data));
        console.log("----------2222-----------------------------------");
        console.log(data.field);
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        var msg;
        $.ajax({
            type: "post",
            url: ctx+"/sys/insProduct",
            data:data.field,
            dataType:"json",
            success:function(d){
                if(d.code==0){
                    msg="添加成功";
                }else{
                    msg=d.msg;
                }
            }
        });
        setTimeout(function(){
            top.layer.close(index);
            top.layer.msg(msg);
            /*layer.msg(msg);*/
             layer.closeAll("iframe");

            //刷新父页面
           parent.location.reload();
        },6000);
        return false;
    })
})


