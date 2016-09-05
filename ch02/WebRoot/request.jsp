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
   <h3>第五章测试题</h3>
   <hr>
   <form action="requestCheck.jsp" method="get">
   1.response对象的方法作用是().
   <br>
   <input type="radio" name="1" value="A">添加HTTP头部信息A<br>  <!-- radio属性时单选，提交到服务器上的值是radio的值，并不是后面的答案 -->
   <input type="radio" name="1" value="B">添加HTTP头部信息B<br>
   <input type="radio" name="1" value="C">添加HTTP头部信息C<br>
   <input type="radio" name="1" value="D">添加HTTP头部信息D<br>
   2.郑州轻工业学院建校是什么时间？
   <br>
   <input type="radio" name="2" value="A">1965<br>
   <input type="radio" name="2" value="B">1966<br>
   <input type="radio" name="2" value="C">1967<br>
   <input type="radio" name="2" value="D">1968<br>
   3.汪想的出生日期是什么时间？
   <br>
   <input type="radio" name="3" value="A">1992<br>
   <input type="radio" name="3" value="B">1993<br>
   <input type="radio" name="3" value="C">1994<br>
   <input type="radio" name="3" value="D">1995<br> 
   4.曾瑞的出生日期是什么时间？
   <br>
   <input type="radio" name="4" value="A">1992<br>
   <input type="radio" name="4" value="B">1992<br>
   <input type="radio" name="4" value="C">1992<br>
   <input type="radio" name="4" value="D">1992<br>
   
   <input type="submit" value="考试完成">  <!-- 设定提交类型，即submit类型 -->
   </form>
  </body>
</html>
