package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
       //������һ���򵥵�servlet���
public class ShowMessage extends HttpServlet {

	
	public ShowMessage() {      //���췽��,���൱�ڴ���һ��servletʵ��
		super();
	}

	
	public void destroy() {      //servlet���ٷ���
		super.destroy(); 
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {      //���񷽷�

		response.setContentType("text/html;charset=gb2312");   //�����ڳ�ʼ����Ӧҳ���������HTML��ʽ����ʼ��ҳ����ʾ���ַ��ı�����ʽ��gb2312
		PrintWriter out = response.getWriter();//����Ҫ���ͻ��˵����ݻ�ȡ��
		String number = request.getParameter("number");//��ȡ�ͻ��ύ����Ϣ,ת����ʱ�����û���ͬһ���������������������һ���ģ����Կ�������Щ������ת������ҳ��������Щ����
		Double n = Double.parseDouble(number);//���ַ������Double����
		out.println(number+"��ƽ��:"+(n*n));     //����servlet��ӡ��ҳ��ķ�����jsp����<%=  %>
	}                                         //ת����ʱ���������URL�ĵ�ַ�ǲ����ģ����������ҳ��ʵ�ֵ�ҵ���߼������ǻ���ʾ��Verify��ҳ����

	public void init() throws ServletException {    //��ʼ������
		
	}
}
