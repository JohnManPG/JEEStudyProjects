<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车页面</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    String gn = request.getParameter("goodname");
    session.setAttribute("goods", gn);
    String 客户=(String)session.getAttribute("customer");
    String 姓名=(String)session.getAttribute("name");
    String 商品=(String)session.getAttribute("goodname");
     %>
     <h3>结账信息：</h3>
     <hr>
     <%=客户 %>的姓名是：<%=姓名 %>
     <br>
             你购买的商品是：<%=商品 %>
  </body>
</html>
