package proxyexample2;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		HelloSpeak1 helloSpeak = new HelloSpeak1();//ʵ����
		LogHandler logHandler = new LogHandler(helloSpeak);  //����ʵ�������Ӧ����־������
		Class cla = helloSpeak.getClass();
		Hello hello = (Hello) Proxy.newProxyInstance(cla.getClassLoader(), cla.getInterfaces(), logHandler);
		hello.hello("Сǿ");
	}
}
