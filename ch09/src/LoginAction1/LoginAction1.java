package LoginAction1;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction1 extends ActionSupport {//һ����Ҫ����������̳У������ṩ�޲εĹ��췽��,AcctionSupport�ṩ��һ���޲εĹ��췽��
        private String userName;
        public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {//��ֵ�Ĺ�����struts�ڲ�����ʵ�ֵģ���Ҳ����ȥ̽�֣�ֻ�����ڻ�����ʱ��
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		private String password;
		//actioncontext������û�ȡapplication���󣬲�����һ��map���ϣ�����ֵ�Դ����Ӧ��application����session���󣬴���ȥ�����ڴ����ˣ�����C�����е�malloc������Ҫ�ռ��ڴ��
		public String execute() throws Exception{
			if(getUserName().equals("aa") && getPassword().equals("123")){//���÷���������Ҫ�����ŵ�
				//��ȡActionContext����
				ActionContext ac = ActionContext.getContext();//������ô˵�����ص���һ��map���ϣ����map�����д���Ƕ��󣬶����Ǵ�����Ӧ��application����session��
				//�ѵ�¼�����浽application��           //һ���������������ƺ�����ֵ�����Ա�����map���ϣ�ʢ��һ������һ��ֵ����ֵ��
				ac.getApplication().put("userName", getUserName());
				//�ѵ�¼�����浽session��
				ac.getSession().put("userName",getUserName() );
				return SUCCESS;
			}else{
				return INPUT;
			}
			
		}
        
	
	
}
