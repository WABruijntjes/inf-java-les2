package nl.inholland.infjavales2.controller;

import nl.inholland.infjavales2.model.Product;
import nl.inholland.infjavales2.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService pService;

    public ProductController(ProductService pService) {
        this.pService = pService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return pService.getAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return pService.addProduct(product);
    }

}
