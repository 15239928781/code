var $;
var $form;
var form;
layui.config({
    base : "js/"
}).use(['form','layer','jquery','laydate'],function(){
    var layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,laydate = layui.laydate;
    $ = layui.jquery;
    form = layui.form;

    $("#rPrices").blur(function(){
        $.ajax({
            type: "post",
            url: ctx+"/reward/checkRewardByPrices?prices="+$("#rPrices").val(),
            success:function(data){
                if(data.code!=0){
                    top.layer.msg(data.msg);
                    $("#rPrices").val("");
                    $("#rPrices").focus();
                }
            }
        });
    });

    form.on("submit(addIntegralUse)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        var msg;
        $.ajax({
            type: "post",
            url: ctx+"/reward/save",
            data:data.field,
            dataType:"json",
            success:function(d){
                if(d.code==0){
                    msg="添加成功,请刷新！";
                }else{
                    msg=d.msg;
                }
            }
        });
        setTimeout(function(){
            top.layer.close(index);
            top.layer.msg(msg);
            layer.msg(msg);
            layer.closeAll("iframe");
            //刷新父页面
            parent.location.reload();
        },2000);
        return false;
    })

})