package hh.swd20.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
		/*
		@GetMapping("/booklist")
		public String getAllBooks(Model model) {			
			model.addAttribute("books", bookRepository.findAll());			
			return "booklist";
		}*/
		
		//RESTful service to get all books
		@RequestMapping(value="/books", method = RequestMethod.GET)
		public @ResponseBody List<Book> getBooksRest() {
			return (List<Book>) bookRepository.findAll();
		}
		
		//RESTful service to get one book by id
		@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {
			return bookRepository.findById(id);
		}
		
		
		@GetMapping("/add")
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			model.addAttribute("categories", categoryRepository.findAll());
			return "addbook";
		}
		
		@PostMapping("/save")
		public String save(Book book) {
			bookRepository.save(book);
			return "redirect:booklist";
		}
		
		@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long bookId, Model model) {
			bookRepository.deleteById(bookId);
			return "redirect:../booklist";
		}
		
		@RequestMapping(value="/edit/{id}")
		public String editBook(@PathVariable("id") Long bookId, Model model) {
			model.addAttribute("book", bookRepository.findById(bookId));
			return "editbook";
		}
		
		
}
