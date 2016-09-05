package proxyexample;

import java.util.logging.Level;     //Java API中提供日志类
import java.util.logging.Logger;

public class HelloSpeaker {
     //通过Logger类的静态方法Logger.getLogger()来实例化并获取对象
	private Logger logger =Logger.getLogger(this.getClass().getName());
	public void hello(String name)
	{   //显示日志不是这个类的主要功能，所以把显示日志这个方法交给代理去弄，所以就要静态代理和动态代理
		logger.log(Level.INFO,"hello()方法开始执行");//方法开始执行时留下日志，要学会看日志
		System.out.println("hello,"+name);   //程序的主要功能
		logger.log(Level.INFO,"hello()方法执行结束");  //方法执行完成时留下日志
	}
	//这个类执行必须留下日志
    public static void main(String[] args){
    	HelloSpeaker h=new HelloSpeaker();
    	h.hello("汪想");
    }
}
