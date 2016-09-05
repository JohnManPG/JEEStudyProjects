<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>exception内置对象的实例</title>
    
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
    <h3>以下是异常信息：</h3>
    <hr>
    <%
    int x=9,y=0,z;
    try{
    z=x/y;
    }catch(Exception e){           //内置对象，内置对象就是可以在Java代码中直接使用的，就跟编写Java代码是一样的
    out.print(e.toString()+"<br>");//使用toString()方法，将对象变成字符串打印出来
    }finally{
    out.print("产生了除以0的错误");
    }
     %>
  </body>
</html>
