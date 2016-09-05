<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="test.TestBean" %>
<%@ page import="PO.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Hinernte的一对一关联关系映射</title>
    
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
    <h2>Hibernate的一对一关联关系映射</h2>
    <hr>
    <!-- 调用TestBean测试 -->
    <jsp:useBean id="test" class="test.TestBean"></jsp:useBean>
    <%
    test.addCompany();
    out.println("添加一个公司");
    test.addClient();
    out.println("添加一个客户");
    Integer id = new Integer(1);
    Company company = test.loadCompany(id);
    out.println("加载id为1的公司");
    Login login = company.getLogin();
    out.println("获取公司的登录账号");
    Client client=test.loadClient(id);
    out.println("获取ID为1的客户");
    Address address=client.getAddress();
    out.println("获取该客户地址");
    out.println("<br>company.getCompany()="+company.getCompanyname());
    out.println("<br>company.getTelephone()="+company.getTelephone());
    out.println("<br>company.getLinkman()="+company.getLinkman());
    out.println("<br>login.getLoginname()="+login.getLoginname());
    out.println("<br>login.getLoginpwd()="+login.getLoginpwd());
    out.println("<br>");
    out.println("<br>client.getClientname()="+client.getClientname());
    out.println("<br>client.getPhone()="+client.getPhone());
    out.println("<br>client.getEmail()="+client.getEmail());
    out.println("<br>address.getProvince()="+address.getProvince());
    out.println("<br>address.getCity()="+address.getCity());
    out.println("<br>address.getStreet()="+address.getStreet());
    out.println("<br>address.getZipcode()="+address.getZipcode());
    
     %>
  </body>
</html>
