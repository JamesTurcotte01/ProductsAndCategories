package com.james.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.james.productsandcategories.models.CategoryProduct;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long>{
    // this method retrieves all from the database
    List<CategoryProduct> findAll();
    // this method finds artist with descriptions containing the search string
    //List<CategoryProduct> findByNameContaining(String name);
    // this method counts how many name contain a certain string
    Long countByIdContaining(Long id);
    // this method deletes a name that starts with a specific title
    Long deleteByIdStartingWith(Long id);
    CategoryProduct save(CategoryProduct cp);
}
