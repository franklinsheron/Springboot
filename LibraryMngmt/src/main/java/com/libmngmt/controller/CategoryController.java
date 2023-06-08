package com.libmngmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.libmngmt.model.Category;
import com.libmngmt.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController
{
	@Autowired
	private CategoryService categoryservice;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Category create(@RequestBody Category category)
	{
		return categoryservice.createCategory(category);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Category> read()
	{
		return categoryservice.getAllCategory();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		categoryservice.deleteCategory(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public Category update(@PathVariable Long id, @RequestBody Category category) {
		return categoryservice.updatecategory(category, id);
	}

	
}
