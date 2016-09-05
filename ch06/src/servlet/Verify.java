package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//这就是简单的servlet框架
public class Verify extends HttpServlet {

	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String number = request.getParameter("number");
		try{
		//作用是把字符串转化为Double类型，也可以转化为integer类型等等的包装类，是将普通的数据类型包装成对象，目的是让面向对象的语言全部是对象，包括普通的数据对象
	     Double n = Double.parseDouble(number);
	     if(n>100 || n<-100){
	    	 //重定向到sendForword.jsp页面
	    	 response.sendRedirect("sendForword.jsp");
	     }else{
	    	 
	    	 RequestDispatcher dispatcher = request.getRequestDispatcher("ShowMessage");   //创建一个转发的对象，并传进去将要转发的URL
	    	 dispatcher.forward(request, response);//转发到另一个servlet文件
	     }       //转发共用的是一个request和response对象，转发的对象携带者请求和响应
	}
		catch(Exception e){
		response.sendRedirect("sendForword.jsp");//重定向到sendForward.jsp页面
	}
}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		   doPost(request,response);       //直接调用doPost方法，传进request和response对象
	}         //调用doPost()方法，共用一个服务的业务逻辑


	public void init() throws ServletException {
		
	}

}
