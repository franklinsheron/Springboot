package com.libmngmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libmngmt.model.Category;
import com.libmngmt.repository.CategoryRepository;

@Service
public class CategoryService 
{
	@Autowired
	private CategoryRepository categoryrepository;
	
	public Category createCategory(Category category)
	{
		return categoryrepository.save(category);
	}
	public Category updatecategory(Category category, Long id) {
		Category existingcategory = categoryrepository.findById(id).get();
		existingcategory.setName(category.getName());
        return categoryrepository.save(existingcategory);
    }

    public void deleteCategory(Long id) {
    	Category existingcategory = categoryrepository.findById(id).get();
        categoryrepository.delete(existingcategory);
    }

    public List<Category> getAllCategory() {
        return categoryrepository.findAll();
    }
		
}
