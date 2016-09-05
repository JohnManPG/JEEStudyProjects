package fileUpDown;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
      //�ļ�����
	private String title;     
	//�ϴ��ļ���Ҳ�����ļ�
	private File upload;
	//�ϴ��ļ���
	private String uploadFileName;
	//��ȡ��struts.xml�ļ����õ��ļ�����·������struts.xml�б���·������������action�ﶨ�壬�����޸�
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
		return ServletActionContext.getServletContext().getRealPath(savePath);//��struts.xml�����õ�����·��ת��Ϊʵ��·��
	}
	public void setSavePath(String value) {
		this.savePath = value;
	}
	public String execute() throws Exception{
		//�Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
		FileOutputStream fos=new FileOutputStream(getSavePath()+"\\"+getUploadFileName());//��ȸ����ļ�
	    //����������������������ӵ�е�Ψһ���ˣ���վ�ĵط�����Ψһ�ģ�ͨ��λ�þͿ����ҵ���
		FileInputStream fis =new FileInputStream(getUpload());
		byte []buffer=new byte[1024];
		int len=0;        //read()�����Ӵ��������н���� b.length ���ֽڵ����ݶ���һ�� byte ������
		while((len=fis.read(buffer))>0){
			fos.write(buffer, 0, len); //��ָ�� byte �����д�ƫ���� off ��ʼ�� len ���ֽ�д����ļ������
		}
		fos.close();         //������ر�
		return SUCCESS;
	}
	
}
