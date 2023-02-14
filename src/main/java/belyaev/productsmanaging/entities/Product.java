package belyaev.productsmanaging.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int productId;

   private String productName;

   @ManyToOne(optional = false)
   @JoinColumn(name = "product_category_id", nullable = false)
   @JsonIgnore
   private Category categoryOfProducts;

}
