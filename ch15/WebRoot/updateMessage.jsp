<%@ page import="PO.Stuinfo"%>
<%@ page import="java.util.ArrayList" %>
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
    
    <title><s:text name="学生信息管理系统-修改"></s:text></title>
    
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
  <s:a href="http://localhost:8080/ch15/addMessage.jsp">
     添加学生信息
  </s:a>
  </td>
  
  <td width="25%">
     修改学生信息 
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
  <font color="red" size="6">修改学生信息</font>
  </s:div>
  <s:form action="updateMessageAction" method="post">
      <table align="center" width="30%" bgcolor="gray" border="5">
      <%
      ArrayList list = (ArrayList)session.getAttribute("oneInfo");
      Stuinfo info=(Stuinfo)list.get(0);     //List下标是从0开始的
       %>
       <tr>
       <td>学号</td>
       <td><input name="id" value="<%=info.getId()%>" readonly="readonly"></td>
       </tr>
       
       <tr>
       <td>姓名</td>
       <td><input name="name" value="<%=info.getName() %>"></td>
       </tr>
       
       <tr>
       <td>性别</td>
       <td><input name="sex" value="<%=info.getSex() %>"></td>
       </tr>
       
       <tr>
       <td>年龄</td>
       <td><input name="age" value="<%=info.getAge() %>"></td>
       </tr>
       
       <tr>
       <td>体重</td>
       <td><input name="weight" value="<%=info.getWeight() %>"></td>
       </tr>
       <tr>
       <td colspan="2">
       <s:submit value="提交"></s:submit>
       </td>
       </tr>
       <tr>
       <td align="center" colspan="2">
            <s:a href="http://localhost:8080/ch15/findMessage.jsp">返回</s:a>
       </td>
       </tr>       
      </table>
  </s:form>
  </body>
</html>
