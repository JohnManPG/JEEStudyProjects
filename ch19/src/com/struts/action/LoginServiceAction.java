package com.struts.action;
//这就是Spring的Service么？？
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserDao;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
//在Action中必须调用Dao层的方法，传入参数，也就是说action是告诉DAO，你去给我添加元素，删除元素，修改元素，查询元素，一般使用HQL语句，查询的直接是对象
public class LoginServiceAction extends ActionSupport {
       private String username;   //通过struts的内部机制将变淡提交的参数为这个属性赋值
       private String password;
       //service中肯定要加载配置文件，因为必须要进行注入获得Bean的实例，而且还要传递参数
       //ApplicationContext是一个重要的接口，这个接口是干嘛呢？为一个web应用程序提供一个配置，子类实现接口，应用程序只能读此配置文件，并不能写或者其他操作
       ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
       UserDao userDao=(UserDao) ctx.getBean("userDao");   //继承BeanFactory的方法
	public String getUsername() {   //传进去要检索的Bean的名称，就会返回一个userDao的实例，创建对象的过程是在BeanFactory中创建的
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
       public String execute() throws Exception{
    	   //查找账号相符的用户   这个userList里存的是数据库里的数据，登录的值与数据库的值相比较，如果用户名与密码全都相等，那么就可以返回success,即：登陆成功
    	   List<User> userList = userDao.findByName(username);
    	   //使用简化的for语句对集合进行遍历并比较的密码
    	   for(User user : userList){      //将集合里的对象映射到PO对象中
    		   if(user.getPassword().equals(password)){
    			   return SUCCESS;  //继承的ActionSupport可以返回SUCCESS值
    		   }else{
    			   return ERROR;
    		   }
    	   }//比较元素就是在Action中进行的
    	   
    	   return ERROR;
       }
}
