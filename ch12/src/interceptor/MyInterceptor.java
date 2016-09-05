package interceptor;   //写一个自定义的拦截器

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
                                    //继承一个抽象的拦截器，并实现拦截器必须实现的方法，intercept,可以避免实现不必要实现的方法，除这个方法，还有init()方法和destroy()方法
public class MyInterceptor extends AbstractInterceptor {     //自定义拦截器必须继承 AbstractInterceptor，当然也可以实现其Interceptor接口，一般继承AbstractInterceptor接口

	@Override               //invocation是调用的意思
	public String intercept(ActionInvocation ai) throws Exception {
		// 获取action的实例
		Object object = ai.getAction();//通过父类的引用指向子类的对象
		if(object != null){
			if(object instanceof PublicAction){
				PublicAction ac=(PublicAction)object;
				//获取用户提交的评论内容
				String content=ac.getContent();
				//判断用户提交的评论内容是否有要过滤的内容
				if(content.contains("讨厌")){  //当且仅当此字符串包含指定的 char 值序列时，返回 true。
					//以“喜欢”代替要过滤的“讨厌”
					content=content.replaceAll("讨厌", "喜欢");
					//把替代后的评论内容设置为Action的评论内容
					ac.setContent(content);
				}
				//对象不空，继续执行
				return ai.invoke();//如果还有拦截器，调用下一个拦截器，如果没有的话，执行Action
			}else{
				//返回Action中的LOGIN逻辑视图字符串
				return Action.LOGIN;
			}
		}
		return Action.LOGIN;
	}

}
