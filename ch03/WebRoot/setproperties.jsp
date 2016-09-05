<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JavaBean应用实例</title>
    
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
    <form action="" method="post">    <!-- 如果action没有值，意思是说将表单信息提交给页面本身 -->
       输入用户名：<input type="text" name="userName"/><br>
        输入密码：   <input type="password" name="password"/><br>
          <input type="submit" value="确定"/><br>    <!-- 一按提交按钮，那么就会触发表单中的action属性  -->
          <input type="reset" value="清除"/><br>
       
    </form>
    <jsp:useBean id="login" class="JavaBean.Login"></jsp:useBean>
    <jsp:setProperty property="*" name="login"/>   <!-- 使用*号意思是如果表单中的名称和JavaBean的属性名相同，那么使用setproperty动作，可以自动找到相对应的值进行一一对应并进行赋值 -->
    <p>用户名是：</p>
    <jsp:getProperty property="userName" name="login"/>
    <p>密码是：</p>
    <jsp:getProperty property="password" name="login"/>
  </body>
</html>
