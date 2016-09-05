package fileUpDown;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
      //文件标题
	private String title;     
	//上传文件域，也就是文件
	private File upload;
	//上传文件名
	private String uploadFileName;
	//获取在struts.xml文件配置的文件保存路径，在struts.xml中保存路径，就少了在action里定义，便于修改
	private String savePath;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() throws Exception {
		return ServletActionContext.getServletContext().getRealPath(savePath);//将struts.xml中配置的虚拟路径转化为实际路径
	}
	public void setSavePath(String value) {
		this.savePath = value;
	}
	public String execute() throws Exception{
		//以服务器的文件保存地址和原文件名建立上传文件输出流
		FileOutputStream fos=new FileOutputStream(getSavePath()+"\\"+getUploadFileName());//类比复制文件
	    //定义输入流对象，世界上你拥有的唯一多了，你站的地方就是唯一的，通过位置就可以找到你
		FileInputStream fis =new FileInputStream(getUpload());
		byte []buffer=new byte[1024];
		int len=0;        //read()方法从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中
		while((len=fis.read(buffer))>0){
			fos.write(buffer, 0, len); //将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流
		}
		fos.close();         //输出流关闭
		return SUCCESS;
	}
	
}
