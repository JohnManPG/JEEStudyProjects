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
		log("hello()方法开始执行");    //日志服务
		log("hello,"+name);      //执行业务逻辑功能
		log("hello()方法执行结束");    //日志服务
		
	}

}
