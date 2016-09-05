<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="java.util.ArrayList,PO.Stuinfo"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:text name="学生信息管理系统-查看"></s:text></title>
    
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
              查看学生信息
    </td>
    <td width="25%">
    <s:a href="http://localhost:8080/ch15/addMessage.jsp">添加学生信息</s:a>  
    </td>
    
     <td width="25%">
    <s:a href="http://localhost:8080/ch15/findMessage.jsp">修改学生信息</s:a>  
    </td>
    
     <td width="25%">
    <s:a href="http://localhost:8080/ch15/deleteMessage.jsp">删除学生信息</s:a>  
    </td>
    </tr>
    </table>
    <br>
    <hr color="red">
    <br> <br> <br>
    <span>你要查询的数据表中共有：<%=request.getSession().getAttribute("count") %>人</span>
    </s:div>
    <table align="center" width="80%" border="5">
    <tr>
    <th>记录条数</th>
    <th>学号</th>
    <th>姓名</th> 
    <th>性别</th>
    <th>年龄</th>
    <th>体重</th>
    </tr>
      <%
      ArrayList list =(ArrayList) session.getAttribute("allInfo");
      if(list.isEmpty()){
       %>
       <tr>
       <td align="center"><span>暂无学生信息！</span></td>
       </tr>
       <%
       }else{
       for(int i=0;i<list.size();i++){
       Stuinfo info = (Stuinfo) list.get(i);
        %>
        <tr>
        <td align="center"><%=i+1%></td>
        <td><%=info.getId() %></td>
        <td><%=info.getName() %></td>
        <td><%=info.getSex() %></td>
        <td><%=info.getAge() %></td>
        <td><%=info.getWeight() %></td>
        
        </tr>
        <%
        }       
        }
         %>
    </table>
  </body>
</html>
