package com.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.UserDao;
import com.entity.User;

public class UserDaoImpl implements UserDao {
    //实例化一个HibernateTemplate对象，用于执行持久化操作，引入这个类后持久化操作就更方便了，如果不引入这个类，首先需要使用sessionFactory创建session,再用session对象操作持久层的数据，还需要开启事务，提交事务等复杂的操作，引入这个类，传进去一个sessionFactory对象，就可以直接执行持久层的操作了
	private HibernateTemplate ht=null;
	//Hibernate持久化操作所需SessionFactory
	private SessionFactory sessionFactory=null;
	//用于依赖注入的setter方法
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}    //设置注入的配置文件是：ref="注入对象的id,即在Bean工厂里注册的id号"
	      //构造注入的配置文件是：constructor-arg元素
	//初始化HibenateTemplate方法
	private HibernateTemplate getHibernateTemplate(){
		if(ht==null){
			ht=new HibernateTemplate(sessionFactory);
		}
		return ht;
	}
		
	public User get(Integer id) {
		//获取对应表中id为某个值的数据，id为主键索引
		return getHibernateTemplate().get(User.class, id);    //查找
	}

	public Integer save(User user) {
		
		return (Integer)getHibernateTemplate().save(user);   //保存
	}

	public List<User> findByName(String name) {   //List中存的是对象
		//根据名称查找匹配的User
		return (List<User>)getHibernateTemplate().find("from User u where u.name=?",name);
	}                                             //查询
}
