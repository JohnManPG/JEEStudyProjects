package iocexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class test {
   public static void main(String[] args){
	   //��application.xml�����ļ���ʵ�������õ�Bean����
	   ApplicationContext ac=new FileSystemXmlApplicationContext("src/iocexample/applicationContext.xml");
	   Person person=null;
	   person=(Person) ac.getBean("�й���");   //ͨ��getBean()��������ɿ�����ɵ�ʵ��
	   person.eat();
	   person.drink();
	   person=(Person) ac.getBean("������");
	   person.eat();
	   person.drink();
   }
}
