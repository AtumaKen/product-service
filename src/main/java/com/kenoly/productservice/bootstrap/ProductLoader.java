package com.kenoly.productservice.bootstrap;

import com.kenoly.productservice.domain.Product;
import com.kenoly.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements CommandLineRunner {
    private final ProductRepository productRepository;

    public ProductLoader(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        loadProductObjects();
    }

    private void loadProductObjects() {
        if(productRepository.count() == 0){
            productRepository.save(Product.builder()
                    .productName("Subaru")
                    .productStyle("Sedan")
                    .minOnHand(5)
                    .quantityToMake(20)
                    .price(new BigDecimal("20.00"))
                    .build());

            productRepository.save(Product.builder()
                    .productName("Mazda")
                    .productStyle("Coup")
                    .minOnHand(3)
                    .quantityToMake(20)
                    .price(new BigDecimal("25.00"))
                    .build());
        }
    }
}
