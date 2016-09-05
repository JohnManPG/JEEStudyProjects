package com.dao;
//为什么使用DAO接口呢？？    接口还有一个作用就是用来规范代码的，在进行模块化开发的时候，首先要写好各个模块的接口
import java.util.List;

import com.entity.User;

public interface UserDao {
   /**
    * 加载User实例
    * @参数ID指定需要加载的User实例的主键值
    * @return 返回加载的User实例
    * */
	
	User get(Integer id);
	
	/**
	 * 保存User实例
	 * @参数user指定需要保存的User实例
	 * @return 返回刚刚保存的User实例的标识属性值
	 * */
	
	Integer save(User user);
	
	/**
	 * 根据用户名查找User
	 * @参数 name 指定查询的用户名
	 * @return 返回用户名对应的全部User
	 * */
	
	List<User> findByName(String name);
}
