package fileUpDown;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownload extends ActionSupport {
      //ָ���ļ�������·��
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	//�÷�������һ��InputStream���͵���������������Ŀ���ļ������
	public InputStream getInputStream() throws Exception{    //����ֻ��Ҫ����һ��InputStream�����ϴ��Ļ���Ҫ���������
		
		return ServletActionContext.getServletContext().getResourceAsStream(path);
	}
	public String execute() throws Exception{
		
		return SUCCESS;   //ֻ��Ҫ������һ��success�����ˣ�ʣ�µĽ���struts.xml����һ����ť����һ���ļ�ô�����������ֱ���Ǽ�ֵ�Խ�����ť=��Ҫ���ص��ļ�
	}
}
