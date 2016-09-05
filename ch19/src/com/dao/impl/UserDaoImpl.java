package com.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.UserDao;
import com.entity.User;

public class UserDaoImpl implements UserDao {
    //ʵ����һ��HibernateTemplate��������ִ�г־û�����������������־û������͸������ˣ��������������࣬������Ҫʹ��sessionFactory����session,����session��������־ò�����ݣ�����Ҫ���������ύ����ȸ��ӵĲ�������������࣬����ȥһ��sessionFactory���󣬾Ϳ���ֱ��ִ�г־ò�Ĳ�����
	private HibernateTemplate ht=null;
	//Hibernate�־û���������SessionFactory
	private SessionFactory sessionFactory=null;
	//��������ע���setter����
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}    //����ע��������ļ��ǣ�ref="ע������id,����Bean������ע���id��"
	      //����ע��������ļ��ǣ�constructor-argԪ��
	//��ʼ��HibenateTemplate����
	private HibernateTemplate getHibernateTemplate(){
		if(ht==null){
			ht=new HibernateTemplate(sessionFactory);
		}
		return ht;
	}
		
	public User get(Integer id) {
		//��ȡ��Ӧ����idΪĳ��ֵ�����ݣ�idΪ��������
		return getHibernateTemplate().get(User.class, id);    //����
	}

	public Integer save(User user) {
		
		return (Integer)getHibernateTemplate().save(user);   //����
	}

	public List<User> findByName(String name) {   //List�д���Ƕ���
		//�������Ʋ���ƥ���User
		return (List<User>)getHibernateTemplate().find("from User u where u.name=?",name);
	}                                             //��ѯ
}
