<%@ page import="java.sql.*"%>           <!-- 先导入sql包 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分页技术应用实例</title>
    
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
    <center>
    分页显示记录内容
    <hr>
    <table border="1" bgcolor="cccfff" align="center">
    <tr>
    <th>学号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>年龄</th>
    <th>体重</th>
    </tr>
    <%
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=gbk";
    String user="root";
    String password="mysql";
    
    Connection conn = DriverManager.getConnection(url,user,password);//这样的引用类型不用加引号
    int intPageSize;//一页显示的记录数
    int intRowCount;//记录总数
    int intPageCount;//总页数
    int intPage;//待显示页码
    String strPage;
    int i;
    intPageSize=2;    //设置一页显示的记录数
    //取得待显示页码
    strPage=request.getParameter("page");
    if(strPage==null){                //第一次访问这个页面时，这句话有用，因为第一次访问时，page参数是null
    /**表明在QueryString中没有page这个参数，此时显示第一页数据*/
    intPage=1;
    }else{
    //将字符串转换成整型
    intPage=java.lang.Integer.parseInt(strPage);
    if(intPage<1)    //第一页的前面就是小于1，所以小于1的时候也要待显示页码等于1
      intPage=1;
    }
     Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     String sql="select * from info";
     ResultSet rs = stmt.executeQuery(sql);
      rs.last();//光标指向查询结果集的最后一条记录
      //获取记录总数
      intRowCount=rs.getRow();
      //计算总页数
      intPageCount =(intRowCount+intPageSize-1)/intPageSize;   //记住这个公式
      if(intPage>intPageCount)      //当显示页面是在最后一页时，这个开始起作用，点击下一页时，让页面一直保留在最后一页
      //调整待显示的页码
      intPage=intPageCount;
      if(intPageCount>0){         //大于0小于总页数时，将指针放到待显示页面的第一行并显示出来
      rs.absolute((intPage-1)*intPageSize+1);//将记录指针定位到待显示页的第一条记录上，记住这个公式
      //显示数据
      i=0;
      while(i<intPageSize && !rs.isAfterLast()){    //两个控制条件，一个是页面的最大容量，一个判断是否在结果集的最后一行，来控制循环，用与运算符
     %>
      <tr>      <!-- 一次完成一行 -->
     <td><%=rs.getString("studentNumber") %></td>
     <td><%=rs.getString("studentName") %></td>
     <td><%=rs.getString("studentsex") %></td>
     <td><%=rs.getString("studentAge") %></td>
     <td><%=rs.getString("studentWeight") %></td>
     </tr>
     <%
     rs.next();
     i++;
     }
     }
      %>    
    </table>
    <hr>
    <div align="center">
             第<%=intPage %>页 共<%=intPageCount %>页                  <!-- 在页面显示的内容，都需要打印出来的，或者用HTML标签  -->
    <%
    if(intPage<intPageCount){
     %>    
     <a href="pageBreak.jsp?page=<%=intPage+1%>">下一页</a>
     <%
     }
     if(intPage>1){
     %>
    <a href="pageBreak.jsp?page=<%=intPage-1%>">上一页</a>    <!-- 为连接传参，这种方式可以记住，在<a>标签里使用，而且JSP是可以直接用href属性去实现跳转的 -->
     <%
     }
     rs.close();       //关闭ResultSet结果集
     stmt.close();      //关闭传送SQL语句的statement对象
     conn.close();    //关闭连接数据库，释放数据库资源
      %>  
    </div>  
   </center>
  </body>
</html>
