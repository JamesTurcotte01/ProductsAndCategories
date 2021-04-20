package com.james.productsandcategories.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.james.productsandcategories.models.CategoryProduct;
import com.james.productsandcategories.models.Product;
import com.james.productsandcategories.repositories.CategoryProductRepository;
import com.james.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	   
    private final ProductRepository productRepository;
    private final CategoryProductRepository categoryProductRepository;
    
    public ProductService(ProductRepository productRepository, CategoryProductRepository categoryProductRepository) {
        this.productRepository = productRepository;
        this.categoryProductRepository = categoryProductRepository;
    }
    
    // returns all the products
    public Iterable<Product> allProducts() {
        return productRepository.findAll();
    }
    
    // creates a product
    public Product createProduct(Product b) {
        return productRepository.save(b);
    }
    
    // retrieves a product
    public Product findProducts(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    
//    public List <Product> findByArtist(String artist) {
//    	return productRepository.findByArtistContaining(Example.of(artist));
//    }
    
    
    // updates a product
	public Product updateProduct(Long id, String name) {
		  Optional<Product> optionalProduct = productRepository.findById(id);
	        if(optionalProduct.isPresent()) {
	        	Product newProduct = optionalProduct.get();
	        	newProduct.setName(name);
	        	newProduct = productRepository.save(newProduct);
	            return newProduct;
	        } else {
	            return null;
	        }
}
	
	
	// delete a product
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}
	
	public CategoryProduct saveRelationship(CategoryProduct cp) {
		return categoryProductRepository.save(cp);
	}

}
