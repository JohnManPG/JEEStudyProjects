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
    
    <title><s:text name="学生信息管理系统-删除"></s:text></title>
    
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
   <s:a href="http://localhost:8080/ch15/findMessage.jsp">
     修改学生信息 
     </s:a>
  </td>
  
  <td width="25%">
  
    删除学生信息
 
  </td>
  </tr>
  </table>
  <br>
  
  <hr color="red">
  <font color="red" size="6">删除学生信息</font>
  </s:div>
     <s:form action="deleteMessageAction" method="post">
     <table align="center" width="40%" border="5">
     <tr>
     <td>请选择要删除的学生学号：</td>
     <td>
     <select name="id">
     <%
     ArrayList list=(ArrayList) session.getAttribute("allInfo");
     if(list.isEmpty()){
      %>
      <option value="null">null</option>
      <%
      }else{
      for(int i=0;i<list.size();i++){
      Stuinfo info=(Stuinfo)list.get(i);
       %>
       <option value="<%=info.getId()%>">
       <%=info.getId()%></option>
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
