package studentAction;

import java.util.List;

import javax.swing.JOptionPane;

import Dao.StudentDao;
import PO.Stuinfo;

import com.opensymphony.xwork2.ActionSupport;
   //这个Action的功能：完成添加信息的封装并将传递给持久化对象传到数据库中，使之对象变为持久化太
public class AddMessageAction extends ActionSupport {
	  private String id;
	  private String name;     //通过struts的内部机制将请求参数中的值赋给Action中的属性，再将这些值通过PO对象 的setxxx()方法设置PO对象属性的值
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
		  if(this.getId()==null||this.getId().length()==0){
			  addFieldError("id","学号不允许为空");
		  }else{
			  StudentDao dao = new StudentDao();   //也要熟悉这些命名方式，一些输入校验会用到数据库中部分的值
			  List list = dao.FindInfo("id", this.getId());
			  if(!list.isEmpty()){
				  addFieldError("id", "学号已存在！");
			  }
		  }
		  if(this.getName()==null || this.getName().length()==0){
			  addFieldError("name", "姓名不允许为空！");
		  }
		  if(this.getAge()>130){
			  addFieldError("age", "请认真核实年龄！");
		  }
		  if(this.getWeight()>500){
			  addFieldError("weight", "请认真核实体重！");
		  }
	  }
	  public String execute() throws Exception{
		  StudentDao dao = new StudentDao();
		  boolean save=dao.saveInfo(info());    //传过去的还是一个info实例对象
		  if(save){
			  message=SUCCESS;
		  }
		  return message;	  
	  }
	  //返回一个具体的info实例，有属性，并且有属性值
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
	 	  String title="提示信息";
	 	  JOptionPane.showMessageDialog(null, mess,title,type);
	  }
}
