package com.entity;

import java.io.Serializable;
   //ֻҪ�����ݿ���ȡ����������ת��Ϊ���󣬶����������������ſ��Ե���setXX()����������ύ���������ݽ��бȽ�
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
