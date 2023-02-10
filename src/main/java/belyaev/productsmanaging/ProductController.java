package belyaev.productsmanaging;

import belyaev.productsmanaging.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("product", new Product());
        return "index";
    }

    @PostMapping("/add_product")
    public String addProduct(Product product, Model model) {
        productService.addProduct(product);
        return "redirect:/";
    }
}
