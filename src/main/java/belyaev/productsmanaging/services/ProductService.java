package belyaev.productsmanaging.services;

import belyaev.productsmanaging.repositories.ProductRepository;
import belyaev.productsmanaging.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public void changeProductName(String name, int id) {
        productRepository.setProductNameById(name, id);
    }
}
