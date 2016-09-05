package iocexample1;

public class Chinese implements Person {	
	/**  设置注入
    private Language language;    //定义该类的属性，只要没有new，就不会创建一个对象占用内存，这只是一个属性而已
	@Override
	public void speak() {
		System.out.println(language.kind());
		
	}    //设置注入
    public void setLanguage(Language language){  //注入方法
    	this.language=language;     //这个传进来的language肯定是一个对象，通过set()方法注入对象，这和JavaBean中的属性赋值的原理是一样的，值是在其他地方获得的，对象也是在其他地方获得的
    }
    **/
	
	
	//构造注入
	private Language language;
	public Chinese(){
		
	}
	public Chinese(Language language){
		this.language=language;  
	}
	@Override
	public void speak() {
		System.out.println(language.kind());
		
	}
	
}
