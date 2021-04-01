package com.gomlek.coursemc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gomlek.coursemc.dto.CategoryDTO;
import com.gomlek.coursemc.entities.Category;
import com.gomlek.coursemc.repositories.CategoryRepository;
import com.gomlek.coursemc.services.exceptions.DataIntegrityException;
import com.gomlek.coursemc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category find(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not Found! Id: " + id + ", type: " + Category.class.getName()));
	}

	public Category insert(Category obj){
		obj.setId(null);
		return repository.save(obj);
	}

	public Category update(Category obj){
		Category newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

    public void delete(Long id) {
		find(id);
		try{
		repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Its is not possible to exclude a category with Products ");
		}
    }

	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	} 

	public Category fromDTO(CategoryDTO objDto){
		return new Category(objDto.getId(), objDto.getName());
	}
	private void updateData(Category newObj, Category obj){
		newObj.setName(obj.getName());
	}
}
