<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线购书系统</title>
    
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
    <jsp:useBean id="cart" scope="session" class="shop.Shop"></jsp:useBean><!-- 实例化JavaBean -->
    <jsp:setProperty property="*" name="cart"/>
    <%cart.processRequest(request); %>
    <br>您已选购的书有：
    <ol>
    <%
    String []items=cart.getItems();
    for(int i=0;i<items.length;i++){      //循环打印
     %>
     <li><%=items[i]%></li>
     <%
     }
      %>
    </ol>
    <br><hr>
    <jsp:include page="shop.jsp"></jsp:include>
  </body>
</html>
