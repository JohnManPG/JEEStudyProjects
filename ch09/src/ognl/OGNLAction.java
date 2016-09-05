package ognl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OGNLAction extends ActionSupport {
private String no;
private String name;
private String sex;
private int age;
public String getNo() {
	return no;
}
public void setNo(String no) {
	this.no = no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String execute() throws Exception{
	//获取request并添加信息
	HttpServletRequest request = ServletActionContext.getRequest();
	request.setAttribute("name", this.name);
	//获取session
	//HttpSession session = request.getSession();
	//session.setAttribute("name", this.name);
	Map session = ActionContext.getContext().getSession();
	session.put("name", getName());
	Map application = ActionContext.getContext().getApplication();
	application.put("name", getName());
	return SUCCESS;
}
}
