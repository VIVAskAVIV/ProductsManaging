package belyaev.productsmanaging.repositories;

import belyaev.productsmanaging.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("UPDATE Product p SET p.productName = ?1 WHERE p.productId = ?2")
    void setProductNameById(String name, int id);
}
