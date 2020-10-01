package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
		@GetMapping("/categorylist")
		public String getAllCategories(Model model) {
			model.addAttribute("categories", categoryRepository.findAll());
			return "categorylist";
		}
		
		@GetMapping("/addC")
		public String addCategory(Model model) {
			model.addAttribute("category", new Category());
			return "addcategory";
		}
		
		@PostMapping("/saveC")
		public String save(Category category) {
			categoryRepository.save(category);
			return "redirect:categorylist";
		}

}
