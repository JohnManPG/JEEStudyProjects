package proxyexample1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloProxy implements Hello {
       private Hello helloObject=null;
       private Logger logger =Logger.getLogger(this.getClass().getName());
       public HelloProxy(Hello helloObject){
    	   this.helloObject=helloObject;
       }
       public void log(String msg)
       {
    	   logger.log(Level.INFO,msg);
       }
       
	@Override
	public void hello(String name) {
		log("hello()������ʼִ��");    //��־����
		log("hello,"+name);      //ִ��ҵ���߼�����
		log("hello()����ִ�н���");    //��־����
		
	}

}
