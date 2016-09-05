<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册成功页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><!-- --符号与括号之间需要有空格 -->
    <h1>$ {name}</h1>
    <hr>
    获取action属性：<s:property value="name"/><br>    <!-- -通过OGNL表达式输出值 -->
    获取request属性：<s:property value="#request.name"/><br>
    获取session属性：<s:property value="#session.name"/><br>
    获取application属性：<s:property value="#application.name"/><br>
  </body>
</html>
