package shop;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;

public class Shop {
	private Vector v=new Vector();   //����һ�����ϣ��洢һЩ����
	private String submit=null;
	private String item=null;
	private void addItem(String name){    //JavaBean���������������ݵ�
		v.addElement(name);
	}
	private void removeItem(String name){      //������Java��������ڴ��ϣ�ʹ��Vector���ϣ����ϴ���Ƕ���
		v.removeElement(name);
	}
	public void setItem(String name){
		item=name;
	}
	public void setSubmit(String s){    //ʹ��JavaBean����������ɾ���Ĺ���
		submit = s;
	}
	public String[] getItems(){
		String []s= new String[v.size()];
		v.copyInto(s);
		return s;
	}
	public void processRequest(HttpServletRequest request){
		if(submit==null)
			addItem(item);
		if(submit.equals("���"))
			addItem(item);
		else if (submit.equals("ɾ��"))                         //�����������Ϊʲô��������
			removeItem(item);         //���������һд������ʽ
		reset();
	}
	private void reset(){
		setSubmit(null);
		setItem(null);
	}
	public String getSubmit(){
		return submit;
	}
	public String getItem(){
		return item;
	}
}
