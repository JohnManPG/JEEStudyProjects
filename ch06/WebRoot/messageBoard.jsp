<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <!-- -这个留言系统jsp负责显示页面。servlet负责处理业务逻辑，将数据存储在JavaBean中 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基于jsp+servlet的留言系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="image/f.jpg">
  <form action="AddMessageServlet" method="post">          <!--../从上一级开始找 -->
  留言者：<input type="text" name="author" size="30">
  <br>
  留言标题：<input type="text" name="title" size="30">
  <br>
  留言内容：<textarea rows="8" cols="30" name="content"></textarea>
  <br>
  <input type="submit" value="提交">
  <input type="reset" value="重置">
  <a href="showMessage.jsp">查看留言</a>
  </form>    
  </body>
</html>
