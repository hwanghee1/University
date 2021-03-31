package AdminTask;

import java.util.Date;

public class User_book extends Book {

	private String author;
	private String picture;
	private String company;
	private boolean rent_status;
	private int rent_freq;
	private String genre;
	private String major;

	public User_book(int id, String name, String author, String picture, String company, boolean rent_status,
			int rent_freq, String major, String genre) {
		super(id, name);
		this.author = author;
		this.company = company;
		this.picture = picture;
		this.rent_status = rent_status;
		this.rent_freq = rent_freq;
		this.genre = genre;
		this.major = major;

	}

	public String getAuthor() {
		return this.author;
	}

	public String getPicture() {
		return this.picture;
	}

	public String getCompany() {
		return this.company;
	}

	public boolean getRentStatus() {
		return this.rent_status;
	}

	public int getRentFreq() {
		return this.rent_freq;
	}

	public void increaseRentFreq() {
		this.rent_freq++;
	}

	public void setStatus() {
		if (rent_status == false)
			this.rent_status = true;
		else
			this.rent_status = false;
	}
	public String getGenre() {
		return this.genre;
	}

	public String getMajor() {
		return this.major;
	}
}
