package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
       //这又是一个简单的servlet框架
public class ShowMessage extends HttpServlet {

	
	public ShowMessage() {      //构造方法,就相当于创建一个servlet实例
		super();
	}

	
	public void destroy() {      //servlet销毁方法
		super.destroy(); 
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {      //服务方法

		response.setContentType("text/html;charset=gb2312");   //这是在初始化响应页面的类型是HTML形式，初始化页面显示的字符的编码形式是gb2312
		PrintWriter out = response.getWriter();//还是要将客户端的数据获取到
		String number = request.getParameter("number");//获取客户提交的信息,转发的时候是用户的同一个请求，里面包含的内容是一样的，所以可以用这些数据在转发至的页面中用这些数据
		Double n = Double.parseDouble(number);//将字符串变成Double类型
		out.println(number+"的平方:"+(n*n));     //这是servlet打印的页面的方法，jsp中是<%=  %>
	}                                         //转发的时候浏览器的URL的地址是不会变的，本身是这个页面实现的业务逻辑，但是会显示在Verify的页面上

	public void init() throws ServletException {    //初始化方法
		
	}
}
