package com.hiber;

import com.hiber.model.BrandModel;
import com.hiber.repository.BrandRepo;
import com.hiber.repository.ProductRepo;
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

    @Bean
    CommandLineRunner runner(BrandRepo repository) {
        return args -> {

            List<BrandModel> brandList = new ArrayList<>();
            brandList.add(new BrandModel(null,"Apple", null));
            brandList.add(new BrandModel(null, "Samsung", null));

            repository.saveAll(brandList);
        };
    }

}
