package com.gomlek.coursemc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomlek.coursemc.entities.Category;
import com.gomlek.coursemc.repositories.CategoryRepository;
import com.gomlek.coursemc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not Found! Id: " + id + ", type: " + Category.class.getName()));
	}

	public Category insert(Category obj){
		return repository.save(obj);
	}
}
