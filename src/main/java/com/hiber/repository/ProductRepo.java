package com.hiber.repository;

import com.hiber.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel, Long> {

    @EntityGraph(value = "productsWithBrand", type = EntityGraph.EntityGraphType.FETCH)
    List<ProductModel> findByBrandId(Long brandId);

    @EntityGraph(value = "productDetails", type = EntityGraph.EntityGraphType.FETCH)
    Optional<ProductModel> findById(Long id);

    @EntityGraph(value = "productWithImages", type = EntityGraph.EntityGraphType.FETCH)
    Page<ProductModel> findAllWithImage(Pageable pageable);

}
