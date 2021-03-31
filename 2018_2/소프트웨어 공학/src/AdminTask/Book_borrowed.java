package AdminTask;

import java.util.*;

public class Book_borrowed extends Book{
	String user_id;
	String user_name;
	private Date rent_date;
	private Date due_date;
	
	public Book_borrowed(String user_id, String user_name,int book_id, String book_name,Date rent_date,Date due_date) {
		super(book_id, book_name);
		this.user_id = user_id;
		this.user_name = user_name;
		this.rent_date = rent_date;
		this.due_date = due_date;
	}
	public String getUserID() {
		return this.user_id;
	}
	public String getUserName() {
		return this.user_name;
	}
	public Date getRentDate() {
		return this.rent_date;
	}
	public Date getDueDate() {
		return this.due_date;
	}
}
