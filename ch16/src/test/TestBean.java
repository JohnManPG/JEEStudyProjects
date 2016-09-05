package test;

import DAO.OneOneDAO;
import PO.Address;
import PO.Client;
import PO.Company;
import PO.Login;

public class TestBean {
 OneOneDAO dao = new OneOneDAO();
 //添加会员信息
  public void addCompany(){
	  Company company = new Company();
	  Login login = new Login();
	  login.setLoginname("QQ");
	  login.setLoginpwd("123");
	  company.setCompanyname("清华大学出版社");
	  company.setLinkman("汪想");
	  company.setTelephone("010-99999");
	  company.setEmail("www@163.com");
	  //PO对象之间相互设置关联关系
	  login.setCompany(company);
	  company.setLogin(login);
	  dao.addCompany(company);
  }
  //获取会员信息
  public Company loadCompany(Integer id){
	  return dao.loadCompany(id);
	  
  }
  //添加客户信息
  public void addClient(){
	  Client client = new Client();
	  Address address= new Address();
	  address.setProvince("北京市");
	  address.setCity("北京市");
	  address.setStreet("清华园");
	  address.setZipcode("100084");
	  client.setClientname("理想");
	  client.setPhone("010-56565566");
	  client.setEmail("lixiang@163.com");
	  //PO对象之间相互设置关联关系
	  address.setClient(client);
	  client.setAddress(address);
	  dao.addClient(client);
	  
  }
  //获取客户信息
  public Client loadClient(Integer id){
	  return dao.loadClient(id);
  }
}
