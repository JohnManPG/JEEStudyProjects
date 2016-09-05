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
       /*ʵ�ֽӿ�InvocationHandler�еķ������ڴ���ʵ���ϴ��������ò����ؽ�������뷽�������Ĵ���ʵ���ϵ��÷���ʱ�����ڵ��ô�������ϵ��ô˷���������proxy:
        * �����ϵ��÷����Ĵ���ʵ��������method����Ӧ���ڴ���ʵ���ϵ��õĽӿڷ�����Mehodʵ����Method����������ཫ�����������������ĽԿ࣬�ýӿڿ��������������Լ̳з����Ĵ���ӿڵĳ��ӿڡ�����args:
        * �����������ʵ��ɽ�������õĲ���ֵ�Ķ������飬����ӿڷ�����ʹ�ò�������Ϊnull.�������͵Ĳ�������װ���ʵ�������װ����
        * 
        * */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("invoke()������ʼִ�С�����");
		method.invoke(object, args);
		System.out.println("invoke()����ִ����ɡ�����");
		return null;
	}

}
