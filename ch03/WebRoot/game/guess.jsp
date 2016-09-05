<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>猜数字游戏</title>
    
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
    <jsp:useBean id="guess" class="game.GuessNumber" scope="session"></jsp:useBean>
    <%
    String strGuess=response.encodeRedirectUrl("game/guess.jsp");    //这个用response对象，为这个URL编码
    String strGetNumber=response.encodeRedirectUrl("game/getNumber.jsp");
     %>
     <hr>    
     <!-- param属性时可选的，指定用哪个请求参数作为Bean属性的值如果当前请求没有参数，则什么事情也不做，
                系统不会把null传递给Bean属性的set方法。因此，可以让Bean自己提供默认属性值，只有在请求参数明确指定了新值时才修改默认属性值 -->
     <jsp:setProperty property="guessNumber" name="guess" param="guessNumber"/><!-- 直接用jsp:setproperty动作获取表单提交的信息并且为JavaBean中的属性赋值 -->
           这是第<jsp:getProperty property="guessCount" name="guess" />次猜
     <jsp:getProperty property="result" name="guess"/>
     你猜的数是：<jsp:getProperty property="guessNumber" name="guess"/>
     <%
     if(guess.isRight()==false){
      %>
      <form action="<%=strGuess%>" method="get">
      请再猜一次：<input type="text" name="guessNumber">
      <input type="submit" value="提交">
      </form>
      <%
      }
       %>
       <hr>
       <a href="<%=strGetNumber%>">重新开始猜数</a>
  </body>
</html>
