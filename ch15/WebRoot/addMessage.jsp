<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:text name="学生信息管理系统"></s:text></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="pink"> 
  <s:div align="center">
  <hr color="red">
  <br>
  <table align="center" width="80%">
  <tr>
  <td width="25%">
  <s:a href="http://localhost:8080/ch15/lookMessage.jsp">
       查看学生信息
  </s:a>
  </td>
  
  <td width="25%">
  添加学生信息
  </td>
  
  <td width="25%">
  <s:a href="http://localhost:8080/ch15/findMessage.jsp">
  修改学生信息
  </s:a>
  </td>
  
  <td width="25%">
  <s:a href="http://localhost:8080/ch15/deleteMessage.jsp">
  删除学生信息
  </s:a>
  </td>
  </tr>
  </table>
  <br>
  
  <hr color="red">
  <center> <font color="red" size="6">添加学生信息</font></center>
  </s:div>
  <s:form action="addMessageAction" method="post">
  <table align="center" width="30%" bgcolor="gray" border="5">
    <tr>
    <td> 
    <s:textfield name="id" label="学号" maxLength="16"/>
    </td>
     <td> 
    <s:textfield name="name" label="姓名" />
    </td>
    
    <td> 
    <s:select list="{'男','女'}" label="性别" name="sex"></s:select>
    </td>
    
      <td> 
    <s:textfield name="age" label="年龄" />
    </td>
      <td> 
    <s:textfield name="weight" label="体重" />
    </td>
    <td colspan="2">
    <s:submit value="提交"></s:submit>
    <s:reset value="清除"></s:reset>
    </td>
    </tr>
  </table>
  </s:form>
  
  </body>
</html>
