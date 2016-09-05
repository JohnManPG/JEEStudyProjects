package test;

import DAO.OneOneDAO;
import PO.Address;
import PO.Client;
import PO.Company;
import PO.Login;

public class TestBean {
 OneOneDAO dao = new OneOneDAO();
 //��ӻ�Ա��Ϣ
  public void addCompany(){
	  Company company = new Company();
	  Login login = new Login();
	  login.setLoginname("QQ");
	  login.setLoginpwd("123");
	  company.setCompanyname("�廪��ѧ������");
	  company.setLinkman("����");
	  company.setTelephone("010-99999");
	  company.setEmail("www@163.com");
	  //PO����֮���໥���ù�����ϵ
	  login.setCompany(company);
	  company.setLogin(login);
	  dao.addCompany(company);
  }
  //��ȡ��Ա��Ϣ
  public Company loadCompany(Integer id){
	  return dao.loadCompany(id);
	  
  }
  //��ӿͻ���Ϣ
  public void addClient(){
	  Client client = new Client();
	  Address address= new Address();
	  address.setProvince("������");
	  address.setCity("������");
	  address.setStreet("�廪԰");
	  address.setZipcode("100084");
	  client.setClientname("����");
	  client.setPhone("010-56565566");
	  client.setEmail("lixiang@163.com");
	  //PO����֮���໥���ù�����ϵ
	  address.setClient(client);
	  client.setAddress(address);
	  dao.addClient(client);
	  
  }
  //��ȡ�ͻ���Ϣ
  public Client loadClient(Integer id){
	  return dao.loadClient(id);
  }
}
