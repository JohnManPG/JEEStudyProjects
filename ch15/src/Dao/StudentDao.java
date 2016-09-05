package Dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import addHibernateFile.HibernateSessionFactory;

import PO.Stuinfo;
                    //单独拿出来一个类用来操作底层数据库
public class StudentDao {
  private Transaction transaction;
  private Session session;
  private Query  query;
  public StudentDao(){   //此类的构造函数
	  
  }
  public boolean saveInfo(Stuinfo info){     //操作底层数据库的DAO层需要1.PO对象  2.Hibernate加载配置文件和映射文件的类
	  try{
		  session=HibernateSessionFactory.getSession();   //通过自定义的方法获取session，但是这样不是有一个缺点么;需要生成很多个HibernateSessionFactory的实例，很是占用空间
		  transaction=session.beginTransaction();   //使用session.beginTransaction()开始一个事务
		  session.save(info);       //向数据库里添加信息时，使用session的save()方法，使用jsp的时候，需要调用他的use:Bean动作，再调用他的setProperty动作为JavaBean中的属性赋值
		  transaction.commit();   //事务提交时，刷新session的缓存
		  session.close();   //关闭session后，对象从持久状态转化为托管状态
		  return true;
	  }catch(Exception e){
		  message("saveInfo.error:"+e);
		  e.printStackTrace();
		  return false;
	  }
  }
  
     //查找单个的记录信息
  public List FindInfo(String type,Object value){
	  session=HibernateSessionFactory.getSession();     //干什么事务之前必须先生成 一个session对象实例，这个session就是用来操作数据库中的数据的
	  try{
		  transaction=session.beginTransaction();    //开启查询事务
		  //HQL语句
		  String queryString="from Stuinfo as model where model."+type+"=?";   //这句是SQL语句，?是占位符
		  query=session.createQuery(queryString);
		  query.setParameter(0, value);           //第一个问号的位置是0，value的值通过实参向形参中传
		  List list=query.list();                 //查询肯定要用到Query类，再用Query中的List方法
		  transaction.commit();                  //事务提交方法
		  session.close();                         //session关闭
		  return list;
	  }catch(Exception e){
		  message("findInfo.error:"+e);
		  e.printStackTrace();
		  return null;
	  }	  
  } 
     //查找表中所有的记录，并封装成对象存储在List集合里，执行的结果是返回一个List对象    
  public List findAllInfo(){      //每一个方法完成一个功能，所以看一个方法要先明白他的功能
	  session=HibernateSessionFactory.getSession();      //HibrernateSessionFactory中定义这样一个方法
	  try{
		  transaction=session.beginTransaction();      //启动一个事务
		  //HQL语句
		  String queryString="from Stuinfo";     //从这个表中取出所有的记录并封装成对象存在list中
		  query=session.createQuery(queryString);
		  List list=query.list();     //query执行HQL语句，并取出表中所有的记录将记录封装成对象存储在liat集合中
		  transaction.commit();       //刷新缓存
		  session.close();    //关闭session就是将持久态转变为脱管态
		  return list;      //返回一个List
	  }catch(Exception e){
		  message("findAllInfo.error:"+e);
		  e.printStackTrace();
		  return null;
	  }	  
  }
  public boolean deleteInfo(String id){
	  try{
		  session=HibernateSessionFactory.getSession();       //获取session
		  transaction=session.beginTransaction();      //开启事务
		  Stuinfo info = new Stuinfo();               //创建实例对象
		  info=(Stuinfo) session.get(Stuinfo.class, id);    //先要通过get()方法获取要删除的对象
		  session.delete(info);                              //再通过delete()方法删除一个持久化对象
		  transaction.commit();                      //提交事务
		  session.close();                     //session关闭
		  return true;	  
	  }catch(Exception e){
		  message("deleteInfo.error:"+e);
		  e.printStackTrace();
		  return false;
	  }
  }
  
  public boolean updateInfo(Stuinfo info){
	  try{
		  session=HibernateSessionFactory.getSession();        //获取session
		  transaction=session.beginTransaction();    //开启事务
		  session.update(info);     //通过session中的update()方法更新一个对象
		  transaction.commit();         //事务提交
		  session.close();            //session关闭
		  return true;	  
	  }catch(Exception e){
		  message("updateInfo.error:"+e);
		  return false;
	  }
  }
  public void message(String mess){
	  int type=JOptionPane.YES_NO_OPTION;
 	  String title="提示信息";
 	  JOptionPane.showMessageDialog(null, mess,title,type);
  }
}
