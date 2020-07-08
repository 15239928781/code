layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table','laytpl'],function(){
	var form = layui.form,table = layui.table;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		//数据表格
		table.render({
			id:'integralUseList',
		    elem: '#integralUseList'
		    ,url: ctx+'/sys/getCustomerList' //数据接口
		    ,cellMinWidth: 80
		    ,limit:10//每页默认数
		    ,limits:[10,20,30,40]
		    ,cols: [[ //表头
              {type:'checkbox'}
              ,{field:'id', title: 'ID', sort: true}
              ,{field:'tel', title: '手机号'}
              ,{field:'type', title: '手机号',templet : '#sexTpl'}
              ,{title: '操作',toolbar: '#barEdit'}
		    ]]
				,page: true //开启分页
		  });
		//监听工具条
		  table.on('tool(test)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'edit'){
		      layer.open({
		    	  type: 2,
		    	  title:"编辑手机号",
		    	  area: ['350px', '260px'],
		    	  content:ctx+"/sys/editCustomer?id="+data.id //这里content是一个普通的String
		      })
		    }
		  });

	//添加轮播
	$(".carouselAdd_btn").click(function(){
		layer.open({
	    	  type: 2,
	    	  title:"添加手机号",
	    	  area: ['350px', '260px'],
	    	  content:ctx+"/sys/addCustomer", //这里content是一个普通的String
	      })
	})
	



		
	})
	


