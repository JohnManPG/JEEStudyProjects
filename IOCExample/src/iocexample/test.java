package iocexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class test {
   public static void main(String[] args){
	   //从application.xml配置文件中实例化配置的Bean对象
	   ApplicationContext ac=new FileSystemXmlApplicationContext("src/iocexample/applicationContext.xml");
	   Person person=null;
	   person=(Person) ac.getBean("中国人");   //通过getBean()方法获得由框架生成的实例
	   person.eat();
	   person.drink();
	   person=(Person) ac.getBean("美国人");
	   person.eat();
	   person.drink();
   }
}
