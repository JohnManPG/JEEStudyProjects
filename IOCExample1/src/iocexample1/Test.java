package iocexample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {        //���������ָ������Ķ���
	
	public static void main(String[] args){
     ApplicationContext ac=new FileSystemXmlApplicationContext("src/iocexample1/applicationContext.xml");
	 Person person=null;
	 person = (Person) ac.getBean("�й���");
	 person.speak();  //������־�ļ�����ô�ڷ������ĺ�̨�ͻ�������־����	
	}
}
