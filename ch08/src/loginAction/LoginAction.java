package loginAction;

import loginBean.LoginBean;

public class LoginAction {
      private String userName;
      private String passWord;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
      public String excute() throws Exception{    //ֻҪ��excute()�������ʹ���һ��Action
    	  LoginBean lb = new LoginBean();           //���������߼�
    	  if(lb.login(userName, passWord)){
    		  return "success";
    	  }else{
    		  return "error";
    	  }
      }
}
