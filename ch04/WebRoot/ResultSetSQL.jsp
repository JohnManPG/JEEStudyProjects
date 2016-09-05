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
    
    <title>ResultSet集合应用实例</title>
    
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
    <h2>使用ResultSet对象</h2>
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
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    String sql="select * from info";              //查看Result对象的API文档，看看每个字段的含义，在创建statement对象时，往里传参，确定Result对象的类型
    ResultSet rs = stmt.executeQuery(sql);
    rs.last();
    rs.afterLast();        //读出来的数据也是从最后一行到第一行，必须放到最后一行之后，才能读出最后一行的数据,相比之下，从第一行开始读，也需要将记录指针放在第一行之前
    while(rs.previous()){ //从最后一行开始读，当记录指针指向第一行之前返回false
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
