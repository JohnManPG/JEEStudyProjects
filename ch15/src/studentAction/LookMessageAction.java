package studentAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Dao.StudentDao;

import com.opensymphony.xwork2.ActionSupport;

public class LookMessageAction extends ActionSupport {
	private HttpServletRequest request;//��仰����JavaEE�����еĶ���ʹ�ÿ�ܣ�����������ʹ�������JSP������Servlet������JDBC������JavaBean������װ����ʹ�ã����ǻ��ǻ��õ�����֪ʶ��һЩ���Ժ��࣬���Կ��Ҫ�ṩһ���ӿڻ����������ɵײ�Ķ���struts������ṩ�ķ�������ServletActinContext
	private String message="input";
	public String execute() throws Exception{
		request=ServletActionContext.getRequest();//����һ�����servlet�е�request�����һ��������ServletActionContxt���е�getRequest()����
		StudentDao dao = new StudentDao();
		List list = dao.findAllInfo();
		request.getSession().setAttribute("count", list.size());
		request.getSession().setAttribute("allInfo", list);     //��List�����еĶ���洢��session�У����session��servlet�е�session
		message = "success";
		return message;   //���Է���һ��ֵ��Ҳ���Է���һ������
	}      
}
