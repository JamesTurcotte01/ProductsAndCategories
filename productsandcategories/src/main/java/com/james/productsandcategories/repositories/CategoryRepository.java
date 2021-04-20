package com.james.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.james.productsandcategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
    // this method retrieves all from the database
    List<Category> findAll();
    // this method finds artist with descriptions containing the search string
    List<Category> findByNameContaining(String name);
    // this method counts how many name contain a certain string
    Long countByNameContaining(String search);
    // this method deletes a name that starts with a specific title
    Long deleteByNameStartingWith(String search);
    
}
