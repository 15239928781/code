layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table','laytpl'],function(){
	var form = layui.form,table = layui.table;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		//数据表格
		table.render({
			id:'levelList',
		    elem: '#levelList'
		    ,url: ctx+'/level/list' //数据接口
		    ,cellMinWidth: 80
		    ,limit:10//每页默认数
		    ,limits:[10,20,30,40]
		    ,cols: [[ //表头
              {type:'checkbox'}
              ,{field:'leId', title: 'ID', sort: true}
              ,{field:'leName', title: '级别名'}
              ,{field:'leDiscount', title: '视频折扣'}
              ,{field:'leMinscore', title: '最低积分'}
              ,{field:'leMaxscore', title: '最高积分'}
              ,{title: '操作',toolbar: '#barEdit'}
		    ]]
				,page: true //开启分页
		  });
		//监听工具条

		  table.on('tool(test)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'del'){
		      layer.confirm('确定要设置吗？', function(index){
		    	  $.ajax({
		    		  url:ctx+'/users/setvip/'+data.leId+'/'+uId,
		    		  type : "get",
		    		  success : function(d){
		    			  if(d.code==0){
		    				  table.reload('levelList', {})
                              layer.msg("删除成功！", {
                                  icon : 1
                              });

                              //删除成功，刷新父页面
                              /*parent.location
                                  .reload();
                              layer.msg("删除成功！", {
                                  icon : 1
                              });*/
		    			  }else{
		    				  layer.msg("权限不足，联系超管！",{icon: 5});
		    			  }
		    		  }
		    	  })
		        //layer.close(index);
                  parent.location
                      .reload();
                  layer.msg("删除成功！", {
                      icon : 1
                  });
		      });
		    } else if(obj.event === 'edit'){
		      layer.open({
		    	  type: 2,
		    	  title:"编辑会员等级",
		    	  area: ['380px', '460px'],
		    	  content:ctx+"/level/editLevel?id="+data.leId //这里content是一个普通的String
		      })
		    }
		  });

	//添加轮播
	$(".carouselAdd_btn").click(function(){
		layer.open({
	    	  type: 2,
	    	  title:"添加会员等级",
	    	  area: ['380px', '460px'],
	    	  content:ctx+"/level/addLevel", //这里content是一个普通的String
	      })
	})
	


	
	//批量删除角色
	$(".batchDel").click(function(){
		var checkStatus = table.checkStatus('levelList')
	      ,data = checkStatus.data,carouselStr='';
//	      layer.alert(JSON.stringify(data));
		if(data.length>0){
			$.each(data, function (n, value) {
				carouselStr+=value.leId+',';
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
			    				table.reload('levelList', {})
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
	
})


