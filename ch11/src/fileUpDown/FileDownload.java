package fileUpDown;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownload extends ActionSupport {
      //指定文件的下载路径
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	//该方法返回一个InputStream类型的输入流，是下载目标文件的入口
	public InputStream getInputStream() throws Exception{    //下载只需要定义一个InputStream对象，上传的话需要输入输出流
		
		return ServletActionContext.getServletContext().getResourceAsStream(path);
	}
	public String execute() throws Exception{
		
		return SUCCESS;   //只需要返回你一个success就行了，剩下的交给struts.xml处理，一个按钮链接一个文件么，所以你可以直接是键值对进：按钮=所要下载的文件
	}
}
