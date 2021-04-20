package com.james.productsandcategories.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.james.productsandcategories.models.Category;
import com.james.productsandcategories.repositories.CategoryProductRepository;
import com.james.productsandcategories.repositories.CategoryRepository;


@Service
public class CategoryService {
	   
    private final CategoryRepository categoryRepository;
    private final CategoryProductRepository categoryProductRepository;
    
    public CategoryService(CategoryRepository categoryRepository, CategoryProductRepository categoryProductRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryProductRepository = categoryProductRepository;
    }
    
    // returns all the categorys
    public Iterable<Category> allCategorys() {
        return categoryRepository.findAll();
    }
    
    // creates a category
    public Category createCategory(Category b) {
        return categoryRepository.save(b);
    }
    
    // retrieves a category
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
//    public List <Category> findByArtist(String artist) {
//    	return categoryRepository.findByArtistContaining(Example.of(artist));
//    }
    
    
    // updates a category
	public Category updateCategory(Long id, String name) {
		  Optional<Category> optionalCategory = categoryRepository.findById(id);
	        if(optionalCategory.isPresent()) {
	        	Category newCategory = optionalCategory.get();
	        	newCategory.setName(name);
	        	newCategory = categoryRepository.save(newCategory);
	            return newCategory;
	        } else {
	            return null;
	        }
}
	
	
	// delete a category
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
		
	}

}
