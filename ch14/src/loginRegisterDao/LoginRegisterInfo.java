package loginRegisterDao;

//������ҵ���Ҫ������Action,Ҳ������һ��������struts2�Ķ�̬���÷������API
import java.util.List;
//����¼��ע��ҵ���ܷ�װ����LoginRegisterInfo��JavaBean����
import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import PO.UserInfoPO;
import addHibernateFile.HibernateSessionFactory;

public class LoginRegisterInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    HibernateSessionFactory getSession;
    public LoginRegisterInfo(){   //�ṩһ���޲εĹ��캯��
    }
    public String saveInfo(UserInfoPO info){  //����һ����ʱ״̬info����
    	String mess="error";
    	getSession = new HibernateSessionFactory();
    	session = getSession.getSession();
    	try{
    		transaction=session.beginTransaction();
    		session.save(info);       //Session��save()����ʹһ����ʱ����ת��Ϊ�־û�����,save()�����������־û�һ����ʱ����ģ�����һ���־�̬�Ķ��󣬽�PO�����е����Ե�ֵ���浽PrepareStatement��Ԥ�����Sql����У�������ݵĴ洢����
    		/**��Ĭ������£�session���������ʱ���������
    		 * 1 ��Ӧ�ó������net.sf.hibernate.Transaction��commit()����ʱ��commit()�����������棬Ȼ���ٿ����ݿ��ύ����
    		 * 2 ������session��find()����iterator()ʱ����������г־û���������Է����˱仯���ͻ��������棬�Ա�֤��ѯ����ܷ�ӳ�־û����������״̬��
    		 * 3 ��Ӧ�ó�����ʽ����session��flush()��ʱ��
    		 * Session��setFlushMode()���������趨�������ʱ��㡣FlushMode�ඨ�������ֲ�ͬ������ģʽ��
    		 * FlushMode.AUTO��FlushMode.COMMIT��FlushMode.NEVER�����磬���´�����ʾ������ģʽ��ΪFlushModo.Commit��*/
    		
    		
    		transaction.commit();      //�����ύʱ����ʼˢ�»��棬��ʼִ��SQL���
    		mess="success";            //û�йرյĻ������ǳ־û�����
    		return mess;
    		
    	}catch(Exception e){
    		message("RegisterInfo.error:"+e);
    		e.printStackTrace();             //�������ӹر�Ҳ����˳��ģ�����ᱨ�쳣
    		return null;
    		
    	}
    }   
    public List queryInfo(String type,Object value){
    	getSession=new HibernateSessionFactory();
    	session = getSession.getSession();
    	try{
    		           //sql����е��ʺ���ռλ��
    		String hqlsql="from UserInfoPO as u where u.userName=?";
    		query=session.createQuery(hqlsql);//session�����������ֲ������ݿ⣬�ײ�����������������DAO��
    		query.setParameter(0, value);
    		List list=query.list();
    		transaction=session.beginTransaction();
    		transaction.commit();
    		return list;
    		
    	}catch(Exception e){
    		message("LoginRegisterInfo�������쳣���쳣Ϊ:"+e);
    		e.printStackTrace();
    		return null;   		
    	}
    }
    public void message(String mess){
    	int type=JOptionPane.YES_NO_OPTION;
    	String title="��ʾ��Ϣ";
    	JOptionPane.showMessageDialog(null, mess,title,type);
    }   
}
