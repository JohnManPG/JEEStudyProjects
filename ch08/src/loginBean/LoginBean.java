package loginBean;
//登录页面做好了
public class LoginBean {
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
	//处理用户登录的业务逻辑
	public boolean login(String userName,String passWord){
		boolean b=false;
		if(userName.equals("wangxiang")&&passWord.equals("123")){
			b=true;
			return b;
		}else{
			b=false;
			return b;
		}
		
		
	}

}
