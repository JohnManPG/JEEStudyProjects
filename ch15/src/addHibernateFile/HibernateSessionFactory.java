package addHibernateFile;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
     private static SessionFactory sessionFactory;
     private static Configuration configuration = new Configuration();
     public HibernateSessionFactory(){
    	 
     }       //��̬�����ʹ��ע���ܽ���ȱ��
     static {
    	 try{
    		 Configuration configure = configuration.configure("hibernate.cfg.xml");
    		 sessionFactory=configure.buildSessionFactory();
    	 }catch(Exception e){
    		 message("����SessionFactoryʧ�ܣ�"+e);
    	 }
     }
     
     public static Session getSession(){
    	 return sessionFactory.openSession();
     }
     public static void message(String mess){
    	 int type=JOptionPane.YES_NO_OPTION;
    	 String title="��ʾ��Ϣ";
    	 JOptionPane.showMessageDialog(null, mess,title,type);
     }
}
