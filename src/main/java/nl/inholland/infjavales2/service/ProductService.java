package nl.inholland.infjavales2.service;

import nl.inholland.infjavales2.model.Category;
import nl.inholland.infjavales2.model.Product;
import nl.inholland.infjavales2.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){ return productRepository.findAll(); }

    public Product addProduct(Product p){ return productRepository.save(p); }



    public List<Product> getMysteryProducts(){
        List<Product> products = productRepository.findAll();

        Stream<Product> productStream = products.stream();

        List<Product> mysteryProducts = productStream.filter(p -> p.getCategory().getName().equals("Mystery")).collect(Collectors.toList()); //LAMBDA

        return mysteryProducts;
    }
}
