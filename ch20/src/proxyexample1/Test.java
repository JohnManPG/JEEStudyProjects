package proxyexample1;

public class Test {
	public static void main(String[] args) {
		Hello proxy = new HelloProxy(new HelloSpeak1());
		proxy.hello("Сǿ");
	}
}
