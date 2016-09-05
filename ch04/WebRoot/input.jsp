<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增删改查实例</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="CCCFFF">
    <br><br>
    <center>
    <form action="inputCheck.jsp" method="get">
    <h2>输入要添加学生的信息：</h2>
    <hr>
    <table border="0" width="200">
    <tr>
    <td>学号</td>
    <td><input type="text" name="studentNumber"></td>
    </tr>
    <tr>
    <td>姓名</td>
    <td><input type="text" name="studentName"></td>
    </tr>
    <tr>
    <td>性别</td>
    <td><input type="text" name="studentSex"></td>
    </tr>
    <tr>
    <td>年龄</td>
    <td><input type="text" name="studentAge"></td>
    </tr>
    <tr>
    <td>体重</td>
    <td><input type="text" name="studentWeight"></td>
    </tr>
    <tr align="center">
    <td colspan="2">
    <input name="sure" type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
    <input name="clear" type="submit" value="取消">
    </td>   
    </tr>
    </table>
    </form>
    </center>
  </body>
</html>
