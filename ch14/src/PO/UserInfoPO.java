package PO;
//PO对象的类为UserInfoPO
public class UserInfoPO {
   private int id;
   private String userName;
   private String password;
public int getId() {
	return id;
}
/**无论Java对象处于临时状态、持久化状态还是游离状态，
 * 应用程序都不应该修改它的OID。因此，比较安全的做法是，在定义持久化类时，
 * 把它的setId()方法设为为private类型，禁止外部程序访问该方法。*/
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
