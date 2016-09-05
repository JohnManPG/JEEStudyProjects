package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JavaBean.MessageBean;
//这个servlet功能：1.读取客户端的请求  2.为JavaBean中的属性赋值  

public class AddMessageServlet extends HttpServlet {

	
	public AddMessageServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		       doPost(request,response);
	}

	//无论是什么，一个对象对应一个实例，肯定是有属于自己属性的值，而且一个对象可大可小，可以是简简单单的一条数据记录，也可以是一篇文章，一篇文章就是一个对象，一个实例，一个JavaBean实例
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String author=new String(request.getParameter("author").getBytes("ISO-8859-1"),"UTF-8");
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
        String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
	    //获取当前时间并格式化时间为指定格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
        String today=format.format(new Date());    //如果参数是对象的话，也是可以直接new的，返回的是StringBuffer，事实证明是可以用String接收其返回值
        MessageBean mm=new MessageBean();    //new Date()就出来一个当前日期
        mm.setAuthor(author);
        mm.setContent(content);
        mm.setTitle(title);
        mm.setTime(today);
        //获取session对象
        HttpSession session=request.getSession(); //通过request获取session对象，返回与当前请求相关联的会话，如果没有（即第一次访问）则自动创建一个session对象
        //通过session获取对象应用上下文
        ServletContext scx = session.getServletContext();   //ServletContext相当于JSP中的application对象
        //获取存储在应用上下文中的集合对象   ，常常 用getServletContext()替代application对象，无论是在servlet中还是在JSP中
        ArrayList wordlist = (ArrayList) scx.getAttribute("wordlist");   //返回的是一个Object对象，需要进行强制类型转换
        if(wordlist==null)                       //空的话就需要单独创建一个实例
        wordlist =new ArrayList();
        //将封装了信息的值JavaBean存储到集合对象中
        wordlist.add(mm);
        //将集合对象保存到应用上下文中
        scx.setAttribute("wordlist", wordlist);
        response.sendRedirect("showMessage.jsp"); //使用重定向的方法，跳出servlet
	}

	
	public void init() throws ServletException {
		
	}
}
