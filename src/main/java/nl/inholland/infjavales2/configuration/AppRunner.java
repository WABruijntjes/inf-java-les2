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

        Category mysteryCategory = new Category("Mystery");
        categoryService.addCategory(mysteryCategory);
        Category romanceCategory = new Category("Romance");
        categoryService.addCategory(romanceCategory);

        Product loveProduct = new Product("Love Story","Romantic book about love",69.69, romanceCategory);
        Product loveProduct2 = new Product("Love Story 2","Romantic book about love part 2. Te sequel",50.00, romanceCategory);

        Product mysteryProduct = new Product("Mystery Story","Mysterious book about mystery",40.76, mysteryCategory);
        Product mysteryProduct2 = new Product("Mystery Story 2","Mysterious book about mystery and other mysteries. The reboot",50.00, mysteryCategory);

        productService.addProduct(loveProduct);
        productService.addProduct(loveProduct2);
        productService.addProduct(mysteryProduct);
        productService.addProduct(mysteryProduct2);
    }
}
