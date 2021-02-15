package react;

public class TestObject {
	private int id;
	private boolean completed;
	private String title;
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public TestObject(){
		
	}
	public TestObject(int id, boolean completed, String title, int userId) {
		super();
		this.id = id;
		this.completed = completed;
		this.title = title;
		this.userId = userId;
	}
}
