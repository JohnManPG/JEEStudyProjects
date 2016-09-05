package factoryexample;

public class Chinese implements Person {
     //annocation注解
	@Override
	public void eat() {
		System.out.println("中国人喜欢吃中餐！");    // 重写子接口中的方法
		
	}

	@Override
	public void drink() {
		System.out.println("中国人喜欢喝茶水！");
		
	}

}
