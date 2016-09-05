package LoginAction1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;     //在拦截器这个包里面
//一个需要拦截器一个不需要拦截器
import com.opensymphony.xwork2.ActionSupport;
         //Java中可以实现多接口，那么就可以直接使用多个对象
public class IocAction extends ActionSupport implements ServletRequestAware {
                             //实现ActionSupport是为了让Action书写更加的规范
	private String userName;
	private String password;
	private HttpServletRequest request;   //Servlet中的对象，我只需要定义这个变量就行了
	
	
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

     //必须实现该方法，因为该方法是接口中的方法
	public void setServletRequest(HttpServletRequest req) {
		request=req;      //将req这个对象赋值给HttpServletRequest类型的request变量，也就是说只要一调用该方法，就会创建一个request对象，这也就是IOC思想，工厂模式
		
	}
	
	//IOC方式
	public String execute() throws Exception{
		if(userName.equals("qq")&&password.equals("123")){
		//通过request对象获取session
		HttpSession session = request.getSession();
		//把登录名传入session中
		session.setAttribute("userName", getUserName());
		return SUCCESS;          //也可以通过this来调用这个对象
		}else{
			return INPUT;
		}
		
	}
	//非IOC方式
	/**                  非IOC方式
	HttpServletRequest requests = ServletActionContext.getRequest();
	HttpSession sessions = requests.getSession();
	sessions.setAttribute("password", getPassword());
	****/
}
