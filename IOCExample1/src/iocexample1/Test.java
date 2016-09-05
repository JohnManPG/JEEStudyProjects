package iocexample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {        //父类的引用指向子类的对象
	
	public static void main(String[] args){
     ApplicationContext ac=new FileSystemXmlApplicationContext("src/iocexample1/applicationContext.xml");
	 Person person=null;
	 person = (Person) ac.getBean("中国人");
	 person.speak();  //加入日志文件，那么在服务器的后台就会输入日志内容	
	}
}
