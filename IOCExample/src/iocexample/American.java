package iocexample;

public class American implements Person {
      //实现接口中的具体的方法
	@Override
	public void eat() {
		System.out.println("美国人喜欢吃西餐");
		
	}

	@Override
	public void drink() {
		 System.out.println("美国人喜欢喝咖啡");		
	}

}
