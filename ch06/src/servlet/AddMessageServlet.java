package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JavaBean.MessageBean;
//���servlet���ܣ�1.��ȡ�ͻ��˵�����  2.ΪJavaBean�е����Ը�ֵ  

public class AddMessageServlet extends HttpServlet {

	
	public AddMessageServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		       doPost(request,response);
	}

	//������ʲô��һ�������Ӧһ��ʵ�����϶����������Լ����Ե�ֵ������һ������ɴ��С�������Ǽ�򵥵���һ�����ݼ�¼��Ҳ������һƪ���£�һƪ���¾���һ������һ��ʵ����һ��JavaBeanʵ��
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String author=new String(request.getParameter("author").getBytes("ISO-8859-1"),"UTF-8");
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
        String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
	    //��ȡ��ǰʱ�䲢��ʽ��ʱ��Ϊָ����ʽ
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�ø�����ģʽ��Ĭ�����Ի��������ڸ�ʽ���Ź��� SimpleDateFormat��
        String today=format.format(new Date());    //��������Ƕ���Ļ���Ҳ�ǿ���ֱ��new�ģ����ص���StringBuffer����ʵ֤���ǿ�����String�����䷵��ֵ
        MessageBean mm=new MessageBean();    //new Date()�ͳ���һ����ǰ����
        mm.setAuthor(author);
        mm.setContent(content);
        mm.setTitle(title);
        mm.setTime(today);
        //��ȡsession����
        HttpSession session=request.getSession(); //ͨ��request��ȡsession���󣬷����뵱ǰ����������ĻỰ�����û�У�����һ�η��ʣ����Զ�����һ��session����
        //ͨ��session��ȡ����Ӧ��������
        ServletContext scx = session.getServletContext();   //ServletContext�൱��JSP�е�application����
        //��ȡ�洢��Ӧ���������еļ��϶���   ������ ��getServletContext()���application������������servlet�л�����JSP��
        ArrayList wordlist = (ArrayList) scx.getAttribute("wordlist");   //���ص���һ��Object������Ҫ����ǿ������ת��
        if(wordlist==null)                       //�յĻ�����Ҫ��������һ��ʵ��
        wordlist =new ArrayList();
        //����װ����Ϣ��ֵJavaBean�洢�����϶�����
        wordlist.add(mm);
        //�����϶��󱣴浽Ӧ����������
        scx.setAttribute("wordlist", wordlist);
        response.sendRedirect("showMessage.jsp"); //ʹ���ض���ķ���������servlet
	}

	
	public void init() throws ServletException {
		
	}
}
