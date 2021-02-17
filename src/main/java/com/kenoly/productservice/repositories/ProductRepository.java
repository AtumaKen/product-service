package com.kenoly.productservice.repositories;

import com.kenoly.productservice.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ProductRepository extends PagingAndSortingRepository<Product, UUID > {
}
