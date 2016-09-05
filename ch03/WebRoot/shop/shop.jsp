<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>在线购书系统</title>
    
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
    <form action="shopCheck.jsp" method="post">
    <br>
            请选择要添加或删除图书种类：
     <hr>
              添加商品：
     <select name="item">
     <option>java程序设计1</option>
     <option>java程序设计2</option>
     <option>java程序设计3</option>
     <option>java程序设计4</option>
     <option>java程序设计5</option>    
     </select>
     <br>
     <hr>
      <input type="submit" name="submit" value="添加">
      <input type="submit" name="submit" value="删除">
    </form>
  </body>
</html>
