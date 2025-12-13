package com.hiber.service;

import com.hiber.model.ProductModel;
import com.hiber.repository.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Transactional
    public Page<ProductModel> getPaginatedProductsWithInitializedImages(Pageable pageable) {

        Page<ProductModel> products = productRepo.findAllWithImage(pageable);
        products.getContent().forEach(p -> p.getImages().size());

        return products;
    }

}
