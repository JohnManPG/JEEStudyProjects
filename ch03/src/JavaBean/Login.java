package JavaBean;

public class Login {     //JavaBean必须按照Java的封装性原理和JavaBean的规范进行编码，封装性原理就是使用private的进行修饰
	 private String userName;//用户名
	 private String password;//密码
	 public Login(){          //JavaBean的无参构造方法，如果不写也可以，JVM在创建实例时会自动调用自动生成的无参构造方法，但是如果写了有参的构造方法那么就必须要写无参的构造方法
		 
	 }
	public String getUserName() {     //返回用户名，访问器
		try{
			//通过getBytes("ISO-8859-1")方法把字体转换为标准字符
			byte []b = userName.getBytes("ISO-8859-1");
			//把字节转换为UTF-8编码
		    userName=new String(b,"UTF-8");
		    return userName;
		}catch(Exception e){
			return userName;			
		}		
	}
	public void setUserName(String userName) {    //设置用户名，设置器
		this.userName = userName;
	}
	public String getPassword() {      //访问密码
		try{
			//通过getBytes("ISO-8859-1")方法把字体转换为标准字符
			byte []b = password.getBytes("ISO-8859-1");
			//把字节转换为UTF-8编码
			password=new String(b,"UTF-8");
		    return password;
		}catch(Exception e){
			return password;			
		}		
	}
	public void setPassword(String password) {    //设置密码
		this.password = password;
	}
}     //为JavaBean的属性赋值有两种方法：1.使用jsp:setproperty动作，2.使用表单为属性赋值
      //如果表单参数的名字与JavaBean 属性的名字相同，JSP引擎会自动将字符串转换为JavaBean属性的类型
