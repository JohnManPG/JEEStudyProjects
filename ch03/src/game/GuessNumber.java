package game;
//���JavaBean��ֻ������������Ҫ��紫ֵ��һ����������ɵĴ𰸣�һ������������Ĵ𰸣�������Ҫ���Ӧ��set����
public class GuessNumber {         //����һ��JavaBean,��װ��һ���ش���𰸵Ķ��󣬻�����һЩҵ���߼�
   //ϵͳ������ɵ�һ����
	int answer=0;
	//�û��µ���                                 
	int guessNumber=0;
	//�û��µĴ���
	int guessCount=0;
	String result=null;
	boolean right=false;       //ʹ��JavaBean����ҵ���߼�����Ҳ��JavaBean��һ�ֹ��ܷ���
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
		guessCount=0;
	}
	public int getGuessNumber() {
		return guessNumber;
	}
	public void setGuessNumber(int guessNumber) {
		this.guessNumber = guessNumber;
		guessCount++;
		if(guessNumber==answer){              //��Ϥ����if-elseѭ��
			result="��ϲ�������";
			right=true;
		}else if(guessNumber>answer){
			result="������˼�����´���";
			right=false;
		}else if(guessNumber<answer){
			result="������˼������С��";
			right=false;
		}else if(this.answer==-1||this.answer>100){
			result="������1~100������";
			right=false;
		}
	}
	public int getGuessCount() {         //�Ѿ�������ڲ����б����ĸ�ֵ�����ԾͲ���Ҫ���Ӧ�ı�����set����
		return guessCount;
	}
	public String getResult() {
		return result;
	}
	public boolean isRight() {
		return right;
	}  	
}
