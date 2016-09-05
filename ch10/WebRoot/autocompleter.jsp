<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主要了解JSON</title>
    
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
    <s:url id="getList"></s:url>
    1.获取服务端的List
    <hr>
    选择你喜欢的旅游城市：
    <br>
    <sx:autocompleter name="a1" href="%{getList}"></sx:autocompleter>
    <hr>
    2.设置autoComplete="false":
    <br>
    选择你喜欢的旅游城市：
     <sx:autocompleter name="a1" href="%{getList}" autoComplete="false"></sx:autocompleter>
     <hr>
     3.设置showDownArrow="false":
     <br>
     选择你喜欢的旅游城市：
     <sx:autocompleter name="a1" href="%{getList}" showDownArrow="false"></sx:autocompleter>
     4.设置searchType="substring":
     <br>
       选择你喜欢的旅游城市：
     <sx:autocompleter name="a1" href="%{getList}" searchType="substring"></sx:autocompleter>
   <hr>
  </body>
</html>
