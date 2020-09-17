package hh.swd20.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.Bookstore.domain.Book;


public class BookController {
	
	@GetMapping("/index")
	public String listBooks(Model model) {
			
		List<Book> books = new ArrayList<>();
		books.add(new Book()); 
		books.add(new Book());
		books.add(new Book());
		
		model.addAttribute("books", books); 
		
		return "booklist";
	}
}
