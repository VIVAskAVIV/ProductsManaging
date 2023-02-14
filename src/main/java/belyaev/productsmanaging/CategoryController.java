package belyaev.productsmanaging;

import belyaev.productsmanaging.entities.Category;
import belyaev.productsmanaging.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add_category")
    public String addCategory(Category category, Model model) {
        categoryService.addCategory(category);
        return "redirect:/";
    }
}
