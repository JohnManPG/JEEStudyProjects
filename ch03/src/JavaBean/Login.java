package JavaBean;

public class Login {     //JavaBean���밴��Java�ķ�װ��ԭ���JavaBean�Ĺ淶���б��룬��װ��ԭ�����ʹ��private�Ľ�������
	 private String userName;//�û���
	 private String password;//����
	 public Login(){          //JavaBean���޲ι��췽���������дҲ���ԣ�JVM�ڴ���ʵ��ʱ���Զ������Զ����ɵ��޲ι��췽�����������д���вεĹ��췽����ô�ͱ���Ҫд�޲εĹ��췽��
		 
	 }
	public String getUserName() {     //�����û�����������
		try{
			//ͨ��getBytes("ISO-8859-1")����������ת��Ϊ��׼�ַ�
			byte []b = userName.getBytes("ISO-8859-1");
			//���ֽ�ת��ΪUTF-8����
		    userName=new String(b,"UTF-8");
		    return userName;
		}catch(Exception e){
			return userName;			
		}		
	}
	public void setUserName(String userName) {    //�����û�����������
		this.userName = userName;
	}
	public String getPassword() {      //��������
		try{
			//ͨ��getBytes("ISO-8859-1")����������ת��Ϊ��׼�ַ�
			byte []b = password.getBytes("ISO-8859-1");
			//���ֽ�ת��ΪUTF-8����
			password=new String(b,"UTF-8");
		    return password;
		}catch(Exception e){
			return password;			
		}		
	}
	public void setPassword(String password) {    //��������
		this.password = password;
	}
}     //ΪJavaBean�����Ը�ֵ�����ַ�����1.ʹ��jsp:setproperty������2.ʹ�ñ�Ϊ���Ը�ֵ
      //�����������������JavaBean ���Ե�������ͬ��JSP������Զ����ַ���ת��ΪJavaBean���Ե�����
