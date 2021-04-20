package com.james.productsandcategories.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.james.productsandcategories.models.Category;
import com.james.productsandcategories.models.CategoryProduct;
import com.james.productsandcategories.models.Product;
import com.james.productsandcategories.services.CategoryService;
import com.james.productsandcategories.services.ProductService;


@Controller
public class MainController {
	@Autowired
	private final ProductService productService;
	private final CategoryService categoryService;
	public MainController(ProductService productService, CategoryService categoryService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@RequestMapping("products/new")
	public String newProduct(@ModelAttribute("products") Product product) {
		return "NewProduct.jsp";
	}
	
	@RequestMapping("allproducts")
	public String index(Model model) {
		Iterable<Product> product = productService.allProducts();
        model.addAttribute("products", product);
        return "AllProducts.jsp";
	}
	
	@RequestMapping("allcategories")
	public String indexs(Model model) {
		Iterable<Category> category = categoryService.allCategorys();
        model.addAttribute("categorys", category);
        return "AllCategories.jsp";
	}
	
	@RequestMapping("category/new")
	public String newCategory(@ModelAttribute("categories") Category category) {
		return "NewCategory.jsp";
	}
	
	@PostMapping("/submit/products")
	public String productCreate(@Valid @ModelAttribute("products") Product product, BindingResult result) {
			productService.createProduct(product);
			return "redirect:/allproducts";
		}
	
	@PostMapping("/submit/category")
	public String categoryCreate(@ModelAttribute("category") Category category, BindingResult result) {
		categoryService.createCategory(category);
		return "redirect:/products/new";
	}
	
	@RequestMapping("products/{id}")
	public String showProducts(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", productService.findProducts(id));
		Iterable<Category> categorys = categoryService.allCategorys();
		model.addAttribute("category", categorys);
		return "ViewProduct.jsp";
	}
	
	@RequestMapping("category/{id}")
	public String showCategories(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", categoryService.findCategory(id));
		Iterable<Product> products = productService.allProducts();
		model.addAttribute("product", products);
		return "ViewCategory.jsp";
	}
	
	@PostMapping("/product/addCategory")
	public String addCategory(@RequestParam(value="product_id") Long product_id, 
			@RequestParam(value="category_id") Long category_id) {
		
		Product p = productService.findProducts(product_id);
		Category c = categoryService.findCategory(category_id);
		CategoryProduct pc = new CategoryProduct(p, c);
		productService.saveRelationship(pc);
		return "redirect:/allproducts";
	}
	
	@PostMapping("/category/addProduct")
	public String addProduct(@RequestParam(value="product_id") Long product_id, 
			@RequestParam(value="category_id") Long category_id) {
		
		Product p = productService.findProducts(product_id);
		Category c = categoryService.findCategory(category_id);
		CategoryProduct pc = new CategoryProduct(p, c);
		productService.saveRelationship(pc);
		return "redirect:/allcategories";
	}
}
