package PO;
//PO�������ΪUserInfoPO
public class UserInfoPO {
   private int id;
   private String userName;
   private String password;
public int getId() {
	return id;
}
/**����Java��������ʱ״̬���־û�״̬��������״̬��
 * Ӧ�ó��򶼲�Ӧ���޸�����OID����ˣ��Ƚϰ�ȫ�������ǣ��ڶ���־û���ʱ��
 * ������setId()������ΪΪprivate���ͣ���ֹ�ⲿ������ʸ÷�����*/
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
   
}
