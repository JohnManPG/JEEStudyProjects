package proxyexample2;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		HelloSpeak1 helloSpeak = new HelloSpeak1();//实体类
		LogHandler logHandler = new LogHandler(helloSpeak);  //调用实体类相对应的日志处理方法
		Class cla = helloSpeak.getClass();
		Hello hello = (Hello) Proxy.newProxyInstance(cla.getClassLoader(), cla.getInterfaces(), logHandler);
		hello.hello("小强");
	}
}
