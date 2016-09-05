package DAO;

import org.hibernate.*;

import addHibFile.HibernateSessionFactory;
import PO.*;

public class OneOneDAO {
	//��ӻ�Ա�ķ���
   public void addCompany(Company company){
	   Session session = HibernateSessionFactory.currentSession();
	   Transaction ts = null;
	   try{
		   ts=session.beginTransaction();
		   session.save(company);
		   ts.commit();
	   }catch(Exception e){
		   ts.rollback();
		   System.out.println("��ϵͳ������OneOneDAO��addCompany�����г���");
		   e.printStackTrace();
	   }finally{
		   HibernateSessionFactory.closeSession();
	   }
   }
   //��ȡ��Ա��Ϣ
   public Company loadCompany(Integer id){
	   Session session = HibernateSessionFactory.currentSession();
	   Transaction ts = null;
	   Company company=null;
	   try{
		   ts=session.beginTransaction();
		   company=(Company) session.get(Company.class, id);
		   ts.commit();
	   }catch(Exception e){
		   ts.rollback();
		   System.out.println("��ϵͳ������OneOneDAO��loadCompany()�����г���");
		   e.printStackTrace();
	   }finally{
		   HibernateSessionFactory.closeSession();
	   }
	   return company;
   }
   //��ӿͻ���Ϣ
   public void addClient(Client client){
	   Session session = HibernateSessionFactory.currentSession();
	   Transaction ts = null;
	   try{
		   ts=session.beginTransaction();
		   session.save(client);
		   ts.commit();
	   }catch(Exception e){
		   ts.rollback();
		   System.out.println("��ϵͳ������OneOneDAO��addClient()�����г���");
		   e.printStackTrace();
	   }finally{
		   HibernateSessionFactory.closeSession();
	   }
   }
   //��ȡ�ͻ���Ϣ
   public Client loadClient(Integer id){
	   Session session = HibernateSessionFactory.currentSession();
	   Transaction ts = null;
	   Client client=null;
	   try{
		   ts=session.beginTransaction();
		   client=(Client) session.get(Client.class, id);
		   ts.commit();
	   }catch(Exception e){
		   ts.rollback();
		   System.out.println("��ϵͳ������OneOneDAO��loadClient()�����г���");
		   e.printStackTrace();
	   }finally{
		   HibernateSessionFactory.closeSession();
	   }
	   return client;
   }
}
