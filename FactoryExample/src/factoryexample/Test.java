package factoryexample;

public class Test {
  public static void main(String[] args){
	  Person person=null;      //ͨ��ʵ�ֵ�������������������ö���
	  person=new Factory().getPerson("�й���");   //��ʵ��ʹ��ʱ��ֱ�ӵ��ù����е���������ķ����Ϳ�����
	  person.eat();
	  person.drink();
	  person=new Factory().getPerson("������");
	  person.eat();
	  person.drink();
  }
}
