package LoginAction1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;     //�����������������
//һ����Ҫ������һ������Ҫ������
import com.opensymphony.xwork2.ActionSupport;
         //Java�п���ʵ�ֶ�ӿڣ���ô�Ϳ���ֱ��ʹ�ö������
public class IocAction extends ActionSupport implements ServletRequestAware {
                             //ʵ��ActionSupport��Ϊ����Action��д���ӵĹ淶
	private String userName;
	private String password;
	private HttpServletRequest request;   //Servlet�еĶ�����ֻ��Ҫ�����������������
	
	
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

     //����ʵ�ָ÷�������Ϊ�÷����ǽӿ��еķ���
	public void setServletRequest(HttpServletRequest req) {
		request=req;      //��req�������ֵ��HttpServletRequest���͵�request������Ҳ����˵ֻҪһ���ø÷������ͻᴴ��һ��request������Ҳ����IOC˼�룬����ģʽ
		
	}
	
	//IOC��ʽ
	public String execute() throws Exception{
		if(userName.equals("qq")&&password.equals("123")){
		//ͨ��request�����ȡsession
		HttpSession session = request.getSession();
		//�ѵ�¼������session��
		session.setAttribute("userName", getUserName());
		return SUCCESS;          //Ҳ����ͨ��this�������������
		}else{
			return INPUT;
		}
		
	}
	//��IOC��ʽ
	/**                  ��IOC��ʽ
	HttpServletRequest requests = ServletActionContext.getRequest();
	HttpSession sessions = requests.getSession();
	sessions.setAttribute("password", getPassword());
	****/
}
