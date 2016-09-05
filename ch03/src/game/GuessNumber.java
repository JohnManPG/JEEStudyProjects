package game;
//这个JavaBean里只有两个属性需要外界传值，一个是随机生成的答案，一个是玩者输入的答案，所以需要相对应的set方法
public class GuessNumber {         //这是一个JavaBean,封装了一个回答与答案的对象，还处理一些业务逻辑
   //系统随机生成的一个数
	int answer=0;
	//用户猜的数                                 
	int guessNumber=0;
	//用户猜的次数
	int guessCount=0;
	String result=null;
	boolean right=false;       //使用JavaBean处理业务逻辑，这也是JavaBean的一种功能方法
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
		if(guessNumber==answer){              //熟悉这种if-else循环
			result="恭喜您答对了";
			right=true;
		}else if(guessNumber>answer){
			result="不好意思，您猜大了";
			right=false;
		}else if(guessNumber<answer){
			result="不好意思，您猜小了";
			right=false;
		}else if(this.answer==-1||this.answer>100){
			result="请输入1~100的整数";
			right=false;
		}
	}
	public int getGuessCount() {         //已经在类的内部进行变量的赋值，所以就不需要相对应的变量的set方法
		return guessCount;
	}
	public String getResult() {
		return result;
	}
	public boolean isRight() {
		return right;
	}  	
}
