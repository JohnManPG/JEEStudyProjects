package factoryexample;

public interface Person {
    void eat();           //定义抽象的吃方法
    void drink();           //定义抽象的喝方法
}


/*怎么样写一个符合工厂模式的代码：
 * 1.从各个对象中抽象出共同的方法来定义一个接口，使之方法抽象，再由子类具体实现这些方法，接口是用来规定这些子类的类型都是接口类型的，所以可以定义工厂的方法类型是接口卡类型的
 *     第一步很重要，需要多敲代码来学习，才知道什么时候用工厂模式比较方便
 * 2.创建一个工厂方法来创建对象，这是需要传参
 * 3.就可以使用调用了*/