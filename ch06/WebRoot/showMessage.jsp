<%@page import="JavaBean.MessageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示留言页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="image/f.jpg">
  <%
  ArrayList wordlist =(ArrayList)application.getAttribute("wordlist");
  if(wordlist==null||wordlist.size()==0)
  out.println("没有留言可显示");
  else{
  for(int i = wordlist.size()-1;i>=0;i--){
  
  MessageBean mm=(MessageBean)wordlist.get(i);    //像写留言和写博客这种对象的存储使用ArryList集合比较好么？？？？
  
   %>
   
            留言者：<%=mm.getAuthor()%>
    <p>留言时间： <%=mm.getTime()%> </p> 
    <p>留言标题：<%=mm.getTitle()%></p>
    
    <p> 
   留言内容：<textarea rows="8" cols="30">
   <%=mm.getContent() %>
   </textarea>
   </p>
   <a href="messageBoard.jsp"> 我要留言</a>
   <hr>
   <%
   }
   }
    %>    
  </body>
</html>
