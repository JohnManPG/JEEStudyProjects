package proxyexample1;

public class HelloSpeak1 implements Hello {
      //没有日志的累赘，只执行它的主体功能
	@Override
	public void hello(String name) {
		 System.out.println("hello,"+name);
		
	}

}
