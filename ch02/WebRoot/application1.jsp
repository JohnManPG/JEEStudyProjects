<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>application对象应用实例</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!-- application对象用来保存Java  Web应用程序使用的变量，其最大的特点就是没有生命周期 -->
  <body>
     <%
     //获取一个object对象
     String strnum=(String)application.getAttribute("count");
     int count=1;
     //如果一个object对象存在说明有用户访问
     if(strnum!=null)
     //类型转化后值加1
     count=Integer.parseInt(strnum)+1;
     //人数值加1后重新对count赋值
     application.setAttribute("count", String.valueOf(count));
     
     
      %>
      您是第<%=application.getAttribute("count") %>位访问者！
  </body>
</html>
