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

import com.libmngmt.model.Book;
import com.libmngmt.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController 
{
	@Autowired
	private BookService bookservice;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book create(@RequestBody Book book)
	{
		return bookservice.createBook(book);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Book> read()
	{
		return bookservice.getAllBooks();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Book read(@PathVariable Long id)
	{
		return bookservice.getBookById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		bookservice.deleteBook(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public Book update(@PathVariable Long id, @RequestBody Book book) {
		return bookservice.updateBook(book, id);
	}

}
