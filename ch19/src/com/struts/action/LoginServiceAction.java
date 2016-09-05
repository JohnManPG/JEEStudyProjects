package com.struts.action;
//�����Spring��Serviceô����
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserDao;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
//��Action�б������Dao��ķ��������������Ҳ����˵action�Ǹ���DAO����ȥ�������Ԫ�أ�ɾ��Ԫ�أ��޸�Ԫ�أ���ѯԪ�أ�һ��ʹ��HQL��䣬��ѯ��ֱ���Ƕ���
public class LoginServiceAction extends ActionSupport {
       private String username;   //ͨ��struts���ڲ����ƽ��䵭�ύ�Ĳ���Ϊ������Ը�ֵ
       private String password;
       //service�п϶�Ҫ���������ļ�����Ϊ����Ҫ����ע����Bean��ʵ�������һ�Ҫ���ݲ���
       //ApplicationContext��һ����Ҫ�Ľӿڣ�����ӿ��Ǹ����أ�Ϊһ��webӦ�ó����ṩһ�����ã�����ʵ�ֽӿڣ�Ӧ�ó���ֻ�ܶ��������ļ���������д������������
       ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
       UserDao userDao=(UserDao) ctx.getBean("userDao");   //�̳�BeanFactory�ķ���
	public String getUsername() {   //����ȥҪ������Bean�����ƣ��ͻ᷵��һ��userDao��ʵ������������Ĺ�������BeanFactory�д�����
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
    	   //�����˺�������û�   ���userList���������ݿ�������ݣ���¼��ֵ�����ݿ��ֵ��Ƚϣ�����û���������ȫ����ȣ���ô�Ϳ��Է���success,������½�ɹ�
    	   List<User> userList = userDao.findByName(username);
    	   //ʹ�ü򻯵�for���Լ��Ͻ��б������Ƚϵ�����
    	   for(User user : userList){      //��������Ķ���ӳ�䵽PO������
    		   if(user.getPassword().equals(password)){
    			   return SUCCESS;  //�̳е�ActionSupport���Է���SUCCESSֵ
    		   }else{
    			   return ERROR;
    		   }
    	   }//�Ƚ�Ԫ�ؾ�����Action�н��е�
    	   
    	   return ERROR;
       }
}
