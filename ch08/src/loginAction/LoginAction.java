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
      public String excute() throws Exception{    //只要有excute()方法，就代表一个Action
    	  LoginBean lb = new LoginBean();           //处理事务逻辑
    	  if(lb.login(userName, passWord)){
    		  return "success";
    	  }else{
    		  return "error";
    	  }
      }
}
