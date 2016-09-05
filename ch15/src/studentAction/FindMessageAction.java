package studentAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.apache.struts2.ServletActionContext;

import Dao.StudentDao;

import com.opensymphony.xwork2.ActionSupport;

public class FindMessageAction extends ActionSupport{
	private String id;
	private HttpServletRequest request;
	private String message="input";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void validate(){
		
		if(this.getId().equals("null")){
			message("����ѧ����Ϣ��");
			addFieldError(id, "����ѧ����Ϣ");
		}
	}
	
	public String execute() throws Exception{
		request=ServletActionContext.getRequest();
		StudentDao dao= new StudentDao();
	    List list=dao.FindInfo("id", this.getId());
	    request.getSession().setAttribute("oneInfo", list);    //��ʱlist�д����һ����������ֵ��ÿһ�����Ե�ֵ�������list�ڷŽ�session��
	    message=SUCCESS;
	    return message;
	    
	}
	public void message(String mess){
		  int type=JOptionPane.YES_NO_OPTION;
	 	  String title="��ʾ��Ϣ";
	 	  JOptionPane.showMessageDialog(null, mess,title,type);
	  }
}
