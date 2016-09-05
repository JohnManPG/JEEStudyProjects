package factoryexample;
//工厂中生产的是实现接口的子类的实例对象，他们有共同特征，高度的抽象化，一层一层往上提取
public class Factory {   //建工厂
       public Person getPerson(String name){     //定义一个Person类型的getPerson()方法,工厂类中 肯定有生产对象的方法，要么怎么能是工厂类内呢
    	   if(name.equals("中国人"))   //  实现了Person接口，那么子类也是Person类型的
    		   return new Chinese();
    	   else if(name.equals("美国人"))
    		   return new American();     //父类的引用指向子类的对象
    	   else throw new IllegalArgumentException("参数不正确");
    	   
       }
}
/*既然使用工厂生产对象，首先要建一个工厂，然后在工厂创建生成对象的方法，当我们需要某个对象时，我们只需要将该对象的参数传给工厂类中的方法，然后该方法就会根据这个参数返回一个我们所需要的对象
 * 1.建工厂
 * 2.在工厂中配置生成对象的方法，且方法的类型必须是我们所需对象父接口的类型，这样才可以通过父类的引用指向子类的对象
 * 3.传入对应的参数
 * 4.返回我们需要的对象
 * 
 * */