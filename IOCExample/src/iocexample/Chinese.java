package iocexample;

public class Chinese implements Person {

	@Override
	public void eat() {
		System.out.println("中国人喜欢吃中餐");
		
	}

	@Override
	public void drink() {
		System.out.println("中国人喜欢喝茶水");
		
	}

}
