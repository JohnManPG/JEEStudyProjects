package factoryexample;

public class American implements Person{
      //annocation注解
	@Override
	public void eat() {
		System.out.println("美国人喜欢吃西餐！");
		
	}

	@Override
	public void drink() {
		System.out.println("美国人喜欢喝咖啡！");
		
	}

}
