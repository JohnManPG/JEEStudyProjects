package proxyexample2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
	
	private Object object;
	public LogHandler(){
		
	}
	public LogHandler(Object obj){
		object = obj;
	}
       /*实现接口InvocationHandler中的方法，在代理实例上处理方法调用并返回结果。在与方法关联的代理实例上调用方法时，将在调用处理程序上调用此方法。参数proxy:
        * 在其上调用方法的代理实例。参数method：对应于在代理实例上调用的接口方法的Mehod实例。Method对象的声明类将是在其中声明方法的皆苦，该接口可以死代理类赖以继承方法的代理接口的超接口。单数args:
        * 包含传入代理实例山方法调用的参数值的对象数组，如果接口方法不使用参数，则为null.基本类型的参数杯包装在适当基本包装器类
        * 
        * */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("invoke()方法开始执行。。。");
		method.invoke(object, args);
		System.out.println("invoke()方法执行完成。。。");
		return null;
	}

}
