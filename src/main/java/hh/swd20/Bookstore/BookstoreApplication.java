package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
	return (args) -> {
		
		log.info("save demo data of books");
		
		Book book1 = new Book("Rise of the Robots", "Martin Ford", "2016", "9780465097531", 16.90);
		Book book2 = new Book("Veljeni Leijonamieli", "Astrid Lindgren", "1973", "9789510432761", 21.95);
		Book book3 = new Book("Carrie", "Stephen King", "2011", "9781444720693", 11.50);
		
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);	
		
		log.info("fetch all books");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}
		
	};
	}

}
