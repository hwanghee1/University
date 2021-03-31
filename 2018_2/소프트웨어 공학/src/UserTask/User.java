package UserTask;

public class User {
	private String ID,passwd,name;
	private int studentNum,grades;
	private String major,phoneNum,preferGenre;
	private int rent_count,is_login;
	
	public User(String ID,String passwd, String name, int studentNum,int grades, String major, String phoneNum, String preferGenre, int rent_count, int is_login){
		this.ID = ID; this.passwd = passwd; this.name = name;
		this.studentNum = studentNum; this.grades = grades;
		this.major = major; this.phoneNum = phoneNum;
		this.preferGenre = preferGenre;
		this.rent_count = rent_count; this.is_login = is_login;
	}
	public User() {
		ID = null;passwd = null; name = null;
		studentNum = 0; grades = 0;
		major = null; phoneNum = null; preferGenre = null;
		rent_count = 0; is_login = 0;
	}
	public String getID() {
		return this.ID;
	}
	public String getPasswd() {
		return this.passwd;
	}
	public String getName() {
		return this.name;
	}
	public int getstudentNum() {
		return this.studentNum;
	}
	public int getGrades() {
		return this.grades;
	}
	public String getMajor() {
		return this.major;
	}
	public String getPhoneNum() {
		return this.phoneNum;
	}
	public String getPreferGenre() {
		return this.preferGenre;
	}
	public int getRentCount() {
		return this.rent_count;
	}
	public void setRentCount(int rent_count) {
		this.rent_count = rent_count;
	}
	public int getIsLogin() {
		return this.is_login;
	}
	public void updatePW(String newPW) {
		this.passwd = newPW;
	}
	public void setLogIn() {
		this.is_login = 1;
	}
	public void setLogOut() {
		this.is_login = 0;
	}
}
