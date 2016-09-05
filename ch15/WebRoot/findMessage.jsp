<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,PO.Stuinfo" %>
<%@ taglib prefix="s"  uri="/struts-tags"%>
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
  <center> <font color="red" size="6">修改学生信息</font></center>
  </s:div>
  
  <s:form action="findMessageAction" method="post">
  <table align="center" width="40%" border="5">
  <tr>
  <td>请选择要修改学生的学号：</td>
  
  <td>
  <select name="id">
  <%
  ArrayList list= (ArrayList)session.getAttribute("allInfo");
  if(list.isEmpty()){
   %>
   <option value="null">null</option>
   <%
   }else{
   for(int i=0;i<list.size();i++){
   Stuinfo info = (Stuinfo)list.get(i);         //从List中获得对象
    %>
    <option value="<%=info.getId()%>"><%=info.getId()%></option>    <!-- 获得对象中的值 -->
    
  <%
  }
  }
   %>
  </select>
  </td>
  <td>
 <s:submit value="确定"></s:submit>
  </td>
  </tr>
  </table>
  </s:form>
  </body>
</html>
