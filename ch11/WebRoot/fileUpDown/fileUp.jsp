<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %><!-- 导入标签库 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>      <!-- 无论是上传还是下载，都是将一个文件拷贝另一个地方，所以所用的方法和本地复制一个文件是一样的，只要理解复制就行了，仅仅是文件传输所承载的介质不一样，本地是U盘，c/s是网络 -->
    文件上传
    <hr>
    <!-- enctype设置为multipart/form-data,该属性用来设置浏览器采用二进制的方法来处理表单数据，上传文件时需要使用该属性 -->
    <s:form action="upLoad" enctype="multipart/form-data">
    <s:textfield name="title" label="文件标题"/><br>
    <!-- struts2使用拦截器fileUpload显示国际化信息，这里不必使用key值，但是在11.1.2节中需要使用 -->
    <s:file name="upload" label="选择文件"/><br>
    <s:submit value="上传"/>
    </s:form>
  </body>
</html>
