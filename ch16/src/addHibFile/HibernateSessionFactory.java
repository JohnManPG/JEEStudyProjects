package addHibFile;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
      private HibernateSessionFactory(){
    	  
      }
      private static String CONFIG_FILE_LOCATION="/hibernate.cfg.xml";
      /*它的作用是为每一个使用该变量的线程都提供一个变量值的副本，使每一个线程都可以独立的改变在即的副本，而不会和其他的线程的副本冲突。从线程的角度看，就好像每一个线程都完全用友该变量，这样可以是实现子线程的安全
       * */
      private static final ThreadLocal threadLocal=new ThreadLocal();
      private static final Configuration cfg = new Configuration();
      private static SessionFactory sessionFactory;
      public static Session currentSession() throws HibernateException{
    	  Session session = (Session) threadLocal.get(); 
    	  if(session==null){
    		  if(sessionFactory==null){
    			  try{
    				  cfg.configure(CONFIG_FILE_LOCATION);
    				  sessionFactory=cfg.buildSessionFactory();
    			  }catch(Exception e){
    				  System.err.println("生成SessionFactory失败！");
    				  e.printStackTrace();
    			  }
    		  }
    		  session = sessionFactory.openSession();
    		  threadLocal.set(session);
    	  }
    	  return session;
      }
      public static void closeSession() throws HibernateException{
    	  Session session = (Session) threadLocal.get();
    	  threadLocal.set(null);
    	  if(session!=null){
    		  session.close();
    	  }  
     }
}
