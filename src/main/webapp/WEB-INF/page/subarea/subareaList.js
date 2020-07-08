layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table','laytpl'],function(){
	var form = layui.form,table = layui.table;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		//数据表格
		table.render({
			id:'subareaList',
		    elem: '#subareaList'
		    ,url: ctx+'/subarea/list' //数据接口
		    ,cellMinWidth: 80
		    ,limit:10//每页默认数
		    ,limits:[10,20,30,40]
		    ,cols: [[ //表头
              {type:'checkbox'}
              ,{field:'sbId', title: 'ID', sort: true}
              ,{field:'sbName', title: '分区名称'}
                ,{field:'leName', title: '关联等级名称'}
              ,{field:'sbIsshow', title: '是否使用',templet: '#statusTpl', unresize: true}
              /*,{field:'leMinscore', title: '最低积分'}
              ,{field:'leMaxscore', title: '最高积分'}*/
              ,{title: '操作',toolbar: '#barEdit'}
		    ]]
				,page: true //开启分页
		  });
		//监听工具条
		  table.on('tool(test)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'del'){
		      layer.confirm('真的删除行么?', function(index){
		    	  $.ajax({
		    		  url:ctx+'/subarea/delete?sbId='+data.sbId,
		    		  type : "get",
		    		  success : function(d){
		    			  if(d.code==0){
		    				  table.reload('subareaList', {})
                              layer.msg("删除成功！", {
                                  icon : 1
                              });
		    			  }else{
		    				  layer.msg("权限不足，联系超管！",{icon: 5});
		    			  }
		    		  }
		    	  })
		        layer.close(index);
		      });
		    } else if(obj.event === 'edit'){
		      layer.open({
		    	  type: 2,
		    	  title:"编辑分区",
		    	  area: ['380px', '460px'],
		    	  content:ctx+"/subarea/editSubarea?sbId="+data.sbId //这里content是一个普通的String
		      })
		    }else if(obj.event === 'del2'){
                layer.open({
                    type: 2,
                    title:"添加商品",
                    area: ['1280px', '800px'],
                    content:ctx+"/subarea/addPsdProduct?sbId="+data.sbId //这里content是一个普通的String
                })
            }
		  });

	//添加轮播
	$(".carouselAdd_btn").click(function(){
		layer.open({
	    	  type: 2,
	    	  title:"添加分区",
	    	  area: ['380px', '460px'],
	    	  content:ctx+"/subarea/addSubarea", //这里content是一个普通的String
	      })
	})






//监听锁定操作
    form.on('checkbox(lockStatus)', function(obj){
        /*  layer.tips(this.value + '-- ' + this.name + '：'+ obj.elem.checked, obj.othis);  */
        if(obj.elem.checked){
            $.ajax({
                url:'update/'+this.value+'/1',
                type : "get",
                success : function(d){
                    if(d.code==0){
                        layer.msg('展示成功！',{icon: 1});
                    }else{
                        //重载表格
                        table.reload('subareaList', {})
                        layer.msg("权限不足，联系超管！",{icon: 5});
                    }
                }
            })
        }else{
            $.ajax({
                url:'update/'+this.value+'/0',
                type : "get",
                success : function(d){
                    if(d.code==0){
                        layer.msg('取消展示成功！',{icon: 1});
                    }else{
                        //重载表格
                        table.reload('subareaList', {})
                        layer.msg("权限不足，联系超管！",{icon: 5});
                    }
                }
            })
        }
    });

    //批量删除角色
    $(".tedingshop_btn").click(
        function() {
            var checkStatus = table.checkStatus('subareaList'), data = checkStatus.data, userStr = '';
            console.log(data+"===============");
            if (data.length > 0) {
                console.log(data.length+"===============");
                if(data.length==1){

                    $.each(data, function(n, value) {
                        userStr += value.sbId  + ',';
                    });
                    userStr = userStr .substring( 0, userStr.length - 1);
                    var index = layui.layer.open({
                        title : "添加特定商品",
                        type : 2,
                        content : ctx + "/subarea/addProduct?userStr="+userStr,
                        //这里content是一个普通的String
                        success : function(layero, index) {

                        }
                    })
                    //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                    $(window).resize(function() {
                        layui.layer.full(index);
                    })
                    layui.layer.full(index);
                }else{
                    layer.msg("只能选择一个");
                }

            } else {
                layer.msg("请选择需要添加的商品");
            }
    })

    //批量删除角色
	$(".batchDel").click(function(){
		var checkStatus = table.checkStatus('subareaList')
	      ,data = checkStatus.data,carouselStr='';
//	      layer.alert(JSON.stringify(data));
		if(data.length>0){
			$.each(data, function (n, value) {
				carouselStr+=value.sbId+',';
	          });
			carouselStr=carouselStr.substring(0,carouselStr.length-1);
			  layer.confirm('真的要删除<strong>'+data.length+'</strong>条数据吗？', function(index){
				//调用删除接口
				  $.ajax({
			    		  url:'deletes?carouselStr='+carouselStr,//接口地址
			    		  type : "get",
			    		  success : function(d){
			    			  if(d.code==0){
			    				//重载表格
			    				table.reload('subareaList', {})
                                  layer.msg("删除成功！", {
                                      icon : 1
                                  });
			    				  //删除成功，刷新父页面
			    				  //parent.location.reload();
			    			  }else{
			    				  layer.msg("删除错误，稍后再试！",{icon: 5});
			    			  }
			    		  }
			    	  })
			    	  layer.close(index);
			  });
		}else{
			layer.msg("请选择要操作的数据！");
		}
		
	})
//添加轮播
   /* $(".carouselAdd_btn").click(function(){
        layer.open({
            type: 2,
            title:"添加分区",
            area: ['380px', '460px'],
            content:ctx+"/subarea/addSubarea", //这里content是一个普通的String
        })
    })*/


    $(".lookProductAdd_btn") .click(
        function() {
            var checkStatus = table.checkStatus('subareaList'), data = checkStatus.data, userStr = '';
            console.log(data+"===============");
            if (data.length > 0) {
            	console.log(data.length+"===============");
                if(data.length==1){

                    $.each(data, function(n, value) {
                        userStr += value.sbId  + ',';
                    });
                    userStr = userStr .substring( 0, userStr.length - 1);
                    layer.open({
                        type: 2,
                        title:"查看分区商品",
                        area: ['880px', '760px'],
                        content:ctx + "/subarea/lookProduct?userStr="+userStr, //这里content是一个普通的String
                    })


                }else{
                    layer.msg("只能选择一个");
                }

            } else {
                layer.msg("请选择需要添加的商品");
            }
        })
    $(".guanlianviplevel_btn") .click(
        function() {
            var checkStatus = table.checkStatus('subareaList'), data = checkStatus.data, userStr = '';
            console.log(data+"===============");
            if (data.length > 0) {
                console.log(data.length+"===============");
                if(data.length==1){

                    $.each(data, function(n, value) {
                        userStr += value.sbId  + ',';
                    });
                    userStr = userStr .substring( 0, userStr.length - 1);
                    /*layer.open({
                        type: 2,
                        title:"查看分区商品",
                        area: ['880px', '760px'],
                        content:ctx + "/subarea/lookProduct?userStr="+userStr, //这里content是一个普通的String
                    })*/
                    layer.open({
                        type: 2,
                        title:"关联等级",
                        area: ['880px', '660px'],
                        content:ctx+"/subarea/getVip?userStr="+userStr, //这里content是一个普通的String
                    })

                }else{
                    layer.msg("只能选择一个");
                }

            } else {
                layer.msg("请选择需要添加的商品");
            }
        })





})


