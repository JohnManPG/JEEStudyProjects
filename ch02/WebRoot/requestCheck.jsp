<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考试成绩</title>
    
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
    <%
    int examResults=0;
    String str1=request.getParameter("1");//通过request对象获取客户端提交的参数，request是内置对象，所以不要创建实例
    String str2=request.getParameter("2"); //这个是表单的name
    String str3=request.getParameter("3");
    String str4=request.getParameter("4");//通过radio的名称获得radio的值
    
     if(str1==null)
     str1="";
     
      if(str2==null)
     str2="";
     
      if(str3==null)
     str3="";
     
      if(str4==null)
     str4="";
     
     if(str1.equals("B"))
        examResults++;
     
     if(str2.equals("A"))
        examResults++;
     
     if(str3.equals("A"))   //JSP中的内置对象只能在Java代码片段里用，out对象也是将内容输出到显示页面
        examResults++;
     
     if(str4.equals("C"))    
        examResults++;
     
      %>
     <h3>您本次的测试成绩是：</h3>
     <%= examResults/4*100 %>分
  </body>
</html>
