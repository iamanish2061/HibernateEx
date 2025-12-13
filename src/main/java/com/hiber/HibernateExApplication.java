package com.hiber;

import com.hiber.model.*;
import com.hiber.repository.BrandRepo;
import com.hiber.repository.CategoryRepo;
import com.hiber.repository.ProductRepo;
import com.hiber.repository.TagRepo;
import com.hiber.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
//    @Bean
//    CommandLineRunner runner(TagRepo repository) {
//        return args -> {
//
//            List<TagModel> tags = new ArrayList<>();
//            tags.add(new TagModel(null,"NewArrival", null));
//            tags.add(new TagModel(null, "Discount", null));
//            tags.add(new TagModel(null, "Popular", null));
//            tags.add(new TagModel(null, "Bestseller", null));
//            tags.add(new TagModel(null, "Featured", null));
//
//            repository.saveAll(tags);
//        };
//    }

    //    inserting products info along with product images by putting fetch type eager in brand category and tag model
//    @Bean
//    CommandLineRunner runner(BrandRepo brandRepo, CategoryRepo categoryRepo, TagRepo tagRepo, ProductRepo productRepo) {
//        return args -> {
//            BrandModel apple = brandRepo.findById(1L).get();
//            BrandModel samsung = brandRepo.findById(2L).get();
//
//            CategoryModel smartPhone = categoryRepo.findById(1L).get();
//            CategoryModel laptop = categoryRepo.findById(2L).get();
//            CategoryModel tablet = categoryRepo.findById(3L).get();
//            CategoryModel accesories = categoryRepo.findById(4L).get();
//
//            TagModel bestseller = tagRepo.findById(1L).get();
//            TagModel discount = tagRepo.findById(2L).get();
//            TagModel featured = tagRepo.findById(3L).get();
//            TagModel newArrival = tagRepo.findById(4L).get();
//            TagModel popular = tagRepo.findById(5L).get();
//
//
//            Set<ImageModel> set1 = Set.of(
//                    new ImageModel(null, "iPhone Front", "/images/iphone16_f", true, null),
//                    new ImageModel(null, "iPhone Back", "/images/iphone16_b", false, null)
//            );
//
//            Set<ImageModel> set2 = Set.of(
//                    new ImageModel(null, "iPad Pro Front", "/images/ipad12_f", true, null),
//                    new ImageModel(null, "iPad Pro Back", "/images/ipad12_b", false, null)
//            );
//
//            Set<ImageModel> set3 = Set.of(
//                    new ImageModel(null, "MacBook Air Top", "/images/macair_top", true, null),
//                    new ImageModel(null, "MacBook Air Side", "/images/macair_side", false, null)
//            );
//
//            Set<ImageModel> set4 = Set.of(
//                    new ImageModel(null, "Galaxy S25 Front", "/images/gs25_f", true, null),
//                    new ImageModel(null, "Galaxy S25 Back", "/images/gs25_b", false, null)
//            );
//
//            Set<ImageModel> set5 = Set.of(
//                    new ImageModel(null, "Galaxy Tab S9 Front", "/front/url", true, null),
//                    new ImageModel(null, "Galaxy Tab S9 Back", "/back/url", false, null)
//            );
//
//            Set<ImageModel> set6 = Set.of(
//                    new ImageModel(null, "Galaxy Book 3 Top", "/top/url", true, null),
//                    new ImageModel(null, "Galaxy Book 3 Side", "/side/url", false, null)
//            );
//
//            Set<ImageModel> set7 = Set.of(
//                    new ImageModel(null, "AirPods Pro Case", "/case/url", true, null),
//                    new ImageModel(null, "AirPods Pro Ear", "/ear/url", false, null)
//            );
//
//            Set<ImageModel> set8 = Set.of(
//                    new ImageModel(null, "Galaxy Buds Case", "/case/url", true, null),
//                    new ImageModel(null, "Galaxy Buds Ear", "/ear/url", false, null)
//            );
//
//            Set<ImageModel> set9 = Set.of(
//                    new ImageModel(null, "Magic Keyboard Top", "/top/url", true, null),
//                    new ImageModel(null, "Magic Keyboard Side", "/side/url", false, null)
//            );
//
//            Set<ImageModel> set10 = Set.of(
//                    new ImageModel(null, "Galaxy Charger Front", "/front/url", true, null),
//                    new ImageModel(null, "Galaxy Charger Back", "/back/url", false, null)
//            );
//
//            ProductModel product1 = new ProductModel();
//            product1.setName("iPhone 16");
//            set1.forEach(image->product1.addImage(image));
//            product1.setTags(Set.of(newArrival, popular));
//            apple.addProduct(product1);
//            smartPhone.addProduct(product1);
//
//
//            ProductModel product2 = new ProductModel();
//            product2.setName("iPod Pro 12");
//            set2.forEach(image->product2.addImage(image));
//            product2.setTags(Set.of(featured));
//            apple.addProduct(product2);
//            tablet.addProduct(product2);
//
//            ProductModel product3 = new ProductModel();
//            product3.setName("MacBook Air M3");
//            set3.forEach(image->product3.addImage(image));
//            product3.setTags(Set.of(bestseller, popular));
//            apple.addProduct(product3);
//            laptop.addProduct(product3);
//
//            ProductModel product4 = new ProductModel();
//            product4.setName("Galaxy S25");
//            set4.forEach(image->product4.addImage(image));
//            product4.setTags(Set.of(newArrival));
//            samsung.addProduct(product4);
//            smartPhone.addProduct(product4);
//
//            ProductModel product5 = new ProductModel();
//            product5.setName("Galaxy Tab S9");
//            set5.forEach(image->product5.addImage(image));
//            product5.setTags(Set.of(popular));
//            samsung.addProduct(product5);
//            tablet.addProduct(product5);
//
//            ProductModel product6 = new ProductModel();
//            product6.setName("Galaxy Book 3");
//            set6.forEach(image->product6.addImage(image));
//            product6.setTags(Set.of(discount));
//            samsung.addProduct(product6);
//            laptop.addProduct(product6);
//
//            ProductModel product7 = new ProductModel();
//            product7.setName("AirPods Pro");
//            set7.forEach(image->product7.addImage(image));
//            product7.setTags(Set.of(bestseller));
//            apple.addProduct(product7);
//            accesories.addProduct(product7);
//
//            ProductModel product8 = new ProductModel();
//            product8.setName("Galaxy Buds Pro");
//            set8.forEach(image->product8.addImage(image));
//            product8.setTags(Set.of(featured));
//            samsung.addProduct(product8);
//            accesories.addProduct(product8);
//
//            ProductModel product9 = new ProductModel();
//            product9.setName("Magic Keyboard");
//            set9.forEach(image->product9.addImage(image));
//            product9.setTags(Set.of(popular));
//            apple.addProduct(product9);
//            accesories.addProduct(product9);
//
//            ProductModel product10 = new ProductModel();
//            product10.setName("Galaxy Charger");
//            set10.forEach(image->product10.addImage(image));
//            product10.setTags(Set.of(discount, newArrival));
//            samsung.addProduct(product10);
//            accesories.addProduct(product10);
//
//            List<ProductModel> products = List.of(
//                    product1,
//                    product2,
//                    product3,
//                    product4,
//                    product5,
//                    product6,
//                    product7,
//                    product8,
//                    product9,
//                    product10
//            );
//
//            productRepo.saveAll(products);
//
//        };

//    }



//    fetching brands to check lazy is working or not
//    @Bean
//    CommandLineRunner runner(BrandRepo brandRepo){
//        return args -> {
//            BrandModel brand = brandRepo.findById(1L).get();
//            System.out.println(brand);
//        };
//
//        return args -> {
//            List<BrandModel> brands = brandRepo.findAll();
//            brands.forEach(b-> System.out.println(b));
//        };
//
//    }

    @Bean
    CommandLineRunner cr(ProductRepo productRepo){
        return args -> {
          ProductModel product = productRepo.findById(2L).orElseThrow(()-> new RuntimeException("error"));
          System.out.println(product);
        };
    }


    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args ->
        {
            Pageable pageable = PageRequest.of(0, 5, Sort.by("id").descending());

            Page<ProductModel> products = productService.getPaginatedProductsWithInitializedImages(pageable);

            products.getContent().forEach(
                    p -> {
                        System.out.println(p.getName());
                        System.out.println(p.getId());
                        p.getImages().stream()
                                .filter(image -> image.isThumbnail())
                                .forEach(fi -> System.out.println("Alt: " + fi.getAlt()));
                        System.out.println("------------------------------------------------------------");
                    }
            );
        };
    }





}
