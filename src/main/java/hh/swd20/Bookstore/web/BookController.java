package hh.swd20.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.Bookstore.domain.Book;


@Controller
public class BookController {
	
	@GetMapping("/index")
	public String sayWelcome() {
			
		return "index";
	}
}
