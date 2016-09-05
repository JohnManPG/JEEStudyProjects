package studentAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.StudentDao;

import com.opensymphony.xwork2.ActionSupport;

public class LookMessageAction extends ActionSupport {
	private HttpServletRequest request;//这句话属于JavaEE开发中的对象，使用框架，导包，就是使最基础的JSP技术，Servlet技术，JDBC技术，JavaBean技术封装起来使用，但是还是会用到基础知识的一些属性和类，所以框架要提供一个接口或者类来生成底层的对象，struts框架中提供的方法名是ServletActinContext
	private String message="input";
	public String execute() throws Exception{
		request=ServletActionContext.getRequest();//这是一个获得servlet中的request对象的一个方法，ServletActionContxt类中的getRequest()方法
		StudentDao dao = new StudentDao();
		List list = dao.findAllInfo();
		request.getSession().setAttribute("count", list.size());
		request.getSession().setAttribute("allInfo", list);     //将List集合中的对象存储在session中，这个session是servlet中的session
		message = "success";
		return message;   //可以返回一个值，也可以返回一个变量
	}      
}
