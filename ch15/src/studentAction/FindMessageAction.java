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
			message("暂无学生信息！");
			addFieldError(id, "暂无学生信息");
		}
	}
	
	public String execute() throws Exception{
		request=ServletActionContext.getRequest();
		StudentDao dao= new StudentDao();
	    List list=dao.FindInfo("id", this.getId());
	    request.getSession().setAttribute("oneInfo", list);    //这时list中存的是一个对象具体的值，每一个属性的值，把这个list在放进session中
	    message=SUCCESS;
	    return message;
	    
	}
	public void message(String mess){
		  int type=JOptionPane.YES_NO_OPTION;
	 	  String title="提示信息";
	 	  JOptionPane.showMessageDialog(null, mess,title,type);
	  }
}
