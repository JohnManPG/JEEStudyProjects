package addHibFile;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
      private HibernateSessionFactory(){
    	  
      }
      private static String CONFIG_FILE_LOCATION="/hibernate.cfg.xml";
      /*����������Ϊÿһ��ʹ�øñ������̶߳��ṩһ������ֵ�ĸ�����ʹÿһ���̶߳����Զ����ĸı��ڼ��ĸ�������������������̵߳ĸ�����ͻ�����̵߳ĽǶȿ����ͺ���ÿһ���̶߳���ȫ���Ѹñ���������������ʵ�����̵߳İ�ȫ
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
    				  System.err.println("����SessionFactoryʧ�ܣ�");
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
