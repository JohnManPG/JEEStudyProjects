package com.dao;
//Ϊʲôʹ��DAO�ӿ��أ���    �ӿڻ���һ�����þ��������淶����ģ��ڽ���ģ�黯������ʱ������Ҫд�ø���ģ��Ľӿ�
import java.util.List;

import com.entity.User;

public interface UserDao {
   /**
    * ����Userʵ��
    * @����IDָ����Ҫ���ص�Userʵ��������ֵ
    * @return ���ؼ��ص�Userʵ��
    * */
	
	User get(Integer id);
	
	/**
	 * ����Userʵ��
	 * @����userָ����Ҫ�����Userʵ��
	 * @return ���ظոձ����Userʵ���ı�ʶ����ֵ
	 * */
	
	Integer save(User user);
	
	/**
	 * �����û�������User
	 * @���� name ָ����ѯ���û���
	 * @return �����û�����Ӧ��ȫ��User
	 * */
	
	List<User> findByName(String name);
}
