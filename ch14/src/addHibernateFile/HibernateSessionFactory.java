package addHibernateFile;
//加载Hibernate.cfg.xml文件的类为HibernateSessionFactory
import org.hibernate.Session;   //Configuration接口是Hibernate的启动引导接口，一个hibernate启动就像诞生一个人一样需要有眼睛、鼻子这些参数，那么hibernate的启动就需要数据库的配置参数和映射源，映射源就是为了方便数据库数据的操作
import org.hibernate.SessionFactory;    //sessionFactory就是创建session的
import org.hibernate.cfg.Configuration;   //Configuration提供的是建造session的数据图纸，根据这张图纸，建立sessionFactory工厂，并生产session实例

public class HibernateSessionFactory {
  private SessionFactory sessionFactory;
  public HibernateSessionFactory(){
	  
  }
  public SessionFactory config(){
	  try{
	  Configuration configuration=new Configuration();
	  Configuration configure=configuration.configure("hibernate.cfg.xml");//通过configure()方法加载hibernate的配置文件和映射文件
	  return configure.buildSessionFactory();//根据加载的文件创建一个sessionFactory工厂
	  }catch(Exception e){
		  e.getMessage();
		  return null;
	  }
  }          //这个session可以类比客户端与服务器的通信，这个session是PO对象与数据库表的会话。
  public Session getSession(){
	  sessionFactory = config();
	  return sessionFactory.openSession();  //打开一个连接，现在创建了一个PO对象与数据库中表的连接
  }
  
}
