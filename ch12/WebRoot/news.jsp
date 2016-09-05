<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>评论</title>
    
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
    请发表你的评论！
    <hr>
    <s:form action="public" method="post">
        <s:textfield name="title" label="评论标题" maxLength="36"/><!-- 记住struts这样的标签表单格式 -->
        <s:textarea name="content" cols="36" rows="6" label="评论内容"/>
        <s:submit value="提交"/> <!-- 一按提交按钮，那么struts中的内置params拦截器将请求中的参数解析出来，存入到Action的属性中，找对应的属性 -->
    </s:form>
  </body>
</html>
