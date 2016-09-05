package Dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import addHibernateFile.HibernateSessionFactory;

import PO.Stuinfo;
                    //�����ó���һ�������������ײ����ݿ�
public class StudentDao {
  private Transaction transaction;
  private Session session;
  private Query  query;
  public StudentDao(){   //����Ĺ��캯��
	  
  }
  public boolean saveInfo(Stuinfo info){     //�����ײ����ݿ��DAO����Ҫ1.PO����  2.Hibernate���������ļ���ӳ���ļ�����
	  try{
		  session=HibernateSessionFactory.getSession();   //ͨ���Զ���ķ�����ȡsession����������������һ��ȱ��ô;��Ҫ���ɺܶ��HibernateSessionFactory��ʵ��������ռ�ÿռ�
		  transaction=session.beginTransaction();   //ʹ��session.beginTransaction()��ʼһ������
		  session.save(info);       //�����ݿ��������Ϣʱ��ʹ��session��save()������ʹ��jsp��ʱ����Ҫ��������use:Bean�������ٵ�������setProperty����ΪJavaBean�е����Ը�ֵ
		  transaction.commit();   //�����ύʱ��ˢ��session�Ļ���
		  session.close();   //�ر�session�󣬶���ӳ־�״̬ת��Ϊ�й�״̬
		  return true;
	  }catch(Exception e){
		  message("saveInfo.error:"+e);
		  e.printStackTrace();
		  return false;
	  }
  }
  
     //���ҵ����ļ�¼��Ϣ
  public List FindInfo(String type,Object value){
	  session=HibernateSessionFactory.getSession();     //��ʲô����֮ǰ���������� һ��session����ʵ�������session���������������ݿ��е����ݵ�
	  try{
		  transaction=session.beginTransaction();    //������ѯ����
		  //HQL���
		  String queryString="from Stuinfo as model where model."+type+"=?";   //�����SQL��䣬?��ռλ��
		  query=session.createQuery(queryString);
		  query.setParameter(0, value);           //��һ���ʺŵ�λ����0��value��ֵͨ��ʵ�����β��д�
		  List list=query.list();                 //��ѯ�϶�Ҫ�õ�Query�࣬����Query�е�List����
		  transaction.commit();                  //�����ύ����
		  session.close();                         //session�ر�
		  return list;
	  }catch(Exception e){
		  message("findInfo.error:"+e);
		  e.printStackTrace();
		  return null;
	  }	  
  } 
     //���ұ������еļ�¼������װ�ɶ���洢��List�����ִ�еĽ���Ƿ���һ��List����    
  public List findAllInfo(){      //ÿһ���������һ�����ܣ����Կ�һ������Ҫ���������Ĺ���
	  session=HibernateSessionFactory.getSession();      //HibrernateSessionFactory�ж�������һ������
	  try{
		  transaction=session.beginTransaction();      //����һ������
		  //HQL���
		  String queryString="from Stuinfo";     //���������ȡ�����еļ�¼����װ�ɶ������list��
		  query=session.createQuery(queryString);
		  List list=query.list();     //queryִ��HQL��䣬��ȡ���������еļ�¼����¼��װ�ɶ���洢��liat������
		  transaction.commit();       //ˢ�»���
		  session.close();    //�ر�session���ǽ��־�̬ת��Ϊ�ѹ�̬
		  return list;      //����һ��List
	  }catch(Exception e){
		  message("findAllInfo.error:"+e);
		  e.printStackTrace();
		  return null;
	  }	  
  }
  public boolean deleteInfo(String id){
	  try{
		  session=HibernateSessionFactory.getSession();       //��ȡsession
		  transaction=session.beginTransaction();      //��������
		  Stuinfo info = new Stuinfo();               //����ʵ������
		  info=(Stuinfo) session.get(Stuinfo.class, id);    //��Ҫͨ��get()������ȡҪɾ���Ķ���
		  session.delete(info);                              //��ͨ��delete()����ɾ��һ���־û�����
		  transaction.commit();                      //�ύ����
		  session.close();                     //session�ر�
		  return true;	  
	  }catch(Exception e){
		  message("deleteInfo.error:"+e);
		  e.printStackTrace();
		  return false;
	  }
  }
  
  public boolean updateInfo(Stuinfo info){
	  try{
		  session=HibernateSessionFactory.getSession();        //��ȡsession
		  transaction=session.beginTransaction();    //��������
		  session.update(info);     //ͨ��session�е�update()��������һ������
		  transaction.commit();         //�����ύ
		  session.close();            //session�ر�
		  return true;	  
	  }catch(Exception e){
		  message("updateInfo.error:"+e);
		  return false;
	  }
  }
  public void message(String mess){
	  int type=JOptionPane.YES_NO_OPTION;
 	  String title="��ʾ��Ϣ";
 	  JOptionPane.showMessageDialog(null, mess,title,type);
  }
}
