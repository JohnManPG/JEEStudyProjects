<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><!-- 使用UTF-8编码 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>out对象应用实例</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>     <!-- out为Jsp的内置对象，可以直接拿来用 -->
    <%
    /**两个百分号包含的是Java代码*/
    String str ="我将成为一个优秀的Java工程师";
    out.print(str);    //打印至控制台
    out.print("知识改变命运，技术改变生活<br>");//这些HTML代码是浏览器解析的，打印到浏览器
    out.print("当前可用缓冲区大小："+out.getRemaining()+"<br>");//这些HTML标签相当于字符串
    out.flush();//刷新缓冲区
    out.print("当前可用缓冲区大小："+out.getRemaining()+"<br>");//这些HTML标签相当于字符串
    out.clearBuffer();//清理一下当前缓冲区
    out.print("当前可用缓冲区大小："+out.getRemaining()+"<br>");//这些HTML标签相当于字符串
    out.flush();
     %>     
  </body>
</html>
