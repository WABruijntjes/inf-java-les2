package nl.inholland.infjavales2.service;

import nl.inholland.infjavales2.model.Category;
import nl.inholland.infjavales2.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category addCategory(Category c){
        return categoryRepository.save(c);
    }
}
