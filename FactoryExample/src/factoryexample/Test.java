package factoryexample;

public class Test {
  public static void main(String[] args){
	  Person person=null;      //通过实现的子类来创建父类的引用对象
	  person=new Factory().getPerson("中国人");   //在实际使用时，直接调用工厂中的生产对象的方法就可以了
	  person.eat();
	  person.drink();
	  person=new Factory().getPerson("美国人");
	  person.eat();
	  person.drink();
  }
}
