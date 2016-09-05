package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//����Ǽ򵥵�servlet���
public class Verify extends HttpServlet {

	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String number = request.getParameter("number");
		try{
		//�����ǰ��ַ���ת��ΪDouble���ͣ�Ҳ����ת��Ϊinteger���͵ȵȵİ�װ�࣬�ǽ���ͨ���������Ͱ�װ�ɶ���Ŀ������������������ȫ���Ƕ��󣬰�����ͨ�����ݶ���
	     Double n = Double.parseDouble(number);
	     if(n>100 || n<-100){
	    	 //�ض���sendForword.jspҳ��
	    	 response.sendRedirect("sendForword.jsp");
	     }else{
	    	 
	    	 RequestDispatcher dispatcher = request.getRequestDispatcher("ShowMessage");   //����һ��ת���Ķ��󣬲�����ȥ��Ҫת����URL
	    	 dispatcher.forward(request, response);//ת������һ��servlet�ļ�
	     }       //ת�����õ���һ��request��response����ת���Ķ���Я�����������Ӧ
	}
		catch(Exception e){
		response.sendRedirect("sendForword.jsp");//�ض���sendForward.jspҳ��
	}
}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		   doPost(request,response);       //ֱ�ӵ���doPost����������request��response����
	}         //����doPost()����������һ�������ҵ���߼�


	public void init() throws ServletException {
		
	}

}
