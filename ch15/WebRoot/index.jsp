<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    <!-- 导入struts的标签 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:text name="基于SH的学生信息管理-起始页"></s:text></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body bgcolor="#CCCCFF">
  <s:div align="center">
    <br><br><br><br>
    <font color="black" size="6">基于Struts+Hibernante的学生信息管理系统实例，可对学生信息进行增删改查！</font>
    <br><br><br><br>
   <s:a href="lookMessageAction">     <!-- 使用struts的a标签，启动一个action -->
   <font color="blue" size="6">点此进入</font>
   </s:a>
  </s:div>
  </body>
</html>
