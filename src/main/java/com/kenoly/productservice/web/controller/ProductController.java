package com.kenoly.productservice.web.controller;

import com.kenoly.productservice.web.model.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/product")
@RestController
public class ProductController {

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") UUID productId){
        //todo impl
        return new ResponseEntity<>(ProductDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity saveNewProduct(@RequestBody ProductDto productDto){
    //todo impl
    return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity updateProductById(@PathVariable("productId") UUID productId, @RequestBody ProductDto productDto){
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
