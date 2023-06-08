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

import com.libmngmt.model.Author;
import com.libmngmt.service.AuthorService;
@RestController
@RequestMapping("/Authorss")
public class AuthorController
{
	
	@Autowired
	private AuthorService authorservice;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Author create(@RequestBody Author author)
	{
		return authorservice.createAuthor(author);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Author> read()
	{
		return authorservice.getAllAuthors();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Author read(@PathVariable Long id)
	{
		return authorservice.getAuthorsById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		authorservice.deleteAuthor(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public Author update(@PathVariable Long id, @RequestBody Author author) {
		return authorservice.updateAuthor(author, id);
	}

}
