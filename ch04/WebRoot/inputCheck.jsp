<%@ page import="java.sql.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>     <!-- -这就相当于Struts框架里的action,处理业务逻辑或者说是JavaBean  -->
    <base href="<%=basePath%>">
    
    <title>数据更新后的页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
                 <!-- 一次操作，一次与数据库的会话就需要再创建一个连接实例，而且对象都不一样 -->
  <body>
   <center>
   <h3>已添加学生信息</h3>
   <hr>
   <%
   String studentNumber =request.getParameter("studentNumber");
   byte []b=studentNumber.getBytes("ISO-8859-1");
   studentNumber=new String(b,"UTF-8");     //重新赋值可以重新覆盖
   String studentName =request.getParameter("studentName");
   byte []b1=studentName.getBytes("ISO-8859-1");
   studentName=new String(b1,"UTF-8");
   String studentSex =request.getParameter("studentSex");
   byte []b2=studentSex.getBytes("ISO-8859-1");
   studentSex=new String(b2,"UTF-8");
   String studentAge =request.getParameter("studentAge");
   byte []b3=studentAge.getBytes("ISO-8859-1");
   studentAge=new String(b3,"UTF-8");
   String studentWeight =request.getParameter("studentWeight");
   byte []b4=studentWeight.getBytes("ISO-8859-1");
   studentWeight=new String(b4,"UTF-8");
   Class.forName("com.mysql.jdbc.Driver");
   String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=gbk";
   String user="root";
   String password="mysql";
    
   Connection conn = DriverManager.getConnection(url,user,password);//这样的引用类型不用加引号
   Statement stmt=conn.createStatement();
   String sql="insert into info values('"+studentNumber+"','"+studentName+"','"+studentSex+"',"+studentAge+","+studentWeight+")";
   stmt.executeUpdate(sql);
   stmt.close();
   conn.close();
    %>
    <h3>已更改学生信息</h3>
    <hr>
    <%
   Class.forName("com.mysql.jdbc.Driver");
   String url1="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=gbk";
   String user1="root";
   String password1="mysql";    
   Connection conn1 = DriverManager.getConnection(url1,user1,password1);//这样的引用类型不用加引号
   Statement stmt1=conn1.createStatement();
   String sql1="update info set studentAge=18";
   stmt1.executeUpdate(sql1);
   stmt1.close();
   conn1.close();
     %>
      <h3>已删除学生信息</h3>
    <hr>
    <%
   Class.forName("com.mysql.jdbc.Driver");
   String url2="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=gbk";
   String user2="root";
   String password2="mysql";    
   Connection conn2 = DriverManager.getConnection(url2,user2,password2);//这样的引用类型不用加引号
   Statement stmt2=conn2.createStatement();
   String sql2="delete from info where studentSex='男'";
   stmt2.executeUpdate(sql1);
   stmt2.close();
   conn2.close();
     %>
     <h3>经过以上操作后，数据库中有以下记录</h3>
     <hr>
     <table border="2" bgcolor="ccceee" align="center">
     <tr>
     <td>学号</td>
     <td>姓名</td>
     <td>性别</td>
     <td>年龄</td>
     <td>体重</td>
     </tr>
      <%
    Class.forName("com.mysql.jdbc.Driver");
    String url3="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=gbk";
    String user3="root";
    String password3="mysql";
    
    Connection conn3 = DriverManager.getConnection(url3,user3,password3);
    Statement stmt3 = conn3.createStatement();
    String sql3="select * from info";            
    ResultSet rs = stmt3.executeQuery(sql3);
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
     stmt3.close();//从上层往下层关
     conn3.close();
      %>        
     </table>
     <hr>
   </center>
  </body>
</html>
