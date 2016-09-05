package LoginAction1;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction1 extends ActionSupport {//一个类要允许其他类继承，必须提供无参的构造方法,AcctionSupport提供了一个无参的构造方法
        private String userName;
        public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {//赋值的过程是struts内部机制实现的，你也可以去探讨，只是现在还不是时候
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		private String password;
		//actioncontext类的作用获取application对象，并返回一个map集合，将键值对存进相应的application或者session对象，存上去就在内存里了，就像C语言中的malloc函数，要空间内存的
		public String execute() throws Exception{
			if(getUserName().equals("aa") && getPassword().equals("123")){//调用方法后面是要有括号的
				//获取ActionContext对象
				ActionContext ac = ActionContext.getContext();//不管怎么说，返回的是一个map集合，这个map集合中存的是对象，而且是存在相应的application或者session中
				//把登录名保存到application中           //一个对象有属性名称和属性值，所以必须是map集合，盛传一个键，一个值，键值对
				ac.getApplication().put("userName", getUserName());
				//把登录名保存到session中
				ac.getSession().put("userName",getUserName() );
				return SUCCESS;
			}else{
				return INPUT;
			}
			
		}
        
	
	
}
