package interceptor;   //дһ���Զ����������

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
                                    //�̳�һ�����������������ʵ������������ʵ�ֵķ�����intercept,���Ա���ʵ�ֲ���Ҫʵ�ֵķ��������������������init()������destroy()����
public class MyInterceptor extends AbstractInterceptor {     //�Զ�������������̳� AbstractInterceptor����ȻҲ����ʵ����Interceptor�ӿڣ�һ��̳�AbstractInterceptor�ӿ�

	@Override               //invocation�ǵ��õ���˼
	public String intercept(ActionInvocation ai) throws Exception {
		// ��ȡaction��ʵ��
		Object object = ai.getAction();//ͨ�����������ָ������Ķ���
		if(object != null){
			if(object instanceof PublicAction){
				PublicAction ac=(PublicAction)object;
				//��ȡ�û��ύ����������
				String content=ac.getContent();
				//�ж��û��ύ�����������Ƿ���Ҫ���˵�����
				if(content.contains("����")){  //���ҽ������ַ�������ָ���� char ֵ����ʱ������ true��
					//�ԡ�ϲ��������Ҫ���˵ġ����ᡱ
					content=content.replaceAll("����", "ϲ��");
					//��������������������ΪAction����������
					ac.setContent(content);
				}
				//���󲻿գ�����ִ��
				return ai.invoke();//���������������������һ�������������û�еĻ���ִ��Action
			}else{
				//����Action�е�LOGIN�߼���ͼ�ַ���
				return Action.LOGIN;
			}
		}
		return Action.LOGIN;
	}

}
