<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   <!-- 这是服务端的jsp页面，当访问该网页时，jsp容器会自动创建一个session对象 -->
    
    <title>session对象应用实例</title>
    
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
       int number=10001;
       //从session对象获取number
       Object obj=session.getAttribute("number");
       if(obj==null){
       //设定session对象的变量的值
       session.setAttribute("number", String.valueOf(number));
       }else{
       //取得session对象中的number变量
       number = Integer.parseInt(obj.toString());
       //统计页面的访问次数
       number++;
       //设定session对象的number变量值
       session.setAttribute("number", String.valueOf(number));
       }
      %>
      你是第<%=number %>个用户访问本网站。
  </body>
</html>
