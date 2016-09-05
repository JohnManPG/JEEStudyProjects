package proxyexample2;

public class HelloSpeak1 implements Hello {
      //没有日志的累赘，只执行它的主体功能,那么我怎么才能通过Handler来实现这个类的日志功能？？？？
	@Override
	public void hello(String name) {
		 System.out.println("hello,"+name);
		
	}

}
