package nl.inholland.infjavales2.controller;

import nl.inholland.infjavales2.model.Product;
import nl.inholland.infjavales2.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mysteryProducts")
public class MysteryProductsController {

    private ProductService pService;

    public MysteryProductsController(ProductService pService) {this.pService = pService; }

    @GetMapping
    public List<Product> getAllMysteryProducts() {
        return pService.getMysteryProducts();
    }
}
