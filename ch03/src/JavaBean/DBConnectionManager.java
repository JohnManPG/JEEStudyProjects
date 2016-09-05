package JavaBean;
import java.sql.Connection;
import java.sql.DriverManager;
//ʹ��JavaBean��װ�����ݿ�ķ��ʣ�������JavaBean��ʵ������getConnection()ʱ���ͻ��ȼ������ݿ�����������ٷ����������ݿ��url���û���������

public class DBConnectionManager {
    //��������
	private String driverName="com.mysql.jdbc.Driver";    //���ݿ��¼��������
	//�������ݿ����ӵ�URL
	private String url="jdbc:mysql://localhost:3306/���ݿ���";  //���ݿ��¼URL
	private String user="root";                //���ݿ��¼�û���
	private String password="";                //���ݿ��¼����
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Connection getConnection(){      //����һ������������������
		try{
		   Class.forName(driverName);
		   return DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
}
