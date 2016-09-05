<%@ page import="java.util.Enumeration" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>request对象应用实例</title>
    
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
  <hr>
  <%
  request.setAttribute("name", "小强");
  request.setAttribute("password", "123456");
  request.setAttribute("email", "sanz@163.com");//这相当于建立了一个映射关系
  request.removeAttribute("password");
  Enumeration e=request.getAttributeNames();
  String attrname;
  while (e.hasMoreElements()){
       attrname=e.nextElement().toString();//toString 方法是返回该对象的字符串表示
       out.print(attrname+"="+request.getAttribute(attrname)+"<br>");
  }
       request.setCharacterEncoding("UTF-8"); 
   %>
   <%= request.getCharacterEncoding() %>
   Content Length:<%= request.getContentLength() %><br>
   Content Type:<%= request.getContentType() %><br>
   <%=request.getContextPath() %><br>
   服务器地址：<%=request.getLocalAddr() %><br>
   服务器名称：<%=request.getLocalName() %><br>
   <%=request.getMethod() %><br>
   <%=request.getProtocol() %><br>
   客户端地址：<%=request.getRemoteAddr() %><br>
   客户端名称：<%=request.getRemoteHost() %><br>
   客户端端口：<%=request.getRemotePort() %><br>
   验证用户名：<%=request.getRemoteUser() %><br>
   获取sessionID：<%=request.getRequestedSessionId() %><br>
   请求URI:<%=request.getRequestURI() %><br>         <!-- 第一次访问是没有sessionID的，只有在访问第二次时才有，通过cooike传入 -->
   请求URL:<%=request.getRequestURL() %><br>
   服务器名字：<%=request.getServerName() %><br>
   服务器端口：<%=request.getServerPort() %><br>
   <%=request.getServletPath() %><br>
   <%=request.getSession().getId() %><br>
   请求的会话ID是否通过cookie传入：
   <%=request.isRequestedSessionIdFromCookie() %><br>
   请求的会话ID是否通过URL传入：
   <%=request.isRequestedSessionIdFromURL() %><br>
   请求的会话ID是否依然有效：
   <%= request.isRequestedSessionIdValid() %><br>
   <%=request.isSecure() %><br>
   <hr>     
  </body>
</html>
