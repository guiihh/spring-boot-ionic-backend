package com.gomlek.coursemc.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gomlek.coursemc.entities.Address;
import com.gomlek.coursemc.entities.CardPayment;
import com.gomlek.coursemc.entities.Category;
import com.gomlek.coursemc.entities.City;
import com.gomlek.coursemc.entities.Client;
import com.gomlek.coursemc.entities.Order;
import com.gomlek.coursemc.entities.OrderedItem;
import com.gomlek.coursemc.entities.Payment;
import com.gomlek.coursemc.entities.PaymentWithBoleto;
import com.gomlek.coursemc.entities.Product;
import com.gomlek.coursemc.entities.State;
import com.gomlek.coursemc.entities.enums.ClientType;
import com.gomlek.coursemc.entities.enums.PaymentStatus;
import com.gomlek.coursemc.repositories.AddressRepository;
import com.gomlek.coursemc.repositories.CategoryRepository;
import com.gomlek.coursemc.repositories.CityRepository;
import com.gomlek.coursemc.repositories.ClientRepository;
import com.gomlek.coursemc.repositories.OrderRepository;
import com.gomlek.coursemc.repositories.OrderedItemRepository;
import com.gomlek.coursemc.repositories.PaymentRepository;
import com.gomlek.coursemc.repositories.ProductRepository;
import com.gomlek.coursemc.repositories.StateRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderedItemRepository orderedItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		Category cat4 = new Category(null, "Ramdom");
		Category cat5 = new Category(null, "CamaMesaBanho");
		Category cat6 = new Category(null, "Perfumaria");
		Category cat7 = new Category(null, "Relogios");
		Category cat8 = new Category(null, "Consoles");


		Product p1 = new Product(null, "The Lord of the Rings", 90.5);
		Product p2 = new Product(null, "Smart TV", 2190.0);
		Product p3 = new Product(null, "Macbook Pro", 1250.0);
		Product p4 = new Product(null, "PC Gamer", 1200.0);
		Product p5 = new Product(null, "Rails for Dummies", 100.99);
		Product p6 = new Product(null, "Iphone", 10000.00);
		Product p7 = new Product(null, "Samsung", 8000.00);
		Product p8 = new Product(null, "Xaiomi", 2000.00);
		Product p9 = new Product(null, "Tv 79' Smart", 5000.00);
		Product p10 = new Product(null, "Chapinha ", 180.00);
		Product p11 = new Product(null, "Mouse", 200.00);
		Product p12 = new Product(null, "Travasseiro", 80.00);
		Product p13 = new Product(null, "PacHabani", 200.00);
		Product p14 = new Product(null, "Relogio de parede", 100.00);
		Product p15 = new Product(null, "PS5", 4500.00);
		Product p16 = new Product(null, "Xbox X", 3200.00);

		cat1.getProducts().addAll(Arrays.asList(p2, p3,p4,p6,p7,p8,p9,p10,p11));
		cat2.getProducts().addAll(Arrays.asList(p1,p2));
		cat3.getProducts().addAll(Arrays.asList(p3,p4));
		cat4.getProducts().addAll(Arrays.asList(p10,p11));
		cat5.getProducts().addAll(Arrays.asList(p12));
		cat6.getProducts().addAll(Arrays.asList(p13));
		cat7.getProducts().addAll(Arrays.asList(p14));
		cat8.getProducts().addAll(Arrays.asList(p15,p16));


		p1.getCategories().addAll(Arrays.asList(cat2,cat4));
		p2.getCategories().addAll(Arrays.asList(cat1,cat4));
		p3.getCategories().addAll(Arrays.asList(cat4, cat1, cat3));
		p4.getCategories().addAll(Arrays.asList(cat4, cat1, cat3));
		p5.getCategories().addAll(Arrays.asList(cat2,cat4));
		p6.getCategories().addAll(Arrays.asList(cat4, cat1, cat3));
		p7.getCategories().addAll(Arrays.asList(cat4, cat1, cat3));
		p8.getCategories().addAll(Arrays.asList(cat4, cat1, cat3));
		p9.getCategories().addAll(Arrays.asList(cat1,cat4));
		p10.getCategories().addAll(Arrays.asList(cat4, cat6, cat1));
		p11.getCategories().addAll(Arrays.asList(cat4, cat1, cat3));
		p12.getCategories().addAll(Arrays.asList(cat4, cat6, cat1, cat5));
		p13.getCategories().addAll(Arrays.asList(cat6, cat4));
		p14.getCategories().addAll(Arrays.asList(cat4, cat7));
		p15.getCategories().addAll(Arrays.asList(cat8, cat4, cat1));


		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8,p9,p10,p11,p12,p13,p14,p15));

		State est1 = new State(null, "Paraná");
		State est2 = new State(null, "Santa catarina");
		

		City u1 = new City(null, "Cascavel", est1);
		City u2 = new City(null, "São miguel do oeste", est2);
		City u3 = new City(null, "Realeza", est2);

		est1.getCitys().addAll(Arrays.asList(u1));
		est2.getCitys().addAll(Arrays.asList(u2, u3));
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(u1, u2, u3));

		Client cli1 = new Client(null, "Maria Silva", "Maria@Gmail.com", "07779547965", ClientType.PESSOAFISICA);
	//	Client cli2 = new Client(null, "Maria Silva", "Maria@Gmail.com", "07779547965", ClientType.PESSOAFISICA);

		cli1.getPhones().addAll(Arrays.asList("99885989", "2898591"));

		Address e1 = new Address(null, "Rua Flores", "300", "Jardim", "Floresence", "858558", cli1, u1);
		Address e2 = new Address(null, "Rua Carlos", "200", "Jardim botanico", "Clorosvaldo", "7446552", cli1, u2);
		
		cli1.getAddress().addAll(Arrays.asList(e1, e2));


		clientRepository.save(cli1);
		addressRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Order ped1 = new Order(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Order ped2 = new Order(null, sdf.parse("10/10/2021 11:32"),cli1, e2);

		Payment pagto1 = new CardPayment(null, PaymentStatus.SETTLED, ped1, 6);
		ped1.setPayment(pagto1);

		Payment pagto2 = new PaymentWithBoleto(null, PaymentStatus.PENDING, ped2, sdf.parse("20/10/2020 11:11"), null);
		ped2.setPayment(pagto2);

		cli1.getRequests().addAll(Arrays.asList(ped1, ped2));


		orderRepository.saveAll(Arrays.asList(ped1, ped2));
		paymentRepository.saveAll(Arrays.asList(pagto1, pagto2));
	
		OrderedItem ip1 = new OrderedItem(ped1, p1, 0.00, 1, 2000.00);
		OrderedItem ip2 = new OrderedItem(ped1, p3, 0.00, 2, 80.00);
		OrderedItem ip3 = new OrderedItem(ped2, p2, 0.00, 1, 800.00);
	
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p1.getItens().addAll(Arrays.asList(ip2));

		orderedItemRepository.saveAll(Arrays.asList(ip1, ip2, ip3));


	}

}



