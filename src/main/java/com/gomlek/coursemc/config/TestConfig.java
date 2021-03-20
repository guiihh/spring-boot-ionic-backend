package com.gomlek.coursemc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gomlek.coursemc.entities.Category;
import com.gomlek.coursemc.entities.City;
import com.gomlek.coursemc.entities.Product;
import com.gomlek.coursemc.entities.State;
import com.gomlek.coursemc.repositories.CategoryRepository;
import com.gomlek.coursemc.repositories.CityRepository;
import com.gomlek.coursemc.repositories.ProductRepository;
import com.gomlek.coursemc.repositories.StateRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

//	@Autowired
//	private UserRepository userRepository;
////
	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", 90.5);
		Product p2 = new Product(null, "Smart TV", 2190.0);
		Product p3 = new Product(null, "Macbook Pro", 1250.0);
		Product p4 = new Product(null, "PC Gamer", 1200.0);
		Product p5 = new Product(null, "Rails for Dummies", 100.99);

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat3);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		State est1 = new State(null, "Paraná");
		State est2 = new State(null, "Santa catarina");
		

		City u1 = new City(null, "Cascavel", est1);
		City u2 = new City(null, "São miguel do oeste", est2);
		City u3 = new City(null, "Realeza", est2);

		est1.getCitys().addAll(Arrays.asList(u1));
		est2.getCitys().addAll(Arrays.asList(u2, u3));
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(u1, u2, u3));

	}
}

//
//		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
//
//		
//
//		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
//		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
//		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);
//
//		userRepository.saveAll(Arrays.asList(u1, u2));
//		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
//
//		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
//		OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
//		OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
//		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
//
//		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
//
//		Payment pay1 = new Payment(null, Instant.parse("2019-07-22T21:21:22Z"), o1);
//		Payment pay2 = new Payment(null, Instant.parse("2021-02-25T22:40:00Z"), o2);
//		Payment pay3 = new Payment(null, Instant.parse("2020-08-16T09:30:00Z"), o3);
//
//		o1.setPayment(pay1);
//		o2.setPayment(pay2);
//		o3.setPayment(pay3);
//		orderRepository.save(o1);
//		orderRepository.save(o2);
//		orderRepository.save(o3);
//	



