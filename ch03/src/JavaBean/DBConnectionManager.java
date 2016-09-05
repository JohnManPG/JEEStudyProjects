package JavaBean;
import java.sql.Connection;
import java.sql.DriverManager;
//使用JavaBean封装对数据库的访问，当调用JavaBean的实例方法getConnection()时，就会先加载数据库的驱动程序，再返回链接数据库的url、用户名和密码

public class DBConnectionManager {
    //驱动程序
	private String driverName="com.mysql.jdbc.Driver";    //数据库登录驱动程序
	//设置数据库连接的URL
	private String url="jdbc:mysql://localhost:3306/数据库名";  //数据库登录URL
	private String user="root";                //数据库登录用户名
	private String password="";                //数据库登录密码
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
	
	public Connection getConnection(){      //定义一个公共方法供外界访问
		try{
		   Class.forName(driverName);
		   return DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
}
