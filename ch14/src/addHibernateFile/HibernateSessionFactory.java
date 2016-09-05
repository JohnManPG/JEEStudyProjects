package addHibernateFile;
//����Hibernate.cfg.xml�ļ�����ΪHibernateSessionFactory
import org.hibernate.Session;   //Configuration�ӿ���Hibernate�����������ӿڣ�һ��hibernate����������һ����һ����Ҫ���۾���������Щ��������ôhibernate����������Ҫ���ݿ�����ò�����ӳ��Դ��ӳ��Դ����Ϊ�˷������ݿ����ݵĲ���
import org.hibernate.SessionFactory;    //sessionFactory���Ǵ���session��
import org.hibernate.cfg.Configuration;   //Configuration�ṩ���ǽ���session������ͼֽ����������ͼֽ������sessionFactory������������sessionʵ��

public class HibernateSessionFactory {
  private SessionFactory sessionFactory;
  public HibernateSessionFactory(){
	  
  }
  public SessionFactory config(){
	  try{
	  Configuration configuration=new Configuration();
	  Configuration configure=configuration.configure("hibernate.cfg.xml");//ͨ��configure()��������hibernate�������ļ���ӳ���ļ�
	  return configure.buildSessionFactory();//���ݼ��ص��ļ�����һ��sessionFactory����
	  }catch(Exception e){
		  e.getMessage();
		  return null;
	  }
  }          //���session������ȿͻ������������ͨ�ţ����session��PO���������ݿ��ĻỰ��
  public Session getSession(){
	  sessionFactory = config();
	  return sessionFactory.openSession();  //��һ�����ӣ����ڴ�����һ��PO���������ݿ��б������
  }
  
}
