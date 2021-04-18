package com.gomlek.coursemc.services;

import java.util.List;
import java.util.Optional;

import com.gomlek.coursemc.entities.Category;
import com.gomlek.coursemc.entities.Product;
import com.gomlek.coursemc.repositories.CategoryRepository;
import com.gomlek.coursemc.repositories.ProductRepository;
import com.gomlek.coursemc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Product find(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName()));
	}

	public Page<Product> search(String name, List<Long> ids,Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Category> categories = categoryRepository.findAllById(ids);
		return repository.findDistinctByNameContainingAndCategoriesIn(name, categories, pageRequest);
		
	}

}
