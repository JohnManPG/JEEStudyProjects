package com.entity;

import java.io.Serializable;
   //只要从数据库中取出来的数据转化为对象，都是这个对象，这样你才可以调用setXX()方法来与表单提交过来的数据进行比较
public class User implements Serializable {
     private Integer intId;
     private String name;
     private String password;
     public User(){
    	 
     }
     
     public User(Integer intId,String name,String password){
    	 this.intId=intId;
    	 this.name=name;
    	 this.password=password;
     }

	public Integer getIntId() {
		return intId;
	}

	public void setIntId(Integer intId) {
		this.intId = intId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}    
}
