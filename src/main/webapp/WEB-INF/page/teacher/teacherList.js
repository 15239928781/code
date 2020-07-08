layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table','laytpl'],function(){
	var form = layui.form,table = layui.table;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery,
            active = {
                search : function() {
                    var tName = $('#tName');
                    //执行重载
                    table
                        .reload(
                            'carouselList',
                            {
                                page : {
                                    curr : 1
                                    //重新从第 1 页开始
                                },
                                where : {
                                    //key: {
                                    tName : tName
                                        .val(),
                                    //}
                                }
                            });
                }
            };
		//数据表格
		table.render({
			id:'carouselList',
		    elem: '#carouselList'
		    ,url: ctx+'/sys/getTeacherList' //数据接口
		    ,cellMinWidth: 80
		    ,limit:10//每页默认数
		    ,limits:[10,20,30,40]
		    ,cols: [[ //表头
              {type:'checkbox'}
              ,{field:'tId', title: 'ID', sort: true}
              ,{field:'tName', title: '讲师名称'}
              ,{field:'tPosition', title: '讲师描述'}
			  ,{field:'tPic', title: '分类图片',templet:'#tableImg'}
              ,{title: '操作',toolbar: '#barEdit'}
		    ]]
				,page: true //开启分页
            ,where: {timestamp: (new Date()).valueOf()}
		  });
		//监听工具条
		  table.on('tool(test)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'del'){
		      layer.confirm('真的删除行么?', function(index){
		    	  $.ajax({
		    		  url:ctx+'/sys/delTeacherById?id='+data.tId,
		    		  type : "get",
		    		  success : function(d){
		    			  if(d.code==0){
		    				  table.reload('carouselList', {})
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
		    	  title:"编辑分类信息",
		    	  area: ['380px', '360px'],
		    	  content:ctx+"/sys/editCategory?id="+data.tId //这里content是一个普通的String
		      })
		    }
		  });

	//添加轮播
	$(".carouselAdd_btn").click(function(){
		layer.open({
	    	  type: 2,
	    	  title:"添加分类信息",
	    	  area: ['380px', '360px'],
	    	  content:ctx+"/sys/addCategory", //这里content是一个普通的String
	      })
	})
	


	
	//批量删除角色
	$(".batchDel").click(function(){
		var checkStatus = table.checkStatus('carouselList')
	      ,data = checkStatus.data,carouselStr='';
//	      layer.alert(JSON.stringify(data));
		if(data.length>0){
			$.each(data, function (n, value) {
				carouselStr+=value.tId+',';
	          });
			carouselStr=carouselStr.substring(0,carouselStr.length-1);
			  layer.confirm('真的要删除<strong>'+data.length+'</strong>条数据吗？', function(index){
				//调用删除接口
				  $.ajax({
			    		  url:'delTeacher?carouselStr='+carouselStr,//接口地址
			    		  type : "get",
			    		  success : function(d){
			    			  if(d.code==0){
			    				//重载表格
			    				table.reload('carouselList', {})
                                  layer.msg("删除成功！", {
                                      icon : 1
                                  });
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

//格式化时间
function formatTime(datetime,fmt){
	if(datetime==null||datetime==0){
		return "";
	}
	if (parseInt(datetime)==datetime) {
	    if (datetime.length==10) {
	      datetime=parseInt(datetime)*1000;
	    } else if(datetime.length==13) {
	      datetime=parseInt(datetime);
	    }
	  }
	  datetime=new Date(datetime);
	  var o = {
	  "M+" : datetime.getMonth()+1,                 //月份   
	  "d+" : datetime.getDate(),                    //日   
	  "h+" : datetime.getHours(),                   //小时   
	  "m+" : datetime.getMinutes(),                 //分   
	  "s+" : datetime.getSeconds(),                 //秒   
	  "q+" : Math.floor((datetime.getMonth()+3)/3), //季度   
	  "S"  : datetime.getMilliseconds()             //毫秒   
	  };   
	  if(/(y+)/.test(fmt))   
	  fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));   
	  for(var k in o)   
	  if(new RegExp("("+ k +")").test(fmt))   
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	  return fmt;
}
