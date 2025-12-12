package com.hiber;

import com.hiber.model.BrandModel;
import com.hiber.model.CategoryModel;
import com.hiber.model.TagModel;
import com.hiber.repository.BrandRepo;
import com.hiber.repository.CategoryRepo;
import com.hiber.repository.ProductRepo;
import com.hiber.repository.TagRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HibernateExApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateExApplication.class, args);
	}

//    inserting brand info
//    @Bean
//    CommandLineRunner runner(BrandRepo repository) {
//        return args -> {
//
//            List<BrandModel> brandList = new ArrayList<>();
//            brandList.add(new BrandModel(null,"Apple", null));
//            brandList.add(new BrandModel(null, "Samsung", null));
//
//            repository.saveAll(brandList);
//        };
//    }

//    inserting category info
//    @Bean
//    CommandLineRunner runner(CategoryRepo repository) {
//        return args -> {
//
//            List<CategoryModel> categoryList = new ArrayList<>();
//            categoryList.add(new CategoryModel(null,"Smartphone", null));
//            categoryList.add(new CategoryModel(null, "Laptop", null));
//            categoryList.add(new CategoryModel(null, "Tablet", null));
//            categoryList.add(new CategoryModel(null, "Accessories", null));
//
//            repository.saveAll(categoryList);
//        };
//    }

//    inserting tags info
    @Bean
    CommandLineRunner runner(TagRepo repository) {
        return args -> {

            List<TagModel> tags = new ArrayList<>();
            tags.add(new TagModel(null,"NewArrival", null));
            tags.add(new TagModel(null, "Discount", null));
            tags.add(new TagModel(null, "Popular", null));
            tags.add(new TagModel(null, "Bestseller", null));
            tags.add(new TagModel(null, "Featured", null));

            repository.saveAll(tags);
        };
    }



}
