<%@ page import="java.util.Random" %>
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
  
  <body>                   <!-- class里面需要加双引号 -->
    <jsp:useBean id="guess" class="game.GuessNumber" scope="session"></jsp:useBean>
    <%
    //实例化一个对象，该对象可以产生随机数
    Random  randomNumbers = new Random();
    //randomNumbers对象调用nextInt()方法生成一个随机数
    //randomNumbers.nextInt(100)表示生成0~99的任意
     int answer=1+randomNumbers.nextInt(100);
     /**使用URL重写已知的数据时要注意为了保证会话跟踪的正确性，所有的链接和重定向语句中的URL都需要调用encodeURL()或encoderedirectURL()方法进行编码*/
     String str = response.encodeRedirectUrl("game/guess.jsp");
     %>                                      <!--guess是JavaBean的实例名称 -->
     <jsp:setProperty property="answer" name="guess" value="<%=answer%>"/>    <!-- value可以接受动态值 -->
     <h3>随系统随机生成了一个1~100的整数，请猜是什么？</h3>
     <hr>
     <form action="<%=str%>" method="get">
                 输入你猜的数：<input type="text" name="guessNumber">
               <input type="submit" value="提交">
     </form>
  </body>
</html>
