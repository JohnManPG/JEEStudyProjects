<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %><!-- 这些都涉及到路径问题 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 这个项目终于做完了，也了解了，一些逻辑上的需要多敲代码才能解决，语法上的错误只要学过基础就可以避免，所以语法上的错误现在已经不需要考虑了 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:text name="基于SH的登录和注册系统"></s:text></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!-- 使用了struts2的试图组件，采用MVC设计模式后前提与后台全部分开来，为了满足各种的用户交互需要，开发更友善的页面，所以有了前端这个职位，减轻web开发中后台开发者的负担 -->
  <body bgcolor="#CCCCFF">  <!-- struts2的表单标签，使用post方法 -->
  <s:form action="login" method="post">
    <br><br>
    <table border="1" align="center" bgcolor="#AABBCCDD">
    <tr>
    <td>
    <s:textfield name="userName" label="用户名字" size="16"/>    
    </td>
    </tr>
    
    <tr>
    <td>
    <s:password name="password" label="用户密码" size="18"/>    
    </td>
    </tr>    
    <tr>    
   <td colspan="2" align="center">
    <s:submit value="登录"></s:submit>   
    </td>
    </tr>
    
    <tr>
    <td colspan="2" align="center">     <!-- 这个类似重定向，简单的使用a标签进行页面的链接 -->
      <s:a href="http://localhost:8080/ch14/register.jsp">注册</s:a>
    </td>
    </tr>    
    </table>
  </s:form>   
  </body>
</html>
