package com.gomlek.coursemc.repositories;

import java.util.List;

import com.gomlek.coursemc.entities.Category;
import com.gomlek.coursemc.entities.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Transactional(readOnly = true)
    @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cat WHERE obj.name LIKE %:name% AND cat IN :categories")
    Page<Product> findDistinctByNameContainingAndCategoriesIn(
        @Param("name") String name,
        @Param ("categories") List<Category> categories, 
        Pageable pageRequest);
}
