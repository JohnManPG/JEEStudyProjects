package iocexample1;

public class Chinese implements Person {	
	/**  ����ע��
    private Language language;    //�����������ԣ�ֻҪû��new���Ͳ��ᴴ��һ������ռ���ڴ棬��ֻ��һ�����Զ���
	@Override
	public void speak() {
		System.out.println(language.kind());
		
	}    //����ע��
    public void setLanguage(Language language){  //ע�뷽��
    	this.language=language;     //�����������language�϶���һ������ͨ��set()����ע��������JavaBean�е����Ը�ֵ��ԭ����һ���ģ�ֵ���������ط���õģ�����Ҳ���������ط���õ�
    }
    **/
	
	
	//����ע��
	private Language language;
	public Chinese(){
		
	}
	public Chinese(Language language){
		this.language=language;  
	}
	@Override
	public void speak() {
		System.out.println(language.kind());
		
	}
	
}
