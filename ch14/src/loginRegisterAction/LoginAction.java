package loginRegisterAction;

import java.util.List;

import loginRegisterDao.LoginRegisterInfo;

import PO.UserInfoPO;
//通过struts内部机制进行赋值，猜想肯定使用到了JSP或者servlet中的request对象，先通过该对象获得请求中的参数，然后再调用set方法，将参数存储到Action中
import com.opensymphony.xwork2.ActionSupport;
//肯定这一套功能有一套流程，这个流程就可以完成登录注册功能，使用常见到的类
public class LoginAction extends ActionSupport {
      private String userName;
      private String password;
      private String message="error";
      private List list;   //定义一个list集合
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

	/**ActionSupport类实现了Action、Validateable等接口（具体参看API），其中Validateable接口就是验证器接口，
	 * 该接口有一个validate()方法，所以只要用户编写一个Action类，然后再重写这个方法就可以了
	 * 
	 * ActionSupport类只是空实现了validate()方法，你重写就是手动进行输入校验，还可以通过struts2的内置校验器进行配置校验
	 * */
      public void validate(){
    	  
    	  if(this.getUserName()==null || this.getUserName().length()==0){     //为空的两个前提条件：1：用户名本身不能为空   2：用户名的长度不能等于0
    		  
    		  //Add an error message for a given field.
    		  
    		  addFieldError("userName", "用户名不能为空!");
    	  }else{
    		  LoginRegisterInfo info = new LoginRegisterInfo();
    		  //这个集合list要盛装的对象是用来辨别这个用户名是否被注册过，如果这个集合为空，说明这个用户名没有被注册
    		  list=info.queryInfo("userName", this.getUserName());    //为SQL语句中的占位符传参
    		  if(list.size()==0){
    			  addFieldError("userName", "该用户尚未注册！");
    			  
    		  }else{
    			  UserInfoPO ui = new UserInfoPO();          //创建一个PO对象的实例，如果有Spring框架中的IOC思想，那么就可以使用依赖注入方式创建一个PO对象
    			  int count=0;
    			  for(int i=0;i<list.size();i++){
    				  count++;
    				  ui=(UserInfoPO) list.get(i);       //userInfoPO里的数据是从数据库中来的，获得这个实在的对象，因为一个集合中存的就是对象，那么就可以使用get()方法加索引直接取出相对应的对象
    				  if(this.getUserName().equals(ui.getUserName())){    //先判断用户名在判断密码，有没有这个用户名
    					  if(ui.getPassword().equals(this.getPassword())){    //这个对象里就包含两个属相，一个是用户名一个是密码
    						  message=SUCCESS;
    					  }else{
    						  addFieldError("password", "登录密码不正确");
    					  }
    				  }
    			  }
    			  
    		  }
    	  }
      }
}
