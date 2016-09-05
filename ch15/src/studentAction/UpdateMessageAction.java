package studentAction;

import javax.swing.JOptionPane;

import Dao.StudentDao;
import PO.Stuinfo;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateMessageAction extends ActionSupport {
  private String id;
  private String name;
  private String sex;
  private int age;
  private float weight;
  private String message="input";
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public float getWeight() {
	return weight;
}
public void setWeight(float weight) {
	this.weight = weight;
}
  public void validate(){
	  if(this.getName()==null || this.getName().length()==0){
		  addFieldError("name", "����������Ϊ��");
	  }
	  if(this.getAge()>130){
		  addFieldError("age", "�������ʵ����");
	  }
	  if(this.getWeight()>500){
		  addFieldError("weight", "�������ʵ���أ�");
	  }
  }
  public String execute() throws Exception{
	  StudentDao dao = new StudentDao();
	  boolean update = dao.updateInfo(info());
	  if(update){
		  message=SUCCESS;
	  }
	  return message;
  }
  public Stuinfo info(){
	  Stuinfo info=new Stuinfo();
	  info.setId(this.getId());
	  info.setName(this.getName());
	  info.setSex(this.getSex());
	  info.setAge(this.getAge());
	  info.setWeight(this.getWeight());
	  return info;
  }
  public void message(String mess){
	  int type=JOptionPane.YES_NO_OPTION;
 	  String title="��ʾ��Ϣ";
 	  JOptionPane.showMessageDialog(null, mess,title,type);
  }
}
