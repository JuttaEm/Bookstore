package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CategoryRepository categoryRepository, BookRepository bookRepository) {
	return (args) -> {
		
		log.info("save demo categories");
		
		Category category1 = new Category("Children");
		Category category2 = new Category("Horror");
		Category category3 = new Category("IT");
		
		categoryRepository.save(category1);
		categoryRepository.save(category2);
		categoryRepository.save(category3);
		
		log.info("save demo data of books with category");
		
		bookRepository.save(new Book("Rise of the Robots", "Martin Ford", "2016", "9780465097531", 16.90, category3));
		bookRepository.save(new Book("Veljeni Leijonamieli", "Astrid Lindgren", "1973", "9789510432761", 21.95, category1));
		bookRepository.save(new Book("Carrie", "Stephen King", "2011", "9781444720693", 11.50, category2));	
		
		
		log.info("fetch all books");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}
		
	};
	}

}
