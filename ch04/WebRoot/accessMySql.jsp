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
    
    <title>JDBC连接数据库实例</title>
    
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
    <h2>使用mysql的jdbc驱动程序访问mysql数据库</h2>
    <hr>
    <table border="1" align="center">
    <tr>
    <th width="87" align="center">学号</th>
    <th width="87" align="center">姓名</th>
    <th width="87" align="center">专业</th>
    </tr>
    <%
    Connection con = null;//建立连接，connection是一个接口，这不是定义一个实例对象，而是声明一个connection类型的变量，用来加载数据库的连接
    Statement stmt=null;  //操作数据库，是本地数据库语言的载体，用于执行静态的SQL语句，并返回它所生成结果的对象
    ResultSet rs=null;   //返回结果集，表示数据库结果集的数据表，通常通过执行查询数据库的语句生成，也就是说result对象是一个数据表
    Class.forName("com.mysql.jdbc.Driver"); //加载数据库的驱动  ,加载和注册一个驱动程序
    
    /*localhost表示主机地址，即本机；3306为端口号；student为数据库名，url后面加的？useUnicode=true&characterEncoding=gbk,是为了处理向数据库中添加数据时出现乱码的问题*/  
    String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=gbk";
    con=DriverManager.getConnection(url,"root","mysql");//使用DriverManager类管理驱动，建立连接，创建connection对象
    stmt=con.createStatement();    //静态执行sql
    String sql="select * from sinfo";  //结构化语言用来操作不同的数据库，不能说是哪个数据库独有的这个语言
    rs=stmt.executeQuery(sql);     //可以证明创建的result是一个数据表，和数据库中的表是一样的，他是以列为单位获取值的，可以使用列名也可以使用列在数据表中的排序，result是一列一列的读
    while(rs.next()){
     %>
     <tr>                        <!-- 一行里面有三列 -->
     <td><%=rs.getString("studentNumber") %></td>
     <td><%=rs.getString("studentName") %></td>
     <td><%=rs.getString("studentClass") %></td>
     </tr>
     <%
     }
     rs.close();     //先关闭result对象，在关闭statement对象，在关闭connection对象，从上层往下层关闭，先关闭子类，再关闭父类，创建对象的那个类
     stmt.close();
     con.close();
      %>
    </table>
  </body>
</html>
