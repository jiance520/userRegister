<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'form.jsp' starting page</title>

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
        *{
            margin: 0 auto;
        }
    </style>
</head>

<body>

<div class="easyui-panel" title="添加新用户" style="width:400px">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" method="post">
            <table cellpadding="5">
                <tr>
                    <td>用户名:</td>
                    <td><input class="easyui-textbox" type="text" name="uname" data-options="required:true,missingMessage:'字段不能为空'" /></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input class="easyui-textbox" type="password" name="upwd" data-options="required:true,missingMessage:'字段不能为空'" /></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td>
                        <select name="sex" >
                            <option value="1" data-options="required:true" selected="selected" class="easyui-textbox">男</option>
                            <option value="0" data-options="required:true">女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>身份证:</td>
                    <td><input class="easyui-textbox" type="text" name="cardNo" data-options="required:true" /></td>
                </tr>
                <tr>
                    <td>邮箱:</td>
                    <td><input class="easyui-textbox" type="email" name="email" data-options="required:true,validType:'email',invalidMessage:'邮箱格式不对'" /></td>
                </tr>
                <tr>
                    <td>手机:</td>
                    <td><input class="easyui-textbox" type="number" name="mobile" data-options="required:true,validType:'number',invalidMessage:'格式不对'" /></td>
                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">新增</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
        </div>
    </div>
</div>

</body>
</html>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.easyui.min.js"></script>
<script type="text/javascript">
    function submitForm(){
    	$('#ff').form('submit', {
            url:'RegisterAction',
            onSubmit: function(){
                  if(confirm("是否继续增加？")==false){
                	  window.location.href="editor.jsp";
                	  return false;
                  }
            },
            success:function(data){
                alert(data)
            }
        });
    	//$('#ff').submit();  
    }    
    function clearForm(){
        $('#ff').form('clear');
    }

</script>