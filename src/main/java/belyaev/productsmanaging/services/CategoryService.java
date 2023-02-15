package belyaev.productsmanaging.services;

import belyaev.productsmanaging.repositories.CategoryRepository;
import belyaev.productsmanaging.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryByName(String name) {
        Category category = categoryRepository.findByCategoryName(name);
        if (category == null) {
            category = new Category(name);
            addCategory(category);
        }
        return category;
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
