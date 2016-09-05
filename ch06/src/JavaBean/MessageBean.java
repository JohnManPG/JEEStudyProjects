package JavaBean;

public class MessageBean {     //这个JavaBean封装了一篇文章的对象，一篇文章就是JavaBean的一个实例对象
	private String author;
	private String title;
	private String content;
	private String time;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
      
}
