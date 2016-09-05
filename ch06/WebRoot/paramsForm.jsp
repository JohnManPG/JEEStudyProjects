<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>servlet应用实例</title>
    
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
     <form action="ThreeParams" method="post">
     <p>数据1<input type="text" name="gr1"></p>
     <br>
      <p>数据2<input type="text" name="gr2"></p>
     <br>
     <p>数据3<input type="text" name="gr3"></p>
     <br>
     <p>
     <input type="submit" value="提交">
     <input type="reset" value="清除">
     </p>
     </form>
  </body>
</html>
