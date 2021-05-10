package nl.inholland.infjavales2.service;

import nl.inholland.infjavales2.model.Product;
import nl.inholland.infjavales2.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){ return productRepository.findAll(); }

    public Product addProduct(Product p){ return productRepository.save(p); }
}
