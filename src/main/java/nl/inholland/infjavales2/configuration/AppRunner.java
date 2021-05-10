package nl.inholland.infjavales2.configuration;

import nl.inholland.infjavales2.model.Category;
import nl.inholland.infjavales2.model.Product;
import nl.inholland.infjavales2.service.CategoryService;
import nl.inholland.infjavales2.service.ProductService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner { //Class om test data in te voeren

    private CategoryService categoryService;
    private ProductService productService;

    public AppRunner(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Category testCategory = new Category("TestCategory");
        categoryService.addCategory(testCategory);

        Product testProduct = new Product("TestBook","Een boek product om app te testen",69.69);
        testProduct.setCategory(testCategory);

        productService.addProduct(testProduct);
    }
}
