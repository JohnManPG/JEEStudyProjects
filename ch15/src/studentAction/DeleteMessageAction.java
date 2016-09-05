package studentAction;

import javax.swing.JOptionPane;

import Dao.StudentDao;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteMessageAction extends ActionSupport {
   private String id;
   private String message;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
   public void validate(){
	   if(this.getId().equals("null")){
		   message("暂无学生信息");
		   addFieldError("id", "暂无学生信息！");
	   }
   }
   public String execute() throws Exception{
	   StudentDao dao = new StudentDao();
	   boolean del = dao.deleteInfo(this.getId());
	   if(del){
		   message=SUCCESS;
	   }
	   return message;
   }
   public void message(String mess){
		  int type=JOptionPane.YES_NO_OPTION;
	 	  String title="提示信息";
	 	  JOptionPane.showMessageDialog(null, mess,title,type);
	  }
}
