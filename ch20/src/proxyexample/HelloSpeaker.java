package proxyexample;

import java.util.logging.Level;     //Java API���ṩ��־��
import java.util.logging.Logger;

public class HelloSpeaker {
     //ͨ��Logger��ľ�̬����Logger.getLogger()��ʵ��������ȡ����
	private Logger logger =Logger.getLogger(this.getClass().getName());
	public void hello(String name)
	{   //��ʾ��־������������Ҫ���ܣ����԰���ʾ��־���������������ȥŪ�����Ծ�Ҫ��̬����Ͷ�̬����
		logger.log(Level.INFO,"hello()������ʼִ��");//������ʼִ��ʱ������־��Ҫѧ�ῴ��־
		System.out.println("hello,"+name);   //�������Ҫ����
		logger.log(Level.INFO,"hello()����ִ�н���");  //����ִ�����ʱ������־
	}
	//�����ִ�б���������־
    public static void main(String[] args){
    	HelloSpeaker h=new HelloSpeaker();
    	h.hello("����");
    }
}
