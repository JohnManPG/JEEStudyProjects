<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件上传成功</title>
    
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
    <h3>文件上传成功</h3>
      <hr>
      文件标题：<s:property value="+title"/><br>    <!-- 只要是外部标签都可以将内容输出到视图上 -->
      <s:property value="uploadFileName"/><br>
      <!-- save是在项目目录下创建的文件夹，用来保存上传的文件，上传后文件将被保存在tomcat/webapp/ch11/save目录下，在开发工具中使用时需在ch11/web/中新建一个文件夹save -->
     <img  src="<s:property value="'./save/'+uploadFileName"/>"/>
     <br>
  </body>
</html>
