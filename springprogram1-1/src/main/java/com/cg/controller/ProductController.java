package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Product;
import com.cg.exception.IdNotFoundException;
import com.cg.service.ProductServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api("ProductController")
@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductServiceI productService;
	@ApiOperation(value="addProduct")
	@PostMapping(value = "/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return new ResponseEntity<>("Added product successfully", HttpStatus.OK);
	}

	@GetMapping(value = "/getAll")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(value = "/getById/{pId}")
	public Product getProductById(@PathVariable int pId) {
		try{
			return productService.getById(pId);
			}
		catch(IdNotFoundException e) {
			throw new IdNotFoundException("no id found");
		}
	}

	
	@DeleteMapping(value="/deleteById/{pId}")
	public String deleteProductById(@PathVariable int pId) {
		productService.deleteById(pId);
		return "Deleted successfully";
	}

	/*@GetMapping(value = "/getBy")
	public Product getProductById(@RequestHeader String name, @RequestHeader String category) {
		return productService.getByNameAndCatogory(name, category);
	}*/
}
