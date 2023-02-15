package belyaev.productsmanaging.controllers;

import belyaev.productsmanaging.entities.Category;
import belyaev.productsmanaging.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/delete_category")
    public String deleteProduct(@RequestParam(name = "category_id") int categoryId, Model model) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/";
    }

}
