<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>       
               <!-- --前半部分的名字必须和struts.xml中配置的action的名字是一样的，必须 -->
  <body>      <!-- 有些知识点你不用懂，你记住就行了 -->
    <form action="login.action" method="post">    <!-- -要告诉struts的核心控制器提交过去的是一个Action ，才会给你转到struts.xml文件夹中，所以你的后缀名必须是Action-->
    用户名：<input name="useName" type="text" size="24">
    <br>
    密码：<input name="password" type="password" size="26">
    <br>
    <input type="submit" value="登录">
    </form>
    <hr>
  </body>
</html>
