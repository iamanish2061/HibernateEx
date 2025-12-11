package com.hiber.repository;

import com.hiber.model.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<BrandModel, Long> {
}
