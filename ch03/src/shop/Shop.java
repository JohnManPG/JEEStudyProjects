package shop;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;

public class Shop {
	private Vector v=new Vector();   //声明一个集合，存储一些对象
	private String submit=null;
	private String item=null;
	private void addItem(String name){    //JavaBean就是用来处理数据的
		v.addElement(name);
	}
	private void removeItem(String name){      //保存在Java虚拟机的内存上，使用Vector集合，集合存的是对象
		v.removeElement(name);
	}
	public void setItem(String name){
		item=name;
	}
	public void setSubmit(String s){    //使用JavaBean可以完成添加删除的功能
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
		if(submit.equals("添加"))
			addItem(item);
		else if (submit.equals("删除"))                         //这个方法有事为什么？？？？
			removeItem(item);         //在这里面放一写正则表达式
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
