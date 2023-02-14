package belyaev.productsmanaging.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    private String categoryName;

    @OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
    private List<Product> products;

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.setProducts(new ArrayList<>());
    }
}
