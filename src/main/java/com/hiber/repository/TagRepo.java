package com.hiber.repository;

import com.hiber.model.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends JpaRepository<TagModel, Long> {
}
