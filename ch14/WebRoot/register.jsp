<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:text name="基于SH的登录注册系统"></s:text></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#CCCCFF">
  <s:form action="register" method="post">
     <br><br><br><br><br>
      <table border="1" align="center" bgcolor="#AABBCCDD">
    <tr>
    <td>
    <s:textfield name="userName" label="用户名字" size="16"/>    
    </td>
    </tr> 
    <tr>
    <td>
    <s:password name="password1" label="用户密码" size="18"/>    
    </td>
    </tr> 
    <tr>
    <td>
    <s:password name="password2" label="再次输入密码" size="18"/>    
    </td>
    </tr>       
    <tr>
    <td colspan="2" align="center">
    <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" value="清空"/>    
    </td>
    </tr>   
    <tr>
    <td colspan="2" align="center">
     <s:a href="http://localhost:8080/ch14/login.jsp">返回</s:a>
    </td>
    </tr>   
    </table>
    </s:form>
  </body>
</html>
