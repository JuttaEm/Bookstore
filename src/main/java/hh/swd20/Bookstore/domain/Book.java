package hh.swd20.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Add a new model class called Book which contains attributes: title, author, year, isbn, price


@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String author;
	private String year;
	private String isbn;
	private double price;
	
	@ManyToOne
	@JsonIgnoreProperties ("books")
	@JoinColumn(name = "catId")
	private Category category;
	
	public Book(String title, String author, String year, String isbn, double price, Category category) {
		super();
		this.id = 0;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	public Book() {
		super();
		this.id = 0;
		this.title = null;
		this.author = null;
		this.year = null;
		this.isbn = null;
		this.price = 0;
	}

		
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getYear() {
		return year;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrice() {
		return price;
	}
	
	public Category getCategory() {
		return category;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

		@Override
		public String toString() {
			if (this.category != null)
				return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
					+ ", price=" + price + ", category=" + category + "]";
			else				
				return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
							+ "]";
				
		}


	
	
	
	
	

}
