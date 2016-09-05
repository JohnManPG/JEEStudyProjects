package addHibernateFile;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
     private static SessionFactory sessionFactory;
     private static Configuration configuration = new Configuration();
     public HibernateSessionFactory(){
    	 
     }       //静态代码块使用注意总结优缺点
     static {
    	 try{
    		 Configuration configure = configuration.configure("hibernate.cfg.xml");
    		 sessionFactory=configure.buildSessionFactory();
    	 }catch(Exception e){
    		 message("生成SessionFactory失败："+e);
    	 }
     }
     
     public static Session getSession(){
    	 return sessionFactory.openSession();
     }
     public static void message(String mess){
    	 int type=JOptionPane.YES_NO_OPTION;
    	 String title="提示信息";
    	 JOptionPane.showMessageDialog(null, mess,title,type);
     }
}
