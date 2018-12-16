<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'demo2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/themes/icon.css">
	<style type="text/css">
		
	</style>
  </head>
  
  <body>
	
	<div style="margin:20px 0;"></div>
	
	<table id="dg" class="easyui-datagrid" title="数据展示" style="width:700px;height:250px"
			data-options="singleSelect:false,collapsible:true,url:'allAction',method:'post'">
	</table>

  </body>
</html>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.easyui.min.js"></script>
<script type="text/javascript">
       
	$('#dg').datagrid({
	    columns:[[
			{field:'ck',checkbox:true},
			{field:'usidint',title:'usidint-ID',width:60,editor:'numberbox'},
			{field:'uname',title:'用户名',width:100,editor:'text'},
			{field:'upwd',title:'密码',width:80,align:'right',editor:'text'},
			{field:'sex',title:'性别',width:80,align:'right',editor:'numberbox'},
			{field:'cardNo',title:'身份证',width:150,editor:'text'},
			{field:'email',title:'邮箱',width:50,align:'center',editor:'text'},
			{field:'mobile',title:'手机',width:50,align:'center',editor:'numberbox'},
			{field:'action',title:'操作',width:70,align:'center',
			    formatter:function(value,row,index){ // value ：当前值，row:行对象，index:行下标
			        if (row.editing){ // row.editing 是否被编辑
			            var s = '<a href="javascript:void(0)"  onclick="saverow('+index+')">保存</a> ';
			            var c = '<a href="javascript:void(0)"  onclick="cancelrow('+index+')">取消l</a>';
			            return s+c;
			        } else {
			            var e = '<a href="javascript:void(0)"  onclick="editrow('+index+')">编辑</a> ';
			            var d = '<a href="javascript:void(0)"  onclick="deleterow('+index+')">删除</a>';
			            return e+d;
			        }
			    }
			}
	    ]],
		onBeforeEdit:function(index,row){
		    row.editing = true;
		        //重新刷新行
		        $('#dg').datagrid('refreshRow', index);
		    },
	    onAfterEdit:function(index,row){
	        row.editing = false;
	        $('#dg').datagrid('refreshRow', index); 
	    },
	    onCancelEdit:function(index,row){
	        row.editing = false;
	        $('#dg').datagrid('refreshRow', index);
	    } ,
	    pagination:true,
	    pageSize:2,
	    pageList:[2,4,6] 
	}) ;
	//-----
    function editrow(index){
	    // 开始编辑，发送命令
	    $('#dg').datagrid('beginEdit', index);
	}
	function deleterow(index){
	    $.messager.confirm('Confirm','Are you sure?',function(r){
	        if (r){
	           // 得到所有行
	           var rows = $('#dg').datagrid('getRows');
	           //alert(rows.length);
	           // 根据下标拿当前行的数据
	           var usidint = rows[index].usidint ;
	           // 发送ajax
	           $.post('delRegister',{usidint:usidint},function(data){
	                if(data == 'true'){
		                // 删除1行，发命令 
		                $('#dg').datagrid('deleteRow', index);
		                $('#dg').datagrid('refreshRow', index);
	                }
	           });
	           
	        }
	    });
	}
	function saverow(index){
	   // 结束编辑 
	    $('#dg').datagrid('endEdit', index);
	}
	function cancelrow(index){
	    $('#dg').datagrid('cancelEdit', index);
	}
</script>
