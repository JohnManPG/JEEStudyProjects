<%@ page import="java.sql.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>prepareStatement对象应用实例</title>
    
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
    <br>
    <br>
    <center>
    <h2>使用PrepareStatement类访问</h2>
     <table border="1" align="center">
    <tr>
    <th width="87" align="center">学号</th>
    <th width="87" align="center">姓名</th>
    <th width="87" align="center">性别</th>
    <th width="87" align="center">年龄</th>
    <th width="87" align="center">体重</th>
    </tr>
    <%
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=gbk";
    String user="root";
    String password="mysql";
    
    Connection conn = DriverManager.getConnection(url,user,password);//这样的引用类型不用加引号
    String sql ="select * from info where studentAge>=? and studentAge<=?";
    
    PreparedStatement stmt=conn.prepareStatement(sql);   
    stmt.setInt(1,18);    //第一个参数是IN参数在SQL语句中的位置，第二个是为其IN参数赋值
    stmt.setInt(2,20);     //IN在语句中用？表示
     ResultSet rs=stmt.executeQuery();
    while(rs.next()){
     %>
     <tr>      <!-- 一次完成一行 -->
     <td><%=rs.getString("studentNumber") %></td>
     <td><%=rs.getString("studentName") %></td>
     <td><%=rs.getString("studentsex") %></td>
     <td><%=rs.getString("studentAge") %></td>
     <td><%=rs.getString("studentWeight") %></td>
     </tr>
     <%
     }
     rs.close();
     stmt.close();//从上层往下层关
     conn.close();
      %>
      </table>
      <hr>
    </center>
  </body>
</html>
