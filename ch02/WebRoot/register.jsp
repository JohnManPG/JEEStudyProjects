<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>        <!-- 这个页面就相当于servlet,是视图和模型的中间件，处理两者之间的数据传输 -->
  <head>      <!-- 这就相当于servlet中间层，处理表单和JavaBean之间的数据 -->   
    <title>用户注册信息数据处理页面</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <!-- 本次实例使用两种方法获得表单提供的数据，一种是直接调用Bean的属性，第二种是使用JSP的jsp:getProperty动作获得JavaBean的数据 -->
  <body><!--  解释器里的jsp动作也要翻译，所以也不能出错  -->
    <jsp:useBean id="user"  scope="page"  class="JavaBean.UserRegisterBean"/>  <!-- JSP动作使用javabean -->
    <jsp:setProperty  name="user"  property="*" />   <!-- *表示只要表单数据名称和JavaBean的属性名称是一样的那么系统会自动匹配相应的字段 -->
       注册成功：     <!--jsp:setProperty动作是向Bean里面传送实参，即表单里面的数据 -->
       <hr/>
       使用Bean属性方法：
       <br/>
      用户名：<%=user.getUsername() %>
       密码：<%=user.getPassword() %>
       年龄：<%=user.getAge() %>
       <br/>                     <!--这里的name是Bean的实例名称，在使用Bean的时候已经强调过，已经告诉了路径 -->
                    使用getProerty动作：
      <br/>
      用户名：<jsp:getProperty name="user" property="username"/>     
      密码：   <jsp:getProperty name="user" property="password"/>
      年龄：   <jsp:getProperty name="user" property="age"/>   
  </body>
</html>
