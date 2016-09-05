<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>pagecontext对象应用实例</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><!-- 先获取内置对象实例，再调用内置对象的getAttribute()方法，获取内置对象中的值 -->
  <h2>pagecontext对象的作用是获取内置对象的值：</h2>
    <h3>使用pagecontext对象获取其他内置对象中的值：</h3>
    <hr>
    <%
    request.setAttribute("name", "Java程序设计与项目实训教程(清华大学出版社)");//设定对象中的值
    session.setAttribute("name", "郑州轻工业学院");//为对象初始化
    application.setAttribute("name", "河南省郑州市");
    
     %>
     request对象中的值：<%=pageContext.getRequest().getAttribute("name") %>
     session对象中的值：<%=pageContext.getSession().getAttribute("name") %>//通过对象的引用，先获取对象，再调用对象的方法求值
     application对象中的值：<%=pageContext.getServletContext().getAttribute("name") %>
  </body>
</html>
