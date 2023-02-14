package belyaev.productsmanaging;

import belyaev.productsmanaging.entities.Category;
import belyaev.productsmanaging.entities.Product;
import belyaev.productsmanaging.services.CategoryService;
import belyaev.productsmanaging.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;


    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "index";
    }

    @PostMapping("/add_product")
    public String addProduct(Product product, Model model) {
        Category category = categoryService.getCategoryByName("No Category");
        System.out.println("123");
        product.setCategoryOfProducts(category);
        productService.addProduct(product);
        return "redirect:/";
    }
}
