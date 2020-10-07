package hh.swd20.Bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long catId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnoreProperties("category")
	private List<Book> books;
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category() {
		this.catId = 0;
		this.name = null;
	}

	public long getCatId() {
		return catId;
	}


	public String getName() {
		return name;
	}
	
	public List<Book> getBooks() {
		return books;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [id=" + catId + ", name=" + name + "]";
	}
	
	
	
	

}
