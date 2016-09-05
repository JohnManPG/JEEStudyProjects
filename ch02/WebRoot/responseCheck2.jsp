<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>数据处理页面</title>
    
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
    String address=request.getParameter("link");  //通过select名称link,获得该表单的传输的信息
     String sub=request.getParameter("submit"); 
     
    if(address!=null){
       if(address.equals("qhdxcbs")){
           response.sendRedirect("http://www.baidu.com/");   //实现页面的重定向
           }
        else {
           response.sendRedirect("http://www.moe.edu.cn/");   //必须是response获得地址才行
        }     
    }
     %>
  </body>
</html>
