package loginBean;
//��¼ҳ��������
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
	//�����û���¼��ҵ���߼�
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
