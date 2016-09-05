package DAO;

import org.hibernate.*;

import addHibFile.HibernateSessionFactory;
import PO.*;

public class OneOneDAO {
	//添加会员的方法
   public void addCompany(Company company){
	   Session session = HibernateSessionFactory.currentSession();
	   Transaction ts = null;
	   try{
		   ts=session.beginTransaction();
		   session.save(company);
		   ts.commit();
	   }catch(Exception e){
		   ts.rollback();
		   System.out.println("【系统错误】在OneOneDAO的addCompany方法中出错：");
		   e.printStackTrace();
	   }finally{
		   HibernateSessionFactory.closeSession();
	   }
   }
   //获取会员信息
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
		   System.out.println("【系统错误】在OneOneDAO的loadCompany()方法中出错：");
		   e.printStackTrace();
	   }finally{
		   HibernateSessionFactory.closeSession();
	   }
	   return company;
   }
   //添加客户信息
   public void addClient(Client client){
	   Session session = HibernateSessionFactory.currentSession();
	   Transaction ts = null;
	   try{
		   ts=session.beginTransaction();
		   session.save(client);
		   ts.commit();
	   }catch(Exception e){
		   ts.rollback();
		   System.out.println("【系统错误】在OneOneDAO的addClient()方法中出错：");
		   e.printStackTrace();
	   }finally{
		   HibernateSessionFactory.closeSession();
	   }
   }
   //获取客户信息
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
		   System.out.println("【系统错误】在OneOneDAO的loadClient()方法中出错：");
		   e.printStackTrace();
	   }finally{
		   HibernateSessionFactory.closeSession();
	   }
	   return client;
   }
}
