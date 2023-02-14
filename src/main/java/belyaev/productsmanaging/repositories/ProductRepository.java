package belyaev.productsmanaging.repositories;

import belyaev.productsmanaging.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
