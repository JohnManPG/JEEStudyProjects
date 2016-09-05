package loginRegisterAction;

import java.util.List;

import loginRegisterDao.LoginRegisterInfo;

import PO.UserInfoPO;
//ͨ��struts�ڲ����ƽ��и�ֵ������϶�ʹ�õ���JSP����servlet�е�request������ͨ���ö����������еĲ�����Ȼ���ٵ���set�������������洢��Action��
import com.opensymphony.xwork2.ActionSupport;
//�϶���һ�׹�����һ�����̣�������̾Ϳ�����ɵ�¼ע�Ṧ�ܣ�ʹ�ó���������
public class LoginAction extends ActionSupport {
      private String userName;
      private String password;
      private String message="error";
      private List list;   //����һ��list����
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/**ActionSupport��ʵ����Action��Validateable�Ƚӿڣ�����ο�API��������Validateable�ӿھ�����֤���ӿڣ�
	 * �ýӿ���һ��validate()����������ֻҪ�û���дһ��Action�࣬Ȼ������д��������Ϳ�����
	 * 
	 * ActionSupport��ֻ�ǿ�ʵ����validate()����������д�����ֶ���������У�飬������ͨ��struts2������У������������У��
	 * */
      public void validate(){
    	  
    	  if(this.getUserName()==null || this.getUserName().length()==0){     //Ϊ�յ�����ǰ��������1���û���������Ϊ��   2���û����ĳ��Ȳ��ܵ���0
    		  
    		  //Add an error message for a given field.
    		  
    		  addFieldError("userName", "�û�������Ϊ��!");
    	  }else{
    		  LoginRegisterInfo info = new LoginRegisterInfo();
    		  //�������listҪʢװ�Ķ����������������û����Ƿ�ע���������������Ϊ�գ�˵������û���û�б�ע��
    		  list=info.queryInfo("userName", this.getUserName());    //ΪSQL����е�ռλ������
    		  if(list.size()==0){
    			  addFieldError("userName", "���û���δע�ᣡ");
    			  
    		  }else{
    			  UserInfoPO ui = new UserInfoPO();          //����һ��PO�����ʵ���������Spring����е�IOC˼�룬��ô�Ϳ���ʹ������ע�뷽ʽ����һ��PO����
    			  int count=0;
    			  for(int i=0;i<list.size();i++){
    				  count++;
    				  ui=(UserInfoPO) list.get(i);       //userInfoPO��������Ǵ����ݿ������ģ�������ʵ�ڵĶ�����Ϊһ�������д�ľ��Ƕ�����ô�Ϳ���ʹ��get()����������ֱ��ȡ�����Ӧ�Ķ���
    				  if(this.getUserName().equals(ui.getUserName())){    //���ж��û������ж����룬��û������û���
    					  if(ui.getPassword().equals(this.getPassword())){    //���������Ͱ����������࣬һ�����û���һ��������
    						  message=SUCCESS;
    					  }else{
    						  addFieldError("password", "��¼���벻��ȷ");
    					  }
    				  }
    			  }
    			  
    		  }
    	  }
      }
}
