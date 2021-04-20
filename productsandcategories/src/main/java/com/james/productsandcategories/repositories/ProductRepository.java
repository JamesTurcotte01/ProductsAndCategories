package com.james.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.james.productsandcategories.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    // this method retrieves all from the database
    List<Product> findAll();
    // this method finds artist with descriptions containing the search string
    List<Product> findByNameContaining(String name);
    // this method counts how many name contain a certain string
    Long countByNameContaining(String search);
    // this method deletes a name that starts with a specific title
    Long deleteByNameStartingWith(String search);
    
}
