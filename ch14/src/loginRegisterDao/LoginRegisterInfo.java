package loginRegisterDao;

//有两个业务就要有两个Action,也可以有一个，采用struts2的动态调用方法这个API
import java.util.List;
//将登录和注册业务功能封装到类LoginRegisterInfo（JavaBean）中
import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import PO.UserInfoPO;
import addHibernateFile.HibernateSessionFactory;

public class LoginRegisterInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    HibernateSessionFactory getSession;
    public LoginRegisterInfo(){   //提供一个无参的构造函数
    }
    public String saveInfo(UserInfoPO info){  //这是一个临时状态info对象
    	String mess="error";
    	getSession = new HibernateSessionFactory();
    	session = getSession.getSession();
    	try{
    		transaction=session.beginTransaction();
    		session.save(info);       //Session的save()方法使一个临时对象转变为持久化对象,save()方法是用来持久化一个临时对象的，这是一个持久态的对象，将PO对象中的属性的值保存到PrepareStatement的预编译的Sql语句中，完成数据的存储插入
    		/**在默认情况下，session会在下面的时间点清理缓存
    		 * 1 当应用程序调用net.sf.hibernate.Transaction的commit()方法时，commit()方法先清理缓存，然后再看数据库提交事务
    		 * 2 当调用session的find()或者iterator()时，如果缓存中持久化对象的属性发生了变化，就会先清理缓存，以保证查询结果能反映持久化对象的最新状态。
    		 * 3 当应用程序显式调用session的flush()方时。
    		 * Session的setFlushMode()方法用于设定清理缓存的时间点。FlushMode类定义了三种不同的清理模式：
    		 * FlushMode.AUTO、FlushMode.COMMIT和FlushMode.NEVER。例如，以下代码显示把清理模式设为FlushModo.Commit：*/
    		
    		
    		transaction.commit();      //事务提交时，开始刷新缓存，开始执行SQL语句
    		mess="success";            //没有关闭的话，还是持久化对象
    		return mess;
    		
    	}catch(Exception e){
    		message("RegisterInfo.error:"+e);
    		e.printStackTrace();             //最后的链接关闭也是有顺序的，否则会报异常
    		return null;
    		
    	}
    }   
    public List queryInfo(String type,Object value){
    	getSession=new HibernateSessionFactory();
    	session = getSession.getSession();
    	try{
    		           //sql语句中的问号是占位符
    		String hqlsql="from UserInfoPO as u where u.userName=?";
    		query=session.createQuery(hqlsql);//session就是用来各种操作数据库，底层的事务操作，所以是DAO层
    		query.setParameter(0, value);
    		List list=query.list();
    		transaction=session.beginTransaction();
    		transaction.commit();
    		return list;
    		
    	}catch(Exception e){
    		message("LoginRegisterInfo类中有异常，异常为:"+e);
    		e.printStackTrace();
    		return null;   		
    	}
    }
    public void message(String mess){
    	int type=JOptionPane.YES_NO_OPTION;
    	String title="提示信息";
    	JOptionPane.showMessageDialog(null, mess,title,type);
    }   
}
