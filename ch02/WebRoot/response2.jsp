<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>response对象应用实例</title>
    
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
    <hr>
    <% response.setBufferSize(10240); %>  <!-- 缓冲区就是缓冲区，响应的缓冲区的大小，没有什么需要特别理解的 -->
    <%=response.getBufferSize() %>  <!-- -获得缓冲区的大小 -->
    <br>
    <%
    response.setCharacterEncoding("UTF-8");//设置字符编码的方式
     %>
     <%=response.getCharacterEncoding() %>
     网站友情链接：
     <hr>
     <form action="responseCheck2.jsp" method="post">    <!-- 方法为post，不能再URL上看到相应的信息 -->
     <select name="link">         <!-- select只是表单的一种形式，有很多中表单，定义名称就可以获得该表单的信息 -->
     <option value="qhdxcbs" selected>百度首页</option>
     <option value="jyb" >中华人民共和国教育部</option>
     </select>
     <input type="submit" name="submit" value="确定"/>
     </form>
  </body>
</html>
